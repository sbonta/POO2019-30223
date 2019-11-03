package javasmmr.zoowsome.models.animals;

public class Snake extends Reptile {

    public Snake() {
        setNumberOfLegs(0);
        setName("Python molurus");
        setLaysEggs(true);
    }

    public Snake(
            Integer numberOfLegs,
            String name,
            Boolean laysEggs) {
        setNumberOfLegs(numberOfLegs);
        setName(name);
        setLaysEggs(laysEggs);
    }
}
