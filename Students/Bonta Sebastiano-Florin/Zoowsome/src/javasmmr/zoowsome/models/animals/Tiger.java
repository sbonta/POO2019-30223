package javasmmr.zoowsome.models.animals;

public class Tiger extends Mammal {

    public Tiger() {
        setNumberOfLegs(4);
        setName("Panthera tigris");
        setNormalBodyTemperature((float) 36.4);
        setPercentBodyHair((float) 99.5);
    }

    public Tiger(
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
