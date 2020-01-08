package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Snake extends Reptile {

    public Snake() {
        super(0,
                "Python molurus",
                4.4,
                1.0,
                true);
    }

    @SuppressWarnings("unused")
    public Snake(Integer numberOfLegs,
                 String name,
                 Double maintenanceCost,
                 Double dangerPercent,
                 Boolean laysEggs) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent,
                laysEggs);
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.Snake);
    }
}
