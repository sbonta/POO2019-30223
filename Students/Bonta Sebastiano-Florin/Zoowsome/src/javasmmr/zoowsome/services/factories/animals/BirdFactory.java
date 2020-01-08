package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Parrot;
import javasmmr.zoowsome.models.animals.Pigeon;
import javasmmr.zoowsome.models.animals.Sparrowhawk;
import javasmmr.zoowsome.services.constants.Constants;

public class BirdFactory extends SpeciesFactory {

    @Override
    public Animal getAnimal(String type) {
        if (Constants.Animals.Birds.Parrot.equals(type)) {
            return new Parrot();
        } else if (Constants.Animals.Birds.Pigeon.equals(type)) {
            return new Pigeon();
        } else if (Constants.Animals.Birds.Sparrowhawk.equals(type)) {
            return new Sparrowhawk();
        } else {
            return null;
        }
    }
}
