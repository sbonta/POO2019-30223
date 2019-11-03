package javasmmr.zoowsome.models.animals;

public class Pigeon extends Bird {

    public Pigeon() {
        setNumberOfLegs(2);
        setName("Columba livia domestica");
        setMigrates(false);
        setAverageFlightAltitude(1050);
    }

    public Pigeon(
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
