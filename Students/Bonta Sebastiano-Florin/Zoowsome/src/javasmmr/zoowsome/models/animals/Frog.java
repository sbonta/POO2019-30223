package javasmmr.zoowsome.models.animals;

public class Frog extends Aquatic {

    public Frog() {
        setNumberOfLegs(4);
        setName("Agalychnis callidryas");
        setAverageSwimDepth(100);
        setWaterType(WaterType.FRESHWATER);
    }

    public Frog(
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
