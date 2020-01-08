import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;

public class ComplexService {

    @NotNull
    @Contract("_, _ -> new")
    public static Complex add(@NotNull Complex firstComplex, @NotNull Complex secondComplex) {
        return new Complex(firstComplex.getReal().add(secondComplex.getReal()),
                firstComplex.getImaginary().add(secondComplex.getImaginary()));
    }

    @NotNull
    @Contract("_, _ -> new")
    public static Complex subtract(@NotNull Complex firstComplex, @NotNull Complex secondComplex) {
        return new Complex(firstComplex.getReal().subtract(secondComplex.getReal()),
                firstComplex.getImaginary().subtract(secondComplex.getImaginary()));
    }

    @NotNull
    @Contract("_, _ -> new")
    public static Complex multiply(@NotNull Complex firstComplex, @NotNull Complex secondComplex) {

        BigDecimal a = firstComplex.getReal();
        BigDecimal b = firstComplex.getImaginary();
        BigDecimal c = secondComplex.getReal();
        BigDecimal d = secondComplex.getImaginary();

        return new Complex(a.multiply(c).subtract(b.multiply(d)), a.multiply(d).add(b.multiply(c)));
    }

    @NotNull
    @Contract("_, _ -> new")
    public static Complex divide(@NotNull Complex firstComplex, @NotNull Complex secondComplex) {
        BigDecimal a = firstComplex.getReal();
        BigDecimal b = firstComplex.getImaginary();
        BigDecimal c = secondComplex.getReal();
        BigDecimal d = secondComplex.getImaginary();
        BigDecimal e = c.multiply(c).add(d.multiply(d));
        MathContext mathContext = new MathContext(10);

        return new Complex(a.multiply(c).add(b.multiply(d)).divide(e, mathContext),
                b.multiply(c).subtract(a.multiply(d)).divide(e, mathContext));
    }

    @NotNull
    @Contract("_, _ -> new")
    public static Complex multiplyByScalar(@NotNull Complex complex, @NotNull BigDecimal scalar) {
        return new Complex(scalar.multiply(complex.getReal()), scalar.multiply(complex.getImaginary()));
    }

    public static Complex toPower(Complex complex, Integer power) {
        if (0 == power) {
            return new Complex(BigDecimal.valueOf(1), BigDecimal.valueOf(0));
        }
        Complex result = new Complex(complex.getReal(), complex.getImaginary());
        for (int i = 1; i < power; i++) {
            result = multiply(result, complex);
        }
        return result;
    }
}
