package javasmmr.zoowsome.validators.AnimalValidator;

import javasmmr.zoowsome.exceptions.InvalidInputException;
import javasmmr.zoowsome.models.animals.*;
import org.jetbrains.annotations.NotNull;

public class AnimalValidator {

    private static void validateNumberOfLegs(Integer numberOfLegs) throws InvalidInputException {
        if (numberOfLegs < 0) {
            throw new InvalidInputException("Invalid number of legs");
        }
    }

    private static void validateName(@NotNull String name) throws InvalidInputException {
        if (name.length() == 0) {
            throw new InvalidInputException("Name can not be empty");
        }
    }

    private static void validateMaintenanceCost(Double maintenanceCost) throws InvalidInputException {
        if (maintenanceCost < 0 || maintenanceCost > 8) {
            throw new InvalidInputException("Invalid maintenance cost");
        }
    }

    private static void validateDangerPercent(Double dangerPercent) throws InvalidInputException {
        if (dangerPercent < 0 || dangerPercent > 1) {
            throw new InvalidInputException("Invalid danger percent");
        }
    }

    private static void validateTakenCareOf(@SuppressWarnings("unused") Boolean takenCareOf) {
    }

    public static void validateAnimal(@NotNull Animal animal) throws InvalidInputException {
        validateNumberOfLegs(animal.getNumberOfLegs());
        validateName(animal.getName());
        validateMaintenanceCost(animal.getMaintenanceCost());
        validateDangerPercent(animal.getDangerPercent());
        validateTakenCareOf(animal.getTakenCareOf());

        if (animal instanceof Aquatic) {
            AquaticValidator.validateAquatic((Aquatic) animal);
        } else if (animal instanceof Bird) {
            BirdValidator.validateBird((Bird) animal);
        } else if (animal instanceof Insect) {
            InsectValidator.validateInsect((Insect) animal);
        } else if (animal instanceof Mammal) {
            MammalValidator.validateMammal((Mammal) animal);
        } else if (animal instanceof Reptile) {
            ReptileValidator.validateReptile((Reptile) animal);
        }
    }

    private static class AquaticValidator {
        private static void validateAverageSwimDepth(Integer averageSwimDepth) throws InvalidInputException {
            if (averageSwimDepth < 0) {
                throw new InvalidInputException("Invalid average swim depth");
            }
        }

        private static void validateWaterType(@SuppressWarnings("unused") WaterType waterType) {
        }

        private static void validateAquatic(@NotNull Aquatic aquatic) throws InvalidInputException {
            validateAverageSwimDepth(aquatic.getAverageSwimDepth());
            validateWaterType(aquatic.getWaterType());
        }
    }

    private static class BirdValidator {
        private static void validateAverageFlightAltitude(Integer averageFlightAltitude) throws InvalidInputException {
            if (averageFlightAltitude < 0) {
                throw new InvalidInputException("Invalid average flight altitude");
            }
        }

        private static void validateMigrates(@SuppressWarnings("unused") Boolean migrates) {
        }

        private static void validateBird(@NotNull Bird bird) throws InvalidInputException {
            validateAverageFlightAltitude(bird.getAverageFlightAltitude());
            validateMigrates(bird.getMigrates());
        }
    }

    private static class InsectValidator {
        private static void validateCanFly(@SuppressWarnings("unused") Boolean canFly) {
        }

        private static void validateDangerous(@SuppressWarnings("unused") Boolean dangerous) {
        }

        private static void validateInsect(@NotNull Insect insect) {
            validateCanFly(insect.getCanFly());
            validateDangerous(insect.getDangerous());
        }
    }

    private static class MammalValidator {
        private static void validateNormalBodyTemperature(@SuppressWarnings("unused") Float normalBodyTemperature) {
        }

        private static void validatePercentBodyHair(Float percentBodyHair) throws InvalidInputException {
            if (percentBodyHair < 0 || percentBodyHair > 100) {
                throw new InvalidInputException("Invalid percent body hair");
            }
        }

        private static void validateMammal(@NotNull Mammal mammal) throws InvalidInputException {
            validateNormalBodyTemperature(mammal.getNormalBodyTemperature());
            validatePercentBodyHair(mammal.getPercentBodyHair());
        }
    }

    private static class ReptileValidator {
        private static void validateLaysEggs(@SuppressWarnings("unused") Boolean laysEgg) {
        }

        private static void validateReptile(@NotNull Reptile reptile) {
            validateLaysEggs(reptile.getLaysEggs());
        }
    }
}
