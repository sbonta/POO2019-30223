package javasmmr.zoowsome.models.animals;

public class Cow extends Mammal {

    public Cow() {
        setNumberOfLegs(4);
        setName("Bos taurus");
        setNormalBodyTemperature((float) 39.9);
        setPercentBodyHair((float) 99.7);
    }

    public Cow(
            Integer numberOfLegs,
            String name,
            Float normalBodyTemperature,
            Float percentBodyHair) {
        setNumberOfLegs(numberOfLegs);
        setName(name);
        setNormalBodyTemperature(normalBodyTemperature);
        setPercentBodyHair(percentBodyHair);
    }
}
