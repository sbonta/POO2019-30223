package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;

public abstract class SpeciesFactory {
    @SuppressWarnings("unused")
    public abstract Animal getAnimal(String type);
}
