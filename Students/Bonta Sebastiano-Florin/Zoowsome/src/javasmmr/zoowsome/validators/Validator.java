package javasmmr.zoowsome.validators;

import javasmmr.zoowsome.exceptions.InvalidInputException;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.validators.AnimalValidator.AnimalValidator;
import javasmmr.zoowsome.validators.EmployeeValidator.EmployeeValidator;

import java.util.ArrayList;

public class Validator {

    public static void validateObject(Object object) throws InvalidInputException {
        if (object instanceof Animal) {
            AnimalValidator.validateAnimal((Animal) object);
        } else if (object instanceof Employee) {
            EmployeeValidator.validateEmployee((Employee) object);
        }
    }

    public static void validateExistingObject(Object object, ArrayList<Object> objects) throws InvalidInputException {
        if (object instanceof Employee) {
            EmployeeValidator.validateExistingEmployee((Employee) object, objects);
        }
    }

}
