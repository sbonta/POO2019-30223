import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Polynomial {
    private ArrayList<BigDecimal> coefficients;

    public Polynomial(ArrayList<BigDecimal> coefficients) {
        this.coefficients = coefficients;
    }

    public ArrayList<BigDecimal> getCoefficients() {
        return coefficients;
    }

    public int getPower() {
        return coefficients.size();
    }

    public void increasePower() {
        this.coefficients.add(BigDecimal.ZERO);
    }

    public void multiplyByScalar(BigDecimal value) {
        for(int i = 0 ; i < coefficients.size() ; i ++) {
            coefficients.set(i, coefficients.get(i).multiply(value));
        }
    }

    public Polynomial createCopy() {

        ArrayList<BigDecimal> coefficients = new ArrayList<>(this.coefficients);
        return new Polynomial(coefficients);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        BigDecimal coefficient;
        for (int i = 0 ; i < coefficients.size() ; i ++) {
            coefficient = coefficients.get(i);

            if (!coefficient.equals(BigDecimal.ZERO)) {
                if ((coefficient.compareTo(BigDecimal.ZERO) > 0) && (0 != i)) {
                    result.append("+");
                }
                if((!coefficient.equals(BigDecimal.ONE)) || (i == coefficients.size() - 1)) {
                    if (coefficient.doubleValue() == Math.floor(coefficient.doubleValue())) {
                        result.append(Math.round(coefficient.doubleValue()));
                    } else {
                        result.append(coefficient);
                    }
                }

                if (i < coefficients.size() - 2) {
                    result.append("x^").append(coefficients.size() - i - 1);
                }
                if (i == coefficients.size() - 2) {
                    result.append("x");
                }
            }
        }

        return result.toString();
    }

    public BigDecimal evaluatePolynomial(BigDecimal point) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal product;

        for (int i = 0; i < coefficients.size(); i++) {
            product = BigDecimal.ONE;
            for (int j = 0; j < coefficients.size() - i - 1; j++) {
                product = product.multiply(point);
            }
            sum = sum.add(product.multiply(coefficients.get(i)));
        }

        return sum;
    }

    public Complex evaluatePolynomial(@NotNull Complex complex) {
        Complex sum = new Complex(BigDecimal.ZERO, BigDecimal.ZERO);
        Complex product;

        for(int i = 0 ; i < coefficients.size() ; i ++) {
            product = ComplexService.toPower(complex, coefficients.size() - i - 1);
            product = ComplexService.multiply(product, new Complex(coefficients.get(i), BigDecimal.ZERO));
            sum = ComplexService.add(product, sum);
        }

        return sum;
    }

    public void normalize() {
        while((0 != coefficients.size()) && (coefficients.get(0)).equals(BigDecimal.ZERO)) {
            coefficients.remove(0);
        }
    }
}
