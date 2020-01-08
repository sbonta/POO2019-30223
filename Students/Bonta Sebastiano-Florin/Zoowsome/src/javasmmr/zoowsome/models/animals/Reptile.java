package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Reptile extends Animal {

    private Boolean laysEggs;

    public Reptile(Integer numberOfLegs,
                   String name,
                   Double maintenanceCost,
                   Double dangerPercent,
                   Boolean laysEggs) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent);
        this.laysEggs = laysEggs;
    }

    public Boolean getLaysEggs() {
        return laysEggs;
    }

    public void setLaysEggs(Boolean laysEggs) {
        this.laysEggs = laysEggs;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "laysEggs", String.valueOf(laysEggs));
    }

    @Override
    public void decodeFromXml(@NotNull Element element) {
        super.decodeFromXml(element);
        setLaysEggs(Boolean.valueOf(element.
                getElementsByTagName("laysEggs").item(0).getTextContent()));
    }

    @Override
    public void setValuesFromField(@NotNull FieldValue fieldValues) {
        super.setValuesFromField(fieldValues);
        setLaysEggs(Boolean.valueOf(fieldValues.getValueForField("laysEggs")));
    }
}
