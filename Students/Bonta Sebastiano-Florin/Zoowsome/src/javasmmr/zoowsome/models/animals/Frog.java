package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Frog extends Aquatic {

    public Frog() {
        super(4,
                "Agalychnis callidryas",
                0.3,
                0.2,
                100,
                WaterType.FRESHWATER);
    }

    @SuppressWarnings("unused")
    public Frog(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.Frog);
    }
}
