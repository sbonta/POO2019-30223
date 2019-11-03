package javasmmr.zoowsome.models.animals;

public class Spider extends Insect {

    public Spider() {
        setNumberOfLegs(8);
        setName("Brachypelma smithi");
        setCanFly(false);
        setDangerous(true);
    }

    public Spider(
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
