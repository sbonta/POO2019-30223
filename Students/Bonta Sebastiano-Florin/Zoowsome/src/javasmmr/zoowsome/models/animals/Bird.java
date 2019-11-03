package javasmmr.zoowsome.models.animals;

public abstract class Bird extends Animal {
    private Boolean migrates;
    private Integer averageFlightAltitude;

    public Boolean getMigrates() {
        return migrates;
    }

    public void setMigrates(Boolean migrates) {
        this.migrates = migrates;
    }

    public Integer getAverageFlightAltitude() {
        return averageFlightAltitude;
    }

    public void setAverageFlightAltitude(Integer averageFlightAltitude) {
        this.averageFlightAltitude = averageFlightAltitude;
    }
}
