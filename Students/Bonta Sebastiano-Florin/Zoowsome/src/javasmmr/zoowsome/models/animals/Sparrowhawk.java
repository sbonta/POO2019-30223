package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Sparrowhawk extends Bird {

    public Sparrowhawk() {

        super(2,
                "Accipiter nisus",
                2.0,
                0.3,
                false,
                3500);
    }

    @SuppressWarnings("unused")
    public Sparrowhawk(Integer numberOfLegs,
                       String name,
                       Double maintenanceCost,
                       Double dangerPercent,
                       Boolean migrates,
                       Integer averageFlightAltitude) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent,
                migrates,
                averageFlightAltitude);
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.Sparrowhawk);
    }
}
