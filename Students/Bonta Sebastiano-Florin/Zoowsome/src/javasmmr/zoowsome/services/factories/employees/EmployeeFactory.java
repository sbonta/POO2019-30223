package javasmmr.zoowsome.services.factories.employees;

import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.services.constants.Constants;

@SuppressWarnings("unused")
public class EmployeeFactory {
    public Employee getEmployee(String type) {
        if (Constants.Employees.Caretaker.equals(type)) {
            return new Caretaker();
        } else {
            return null;
        }
    }
}
