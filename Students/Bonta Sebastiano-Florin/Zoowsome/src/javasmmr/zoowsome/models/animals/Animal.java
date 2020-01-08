package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.models.interfaces.Killer;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Animal implements Killer, XML_Parsable {
    private Integer numberOfLegs;
    private String name;
    private Double maintenanceCost;
    private Double dangerPercent;
    private Boolean takenCareOf;

    public Animal(Integer numberOfLegs,
                  String name,
                  Double maintenanceCost,
                  Double dangerPercent) {
        this.numberOfLegs = numberOfLegs;
        this.name = name;
        this.maintenanceCost = maintenanceCost;
        this.dangerPercent = dangerPercent;
        this.takenCareOf = false;
    }

    public Integer getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(Integer numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public Double getDangerPercent() {
        return dangerPercent;
    }

    public void setDangerPercent(Double dangerPercent) {
        this.dangerPercent = dangerPercent;
    }

    public Boolean getTakenCareOf() {
        return takenCareOf;
    }

    public void setTakenCareOf(Boolean takenCareOf) {
        this.takenCareOf = takenCareOf;
    }

    @Override
    public boolean kill() {
        return Math.random() < dangerPercent;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        createNode(eventWriter, "numberOfLegs", String.valueOf(numberOfLegs));
        createNode(eventWriter, "name", String.valueOf(name));
        createNode(eventWriter, "maintenanceCost", String.valueOf(maintenanceCost));
        createNode(eventWriter, "dangerPercent", String.valueOf(dangerPercent));
        createNode(eventWriter, "takenCareOf", String.valueOf(takenCareOf));
    }

    @Override
    public void decodeFromXml(@NotNull Element element) {
        setNumberOfLegs(Integer.valueOf(element.
                getElementsByTagName("numberOfLegs").item(0).getTextContent()));
        setName(String.valueOf(element.
                getElementsByTagName("name").item(0).getTextContent()));
        setMaintenanceCost(Double.valueOf(element.
                getElementsByTagName("maintenanceCost").item(0).getTextContent()));
        setDangerPercent(Double.valueOf(element.
                getElementsByTagName("dangerPercent").item(0).getTextContent()));
        setTakenCareOf(Boolean.valueOf(element.
                getElementsByTagName("takenCareOf").item(0).getTextContent()));
    }

    @Override
    public void setValuesFromField(@NotNull FieldValue fieldValues) {
        setNumberOfLegs(Integer.valueOf(fieldValues.getValueForField("numberOfLegs")));
        setName(String.valueOf(fieldValues.getValueForField("name")));
        setMaintenanceCost(Double.valueOf(fieldValues.getValueForField("maintenanceCost")));
        setDangerPercent(Double.valueOf(fieldValues.getValueForField("dangerPercent")));
        setTakenCareOf(Boolean.valueOf(fieldValues.getValueForField("takenCareOf")));
    }
}
