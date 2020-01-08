package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Aquatic extends Animal {
    private Integer averageSwimDepth;
    private WaterType waterType;

    public Aquatic(Integer numberOfLegs,
                   String name,
                   Double maintenanceCost,
                   Double dangerPercent,
                   Integer averageSwimDepth,
                   WaterType waterType) {
        super(numberOfLegs,
                name,
                maintenanceCost,
                dangerPercent);
        this.averageSwimDepth = averageSwimDepth;
        this.waterType = waterType;
    }

    public Integer getAverageSwimDepth() {
        return averageSwimDepth;
    }

    public void setAverageSwimDepth(Integer averageSwimDepth) {
        this.averageSwimDepth = averageSwimDepth;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "averageSwimDepth", String.valueOf(averageSwimDepth));
        createNode(eventWriter, "waterType", String.valueOf(waterType));
    }

    @Override
    public void decodeFromXml(@NotNull Element element) {
        super.decodeFromXml(element);
        setAverageSwimDepth(Integer.
                valueOf(element.getElementsByTagName("averageSwimDepth").item(0).getTextContent()));
        setWaterType(WaterType.
                valueOf(element.getElementsByTagName("waterType").item(0).getTextContent()));
    }

    @Override
    public void setValuesFromField(@NotNull FieldValue fieldValues) {
        super.setValuesFromField(fieldValues);
        setAverageSwimDepth(Integer.valueOf(fieldValues.getValueForField("averageSwimDepth")));
        setWaterType(WaterType.valueOf(fieldValues.getValueForField("waterType")));
    }
}
