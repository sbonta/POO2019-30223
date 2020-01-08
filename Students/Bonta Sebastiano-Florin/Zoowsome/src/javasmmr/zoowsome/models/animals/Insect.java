package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Insect extends Animal {
    private Boolean canFly;
    private Boolean isDangerous;

    public Insect(Integer numberOfLegs,
                  String name,
                  Double maintenanceCost,
                  Double dangerPercent,
                  Boolean canFly,
                  Boolean isDangerous) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent);
        this.canFly = canFly;
        this.isDangerous = isDangerous;
    }

    public Boolean getCanFly() {
        return canFly;
    }

    public void setCanFly(Boolean canFly) {
        this.canFly = canFly;
    }

    public Boolean getDangerous() {
        return isDangerous;
    }

    public void setDangerous(Boolean dangerous) {
        isDangerous = dangerous;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "canFly", String.valueOf(canFly));
        createNode(eventWriter, "isDangerous", String.valueOf(isDangerous));
    }

    @Override
    public void decodeFromXml(@NotNull Element element) {
        super.decodeFromXml(element);
        setCanFly(Boolean.valueOf(element.
                getElementsByTagName("canFly").item(0).getTextContent()));
        setDangerous(Boolean.valueOf(element.
                getElementsByTagName("isDangerous").item(0).getTextContent()));

    }

    @Override
    public void setValuesFromField(@NotNull FieldValue fieldValues) {
        super.setValuesFromField(fieldValues);
        setCanFly(Boolean.valueOf(fieldValues.getValueForField("canFly")));
        setDangerous(Boolean.valueOf(fieldValues.getValueForField("isDangerous")));
    }
}
