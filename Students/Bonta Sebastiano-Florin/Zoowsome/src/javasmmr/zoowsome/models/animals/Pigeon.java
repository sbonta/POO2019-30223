package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Pigeon extends Bird {

    public Pigeon() {
        super(2,
                "Columba livia domestica",
                0.3,
                0.1,
                false,
                1050);
    }

    @SuppressWarnings("unused")
    public Pigeon(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.Pigeon);
    }
}
