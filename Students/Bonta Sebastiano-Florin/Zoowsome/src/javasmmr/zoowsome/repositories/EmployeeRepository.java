package javasmmr.zoowsome.repositories;


import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.services.constants.Constants;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

public class EmployeeRepository extends EntityRepository<Employee> {

    private static final String XML_FILENAME = "Employees.xml";

    public EmployeeRepository() {
        super(XML_FILENAME, Constants.XML_TAGS.EMPLOYEE);
    }

    @Override
    protected Employee getEntityFromXmlElement(@NotNull Element element) {
        String string = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
        Employee employee = null;

        if (Constants.Employees.Caretaker.equals(string)) {
            employee = new Caretaker();
            employee.decodeFromXml(element);
        }

        return employee;
    }
}

