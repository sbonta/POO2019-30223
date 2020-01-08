package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Crocodile extends Reptile {

    public Crocodile() {
        super(4,
                "Crocodylus niloticus",
                7.7,
                0.9,
                true);
    }

    @SuppressWarnings("unused")
    public Crocodile(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.Crocodile);
    }
}
