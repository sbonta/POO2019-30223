package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Tiger extends Mammal {

    public Tiger() {
        super(4,
                "Panthera tigris",
                4.2,
                0.9,
                36.4f,
                99.5f);
    }

    @SuppressWarnings("unused")
    public Tiger(Integer numberOfLegs,
                 String name,
                 Double maintenanceCost,
                 Double dangerPercent,
                 Float normalBodyTemperature,
                 Float percentBodyHair) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent,
                normalBodyTemperature,
                percentBodyHair);
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Tiger);
    }
}
