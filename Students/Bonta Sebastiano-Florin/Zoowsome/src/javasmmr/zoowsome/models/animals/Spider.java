package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Spider extends Insect {

    public Spider() {
        super(8,
                "Brachypelma smithi",
                0.2,
                0.7,
                false,
                true);
    }

    @SuppressWarnings("unused")
    public Spider(Integer numberOfLegs,
                  String name,
                  Double maintenanceCost,
                  Double dangerPercent,
                  Boolean canFly,
                  Boolean isDangerous) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent,
                canFly,
                isDangerous);
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Spider);
    }
}
