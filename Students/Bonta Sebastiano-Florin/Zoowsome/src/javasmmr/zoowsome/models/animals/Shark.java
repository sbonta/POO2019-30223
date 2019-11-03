package javasmmr.zoowsome.models.animals;

public class Shark extends Aquatic {

    public Shark() {
        setNumberOfLegs(0);
        setName("Rhincodon typus");
        setAverageSwimDepth(1800);
        setWaterType(WaterType.SALTWATER);
    }

    public Shark(
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
