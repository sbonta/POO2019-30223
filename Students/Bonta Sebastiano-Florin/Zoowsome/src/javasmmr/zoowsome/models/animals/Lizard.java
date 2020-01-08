package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Lizard extends Reptile {

    public Lizard() {
        super(4,
                "Podarcis siculus",
                3.2,
                0.2,
                true);
    }

    @SuppressWarnings("unused")
    public Lizard(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.Lizard);
    }
}
