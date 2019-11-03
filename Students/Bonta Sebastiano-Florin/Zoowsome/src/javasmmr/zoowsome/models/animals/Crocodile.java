package javasmmr.zoowsome.models.animals;

public class Crocodile extends Reptile {

    public Crocodile() {
        setNumberOfLegs(4);
        setName("Crocodylus niloticus");
        setLaysEggs(true);
    }

    public Crocodile(
            Integer numberOfLegs,
            String name,
            Boolean laysEggs) {
        setNumberOfLegs(numberOfLegs);
        setName(name);
        setLaysEggs(laysEggs);
    }
}
