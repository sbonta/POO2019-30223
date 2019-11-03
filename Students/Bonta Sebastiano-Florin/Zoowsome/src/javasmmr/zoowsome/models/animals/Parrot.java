package javasmmr.zoowsome.models.animals;

public class Parrot extends Bird {

    public Parrot() {
        setNumberOfLegs(2);
        setName("Psittacus erithacus");
        setMigrates(false);
        setAverageFlightAltitude(250);
    }

    public Parrot(
            Integer numberOfLegs,
            String name,
            Boolean migrates,
            Integer averageFlightAltitude) {
        setNumberOfLegs(numberOfLegs);
        setName(name);
        setMigrates(migrates);
        setAverageFlightAltitude(averageFlightAltitude);
    }

}
