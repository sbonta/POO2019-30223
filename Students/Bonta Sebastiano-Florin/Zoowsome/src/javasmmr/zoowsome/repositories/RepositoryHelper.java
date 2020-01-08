package javasmmr.zoowsome.repositories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.employees.Employee;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class RepositoryHelper {
    @NotNull
    public static ArrayList<Object> importAll() {
        ArrayList<Object> all = new ArrayList<>();

        AnimalRepository animalRepository = new AnimalRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        try {
            ArrayList<Animal> animals = animalRepository.load();
            all.addAll(animals);
            ArrayList<Employee> employees = employeeRepository.load();
            all.addAll(employees);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException | IOException ignored) {
        }

        return all;
    }

    public static void exportAll(@NotNull ArrayList<Object> objects) throws FileNotFoundException, XMLStreamException {
        AnimalRepository animalRepository = new AnimalRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();


        for (Object object : objects) {
            if (object instanceof Animal) {
                animals.add((Animal) object);
            } else if (object instanceof Employee) {
                employees.add((Employee) object);
            }
        }

        animalRepository.save(animals);
        employeeRepository.save(employees);
    }
}
