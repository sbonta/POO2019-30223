package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Butterfly extends Insect {

    public Butterfly() {
        super(6,
                "Laothoe populi",
                0.1,
                0.0,
                true,
                false);
    }

    @SuppressWarnings("unused")
    public Butterfly(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Butterfly);
    }
}
