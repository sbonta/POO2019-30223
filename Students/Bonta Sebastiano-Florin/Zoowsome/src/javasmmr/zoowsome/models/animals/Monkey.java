package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.services.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Monkey extends Mammal {

    public Monkey() {
        super(4,
                "Callithrix jacchus",
                2.3,
                0.2,
                37.9f,
                99.7f);
    }

    @SuppressWarnings("unused")
    public Monkey(Integer numberOfLegs,
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
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Monkey);
    }
}
