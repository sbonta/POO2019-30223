package javasmmr.zoowsome.models.animals;

public class Monkey extends Mammal {

    public Monkey() {
        setNumberOfLegs(4);
        setName("Callithrix jacchus");
        setNormalBodyTemperature((float) 37.9);
        setPercentBodyHair((float) 99.7);
    }

    public Monkey(
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
