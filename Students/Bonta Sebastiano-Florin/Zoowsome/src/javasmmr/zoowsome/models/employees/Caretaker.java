package javasmmr.zoowsome.models.employees;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.interfaces.Caretaker_I;
import javasmmr.zoowsome.services.constants.Constants;
import javasmmr.zoowsome.views.utilities.FieldValue;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Caretaker extends Employee implements Caretaker_I {
    private Double workingHours;

    public Caretaker() {
        super("Joshua",
                1L,
                BigDecimal.valueOf(3422));
        this.workingHours = 40d;
    }

    public Caretaker(String name,
                     Long id,
                     BigDecimal salary,
                     Double workingHours) {
        super(name, id, salary);
        this.workingHours = workingHours;
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String takeCareOf(@NotNull Animal animal) {
        if (animal.kill()) {
            setDead(true);
            return Constants.Employees.Caretakers.TCO_KILLED;
        }
        if (this.workingHours < animal.getMaintenanceCost()) {
            return Constants.Employees.Caretakers.TCO_NO_TIME;
        }

        animal.setTakenCareOf(true);
        workingHours = workingHours - animal.getMaintenanceCost();
        return Constants.Employees.Caretakers.TCO_SUCCESS;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        createNode(eventWriter, "workingHours", String.valueOf(workingHours));
        createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Employees.Caretaker);
    }

    @Override
    public void decodeFromXml(Element element) {
        super.decodeFromXml(element);
        setWorkingHours(Double.valueOf(element.
                getElementsByTagName("workingHours").item(0).getTextContent()));
    }

    @Override
    public void setValuesFromField(FieldValue fieldValues) {
        super.setValuesFromField(fieldValues);
        setWorkingHours(Double.valueOf(fieldValues.getValueForField("workingHours")));
    }
}
