package javasmmr.zoowsome.models.employees;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.views.utilities.FieldValue;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public abstract class Employee implements XML_Parsable {
    private String name;
    private Long id;
    private BigDecimal salary;
    private Boolean isDead;

    public Employee(String name,
                    Long id,
                    BigDecimal salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.isDead = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDead() {
        return isDead;
    }

    public void setDead(Boolean dead) {
        isDead = dead;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        createNode(eventWriter, "name", String.valueOf(name));
        createNode(eventWriter, "id", String.valueOf(id));
        createNode(eventWriter, "isDead", String.valueOf(isDead));
        createNode(eventWriter, "salary", String.valueOf(salary));
    }

    @Override
    public void decodeFromXml(Element element) {
        setName(String.valueOf(element.
                getElementsByTagName("name").item(0).getTextContent()));
        setId(Long.valueOf(element.
                getElementsByTagName("id").item(0).getTextContent()));
        setDead(Boolean.valueOf(element.
                getElementsByTagName("isDead").item(0).getTextContent()));
        setSalary(BigDecimal.valueOf(Double.parseDouble(element.
                getElementsByTagName("salary").item(0).getTextContent())));
    }

    @Override
    public void setValuesFromField(FieldValue fieldValues) {
        setName(String.valueOf(fieldValues.getValueForField("name")));
        setId(Long.valueOf(fieldValues.getValueForField("id")));
        setDead(Boolean.valueOf(fieldValues.getValueForField("isDead")));
        setSalary(BigDecimal.valueOf(Double.parseDouble(fieldValues.getValueForField("salary"))));
    }
}
