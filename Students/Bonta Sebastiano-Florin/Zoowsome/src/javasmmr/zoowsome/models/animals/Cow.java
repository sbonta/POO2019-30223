package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Cow extends Mammal {

    public Cow() {
        super(4,
                "Bos taurus",
                5.3,
                0.4,
                39.9f,
                99.7f);
    }

    @SuppressWarnings("unused")
    public Cow(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Cow);
    }
}
