package javasmmr.zoowsome.repositories;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.services.constants.Constants;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public abstract class EntityRepository<T extends XML_Parsable> {
    private final String xmlFile;
    private final String entityTag;

    public EntityRepository(String xmlFile, String entityTag) {
        this.xmlFile = xmlFile;
        this.entityTag = entityTag;
    }

    public static void createNode(@NotNull XMLEventWriter eventWriter, String name, String value)
            throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        StartElement startElement = eventFactory.createStartElement("",
                "",
                name);
        eventWriter.add(tab);
        eventWriter.add(startElement);
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        EndElement endElement = eventFactory.createEndElement("",
                "",
                name);
        eventWriter.add(endElement);
        eventWriter.add(end);
    }

    protected abstract T getEntityFromXmlElement(Element element);

    public void save(@NotNull ArrayList<T> entities) throws FileNotFoundException, XMLStreamException {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(xmlFile));
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);
        StartElement element = eventFactory.createStartElement("",
                "",
                "content");
        eventWriter.add(element);
        eventWriter.add(end);

        for (XML_Parsable entity : entities) {
            StartElement startElement = eventFactory.createStartElement("",
                    "",
                    entityTag);
            eventWriter.add(startElement);
            eventWriter.add(end);

            entity.encodeToXml(eventWriter);

            EndElement endElement = eventFactory.createEndElement("",
                    "",
                    entityTag);
            eventWriter.add(endElement);
            eventWriter.add(end);
        }

        eventWriter.add(eventFactory.createEndElement("",
                "",
                "content"));
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }

    public ArrayList<T> load() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<T> entities = new ArrayList<>();
        File file = new File(xmlFile);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName(entityTag);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                entities.add(getEntityFromXmlElement(element));
            }
        }

        return entities;
    }
}
