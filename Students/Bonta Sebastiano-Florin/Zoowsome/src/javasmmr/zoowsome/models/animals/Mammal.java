package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Mammal extends Animal {

    private Float normalBodyTemperature;
    private Float percentBodyHair;

    public Mammal(Integer numberOfLegs,
                  String name,
                  Double maintenanceCost,
                  Double dangerPercent,
                  Float normalBodyTemperature,
                  Float percentBodyHair) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent);
        this.normalBodyTemperature = normalBodyTemperature;
        this.percentBodyHair = percentBodyHair;
    }

    public Float getPercentBodyHair() {
        return percentBodyHair;
    }

    public void setPercentBodyHair(Float percentBodyHair) {
        this.percentBodyHair = percentBodyHair;
    }

    public Float getNormalBodyTemperature() {
        return normalBodyTemperature;
    }

    public void setNormalBodyTemperature(Float normalBodyTemperature) {
        this.normalBodyTemperature = normalBodyTemperature;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "percentBodyHair", String.valueOf(percentBodyHair));
        createNode(eventWriter, "normalBodyTemperature", String.valueOf(normalBodyTemperature));
    }

    @Override
    public void decodeFromXml(@NotNull Element element) {
        super.decodeFromXml(element);
        setPercentBodyHair(Float.valueOf(element.
                getElementsByTagName("percentBodyHair").item(0).getTextContent()));
        setNormalBodyTemperature(Float.valueOf(element.
                getElementsByTagName("normalBodyTemperature").item(0).getTextContent()));
    }

    @Override
    public void setValuesFromField(@NotNull FieldValue fieldValues) {
        super.setValuesFromField(fieldValues);
        setPercentBodyHair(Float.valueOf(fieldValues.getValueForField("percentBodyHair")));
        setNormalBodyTemperature(Float.valueOf(fieldValues.getValueForField("normalBodyTemperature")));
    }
}
