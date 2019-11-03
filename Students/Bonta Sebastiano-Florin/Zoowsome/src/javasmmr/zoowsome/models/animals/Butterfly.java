package javasmmr.zoowsome.models.animals;

public class Butterfly extends Insect {

    public Butterfly() {
        setNumberOfLegs(6);
        setName("Laothoe populi");
        setCanFly(true);
        setDangerous(false);
    }

    public Butterfly(
            Integer numberOfLegs,
            String name,
            Boolean canFly,
            Boolean dangerous) {
        setNumberOfLegs(numberOfLegs);
        setName(name);
        setCanFly(canFly);
        setDangerous(dangerous);
    }
}
