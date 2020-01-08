package javasmmr.zoowsome.repositories;

import javasmmr.zoowsome.models.animals.*;
import javasmmr.zoowsome.services.constants.Constants;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

public class AnimalRepository extends EntityRepository<Animal> {

    private static final String XML_FILENAME = "Animals.xml";

    public AnimalRepository() {
        super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);
    }

    @Override
    protected Animal getEntityFromXmlElement(@NotNull Element element) {
        String string = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
        Animal animal = null;
        switch (string) {
            case Constants.Animals.Aquatics.Crab:
                animal = new Crab();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Aquatics.Frog:
                animal = new Frog();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Aquatics.Shark:
                animal = new Shark();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Birds.Parrot:
                animal = new Parrot();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Birds.Pigeon:
                animal = new Pigeon();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Birds.Sparrowhawk:
                animal = new Sparrowhawk();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Insects.Butterfly:
                animal = new Butterfly();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Insects.Cockroach:
                animal = new Cockroach();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Insects.Spider:
                animal = new Spider();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Mammals.Cow:
                animal = new Cow();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Mammals.Monkey:
                animal = new Monkey();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Mammals.Tiger:
                animal = new Tiger();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Reptiles.Crocodile:
                animal = new Crocodile();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Reptiles.Lizard:
                animal = new Lizard();
                animal.decodeFromXml(element);
                break;
            case Constants.Animals.Reptiles.Snake:
                animal = new Snake();
                animal.decodeFromXml(element);
                break;
            default:
                break;
        }

        return animal;
    }
}
