import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Complex {
    private BigDecimal real;
    private BigDecimal imaginary;

    public Complex(BigDecimal real, BigDecimal imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public BigDecimal getReal() {
        return real;
    }

    public BigDecimal getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real.setScale(5, RoundingMode.DOWN) +
                ", imaginary=" + imaginary.setScale(5, RoundingMode.DOWN) +
                '}' + "\n";
    }
}
