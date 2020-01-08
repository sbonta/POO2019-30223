package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Crab;
import javasmmr.zoowsome.models.animals.Frog;
import javasmmr.zoowsome.models.animals.Shark;
import javasmmr.zoowsome.services.constants.Constants;

public class AquaticFactory extends SpeciesFactory {

    @Override
    public Animal getAnimal(String type) {
        if (Constants.Animals.Aquatics.Crab.equals(type)) {
            return new Crab();
        } else if (Constants.Animals.Aquatics.Frog.equals(type)) {
            return new Frog();
        } else if (Constants.Animals.Aquatics.Shark.equals(type)) {
            return new Shark();
        } else {
            return null;
        }
    }
}
