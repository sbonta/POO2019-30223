package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Crab extends Aquatic {

    public Crab() {
        super(8,
                "Liocarcinus vernalis",
                0.4,
                0.2,
                50,
                WaterType.SALTWATER);
        setNumberOfLegs(8);
        setName("Liocarcinus vernalis");
        setAverageSwimDepth(50);
        setWaterType(WaterType.SALTWATER);
    }

    @SuppressWarnings("unused")
    public Crab(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.Crab);
    }
}
