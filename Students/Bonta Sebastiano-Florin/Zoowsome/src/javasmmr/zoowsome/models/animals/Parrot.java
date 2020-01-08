package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Parrot extends Bird {

    public Parrot() {
        super(2,
                "Psittacus erithacus",
                0.3,
                0.1,
                false,
                250);
    }

    @SuppressWarnings("unused")
    public Parrot(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.Parrot);
    }
}
