package javasmmr.zoowsome.validators.EmployeeValidator;

import javasmmr.zoowsome.exceptions.InvalidInputException;
import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.models.employees.Employee;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EmployeeValidator {

    private static void validateName(@NotNull String name) throws InvalidInputException {
        if (name.length() == 0) {
            throw new InvalidInputException("Name can not be empty");
        }
    }

    private static void validateId(Long id) throws InvalidInputException {
        if (id < 1e13 || id > 1e14) {
            throw new InvalidInputException("Invalid id");
        }
    }

    private static void validateSalary(@NotNull BigDecimal salary) throws InvalidInputException {
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInputException("Invalid salary");
        }
    }

    private static void validateDead(@SuppressWarnings("unused") Boolean isDead) {
    }

    public static void validateEmployee(@NotNull Employee employee) throws InvalidInputException {
        validateName(employee.getName());
        validateId(employee.getId());
        validateSalary(employee.getSalary());
        validateDead(employee.getDead());

        if (employee instanceof Caretaker) {
            CaretakerValidator.validateCaretaker((Caretaker) employee);
        }
    }

    public static void validateExistingEmployee(Employee employee, @NotNull ArrayList<Object> objects)
            throws InvalidInputException {
        for (Object o : objects) {
            if (o instanceof Employee) {
                Employee e = (Employee) o;
                if (employee.getId().equals(e.getId())) {
                    throw new InvalidInputException("Employee already exists");
                }
            }
        }

    }

    private static class CaretakerValidator {
        private static void validateWorkingHours(Double workingHours) throws InvalidInputException {
            if (workingHours <= 0 || workingHours > 40) {
                throw new InvalidInputException("Working hours must be between 0 and 40");
            }
        }

        public static void validateCaretaker(@NotNull Caretaker caretaker) throws InvalidInputException {
            validateWorkingHours(caretaker.getWorkingHours());
        }
    }
}
