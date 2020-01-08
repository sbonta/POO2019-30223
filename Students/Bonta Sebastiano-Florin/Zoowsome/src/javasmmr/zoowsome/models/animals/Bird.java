package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Bird extends Animal {
    private Boolean migrates;
    private Integer averageFlightAltitude;

    public Bird(Integer numberOfLegs,
                String name,
                Double maintenanceCost,
                Double dangerPercent,
                Boolean migrates,
                Integer averageFlightAltitude) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent);
        this.migrates = migrates;
        this.averageFlightAltitude = averageFlightAltitude;
    }

    public Boolean getMigrates() {
        return migrates;
    }

    public void setMigrates(Boolean migrates) {
        this.migrates = migrates;
    }

    public Integer getAverageFlightAltitude() {
        return averageFlightAltitude;
    }

    public void setAverageFlightAltitude(Integer averageFlightAltitude) {
        this.averageFlightAltitude = averageFlightAltitude;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "migrates", String.valueOf(migrates));
        createNode(eventWriter, "averageFlightAltitude", String.valueOf(averageFlightAltitude));
    }

    @Override
    public void decodeFromXml(@NotNull Element element) {
        super.decodeFromXml(element);
        setMigrates(Boolean.valueOf(element.
                getElementsByTagName("migrates").item(0).getTextContent()));
        setAverageFlightAltitude(Integer.valueOf(element.
                getElementsByTagName("averageFlightAltitude").item(0).getTextContent()));

    }

    @Override
    public void setValuesFromField(@NotNull FieldValue fieldValues) {
        super.setValuesFromField(fieldValues);
        setMigrates(Boolean.valueOf(fieldValues.getValueForField("migrates")));
        setAverageFlightAltitude(Integer.valueOf(fieldValues.getValueForField("averageFlightAltitude")));
    }
}
