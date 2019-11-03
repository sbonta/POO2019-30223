package javasmmr.zoowsome.models.animals;

public class Crab extends Aquatic {

    public Crab() {
        setNumberOfLegs(8);
        setName("Liocarcinus vernalis");
        setAverageSwimDepth(50);
        setWaterType(WaterType.SALTWATER);
    }

    public Crab(
            Integer numberOfLegs,
            String name,
            Integer averageSwimDepth,
            WaterType waterType) {
        setNumberOfLegs(numberOfLegs);
        setName(name);
        setAverageSwimDepth(averageSwimDepth);
        setWaterType(waterType);
    }
}
