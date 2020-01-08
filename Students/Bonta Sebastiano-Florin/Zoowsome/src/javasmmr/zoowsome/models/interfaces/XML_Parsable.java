package javasmmr.zoowsome.models.interfaces;

import javasmmr.zoowsome.views.utilities.FieldValue;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public interface XML_Parsable {
    void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException;

    void decodeFromXml(Element element);

    void setValuesFromField(FieldValue fieldValues);
}
