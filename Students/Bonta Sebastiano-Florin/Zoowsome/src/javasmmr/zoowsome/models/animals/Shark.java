package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Shark extends Aquatic {

    public Shark() {
        super(0,
                "Rhincodon typus",
                6.6,
                1.0,
                1800,
                WaterType.SALTWATER);
    }

    @SuppressWarnings("unused")
    public Shark(Integer numberOfLegs,
                 String name,
                 Double maintenanceCost,
                 Double dangerPercent,
                 Integer averageSwimDepth,
                 WaterType waterType) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent,
                averageSwimDepth,
                waterType);
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.Shark);
    }
}
