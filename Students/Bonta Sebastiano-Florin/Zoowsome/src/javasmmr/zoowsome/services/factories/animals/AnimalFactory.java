package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.services.constants.Constants;

@SuppressWarnings("unused")
public class AnimalFactory {
    public SpeciesFactory getSpeciesFactory(String type) {
        if (Constants.Species.Mammals.equals(type)) {
            return new MammalFactory();
        } else if (Constants.Species.Reptiles.equals(type)) {
            return new ReptileFactory();
        } else if (Constants.Species.Birds.equals(type)) {
            return new BirdFactory();
        } else if (Constants.Species.Aquatics.equals(type)) {
            return new AquaticFactory();
        } else if (Constants.Species.Insects.equals(type)) {
            return new InsectFactory();
        } else {
            return null;
        }
    }
}
