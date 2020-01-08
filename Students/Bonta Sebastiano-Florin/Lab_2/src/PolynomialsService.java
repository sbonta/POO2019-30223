import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class PolynomialsService {
    public ArrayList<Polynomial> readPolynomials(String filename) {
        ArrayList<ArrayList<BigDecimal>> input = IOHelper.read2ArraysFromFile(filename);
        ArrayList<Polynomial> result = new ArrayList<>();
        result.add(new Polynomial(input.get(0)));
        result.add(new Polynomial(input.get(1)));

        return result;
    }

    public Polynomial addPolynomials(@NotNull Polynomial firstPolynomial,
                                     @NotNull Polynomial secondPolynomial,
                                     BigDecimal multiplicationFactor) {
        ArrayList<BigDecimal> coefficients = new ArrayList<>();
        BigDecimal coefficient;
        int coefficientDifference = Math.abs(firstPolynomial.getPower() -
                secondPolynomial.getPower());

        for (int i = 0; i < coefficientDifference; i++) {
            if (firstPolynomial.getPower() > secondPolynomial.getPower()) {
                coefficients.add(firstPolynomial.getCoefficients().get(i));
            } else {
                coefficients.add(secondPolynomial.getCoefficients().get(i).multiply(multiplicationFactor));
            }
        }

        for (int i = 0; i < Math.min(firstPolynomial.getPower(),
                secondPolynomial.getPower()); i++) {
            if (firstPolynomial.getPower() > secondPolynomial.getPower()) {
                coefficient = firstPolynomial.getCoefficients().get(coefficientDifference + i);
                coefficient = coefficient.add(secondPolynomial.getCoefficients().get(i).multiply(multiplicationFactor));
            } else {
                coefficient = secondPolynomial.getCoefficients().get(coefficientDifference + i).multiply(
                        multiplicationFactor);
                coefficient = coefficient.add(firstPolynomial.getCoefficients().get(i));
            }
            coefficients.add(coefficient);
        }

        return new Polynomial(coefficients);
    }

    public Polynomial addPolynomials(Polynomial firstPolynomial,
                                     Polynomial secondPolynomial) {
        return addPolynomials(firstPolynomial, secondPolynomial, BigDecimal.ONE);
    }

    public Polynomial subtractPolynomials(Polynomial firstPolynomial,
                                          Polynomial secondPolynomial) {
        return addPolynomials(firstPolynomial, secondPolynomial, BigDecimal.valueOf(-1));
    }

    public Polynomial multiplyPolynomials(@NotNull Polynomial firstPolynomial,
                                          Polynomial secondPolynomial) {
        ArrayList<Polynomial> results = new ArrayList<>();
        Polynomial result;

        for (int i = 0; i < firstPolynomial.getPower(); i++) {
            result = secondPolynomial.createCopy();
            for (int j = 0; j < firstPolynomial.getPower() - i - 1; j++) {
                result.increasePower();
            }
            result.multiplyByScalar(firstPolynomial.getCoefficients().get(i));
            results.add(result);
        }

        result = results.get(0);
        for (int i = 1; i < firstPolynomial.getPower(); i++) {
            result = addPolynomials(result, results.get(i));
        }

        return result;
    }

    public ArrayList<Polynomial> dividePolynomials(@NotNull Polynomial firstPolynomial,
                                                   @NotNull Polynomial secondPolynomial) {
        MathContext mathContext = new MathContext(5);
        ArrayList<BigDecimal> coefficients = new ArrayList<>();
        ArrayList<Polynomial> result = new ArrayList<>();
        Polynomial firstPolynomialCopy = firstPolynomial.createCopy();
        Polynomial secondPolynomialCopy;
        BigDecimal coefficient;

        while (firstPolynomialCopy.getPower() >= secondPolynomial.getPower()) {
            secondPolynomialCopy = secondPolynomial.createCopy();
            for (int i = 0; i < firstPolynomialCopy.getPower() - secondPolynomial.getPower(); i++) {
                secondPolynomialCopy.increasePower();
            }
            coefficient = firstPolynomialCopy.getCoefficients().get(0).divide(
                    secondPolynomialCopy.getCoefficients().get(0), mathContext);
            coefficients.add(coefficient);
            secondPolynomialCopy.multiplyByScalar(coefficient);
            firstPolynomialCopy = subtractPolynomials(firstPolynomialCopy, secondPolynomialCopy);
            firstPolynomialCopy.normalize();
        }


        result.add(new Polynomial(coefficients));
        result.add(firstPolynomialCopy);
        return result;
    }


    public Polynomial multiplyByScalar(@NotNull Polynomial polynomial,
                                       BigDecimal scalar) {
        Polynomial result = polynomial.createCopy();
        result.multiplyByScalar(scalar);
        return result;
    }

    public BigDecimal evaluatePolynomial(@NotNull Polynomial polynomial,
                                         BigDecimal point) {
        return polynomial.evaluatePolynomial(point);
    }

    public void printBigDecimal(BigDecimal value) {
        IOHelper.printBigDecimal(value);
    }

    public void printPolynomial(Polynomial polynomial) {
        IOHelper.printPolynomial(polynomial);
    }

    public void printComplexArray(ArrayList<Complex> complexes) {
        IOHelper.printComplexArray(complexes);
    }

    public ArrayList<Complex> findRoots(@NotNull Polynomial polynomial) {
        Complex defaultRoot = Constants.DEFAULT_ROOT_VALUE;
        ArrayList<Complex> roots = new ArrayList<>();
        ArrayList<Complex> newRoots = new ArrayList<>();
        Complex product;
        Complex polynomialValue;

        for (int i = 0; i < polynomial.getPower() - 1; i++) {
            roots.add(ComplexService.toPower(defaultRoot, i));
            newRoots.add(defaultRoot);
        }

        for (int i = 0; i < Constants.NUMBER_OF_ITERATIONS; i++) {
            for (int j = 0; j < polynomial.getPower() - 1; j++) {
                product = new Complex(BigDecimal.ONE, BigDecimal.ZERO);

                for (int k = 0; k < polynomial.getPower() - 1; k++) {
                    if (k != j) {
                        product = ComplexService.multiply(product,
                                ComplexService.subtract(roots.get(j), roots.get(k)));
                    }
                }

                polynomialValue = polynomial.evaluatePolynomial(roots.get(j));
                newRoots.set(j, ComplexService.subtract(roots.get(j),
                        ComplexService.divide(polynomialValue, product)));
            }
            roots = newRoots;
        }
        return roots;
    }

}
