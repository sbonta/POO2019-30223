package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.services.factories.AnimalFactory;
import javasmmr.zoowsome.services.factories.Constants;
import javasmmr.zoowsome.services.factories.SpeciesFactory;

public class MainController {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        SpeciesFactory speciesFactory =
                animalFactory.getSpeciesFactory(Constants.Species.Mammals);
        Animal animal = speciesFactory.getAnimal(Constants.Animals.Mammals.Cow);

        System.out.printf("We have an animal with %d legs\n",
                animal.getNumberOfLegs());
    }
}
