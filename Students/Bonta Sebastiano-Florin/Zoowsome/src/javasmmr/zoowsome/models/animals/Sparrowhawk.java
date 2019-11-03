package javasmmr.zoowsome.models.animals;

public class Sparrowhawk extends Bird {

    public Sparrowhawk() {
        setNumberOfLegs(2);
        setName("Accipiter nisus");
        setMigrates(false);
        setAverageFlightAltitude(3500);
    }

    public Sparrowhawk(
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
