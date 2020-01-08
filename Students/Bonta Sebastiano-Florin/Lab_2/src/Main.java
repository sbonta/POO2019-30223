import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PolynomialsService polynomialsService = new PolynomialsService();
        ArrayList<Polynomial> result;
        ArrayList<Complex> roots;
        ArrayList<Polynomial> input = polynomialsService.readPolynomials("polynomial.txt");
        Polynomial firstPolynomial = input.get(0);
        Polynomial secondPolynomial = input.get(1);
        polynomialsService.printPolynomial(firstPolynomial);
        polynomialsService.printPolynomial(secondPolynomial);

        Polynomial polynomial = polynomialsService.addPolynomials(firstPolynomial, secondPolynomial);
        polynomialsService.printPolynomial(polynomial);


        polynomial = polynomialsService.subtractPolynomials(firstPolynomial, secondPolynomial);
        polynomialsService.printPolynomial(polynomial);


        polynomial = polynomialsService.multiplyByScalar(firstPolynomial, BigDecimal.valueOf(2));
        polynomialsService.printPolynomial(polynomial);
        polynomialsService.printPolynomial(firstPolynomial);


        polynomialsService.printBigDecimal(polynomialsService.evaluatePolynomial(firstPolynomial, BigDecimal.ZERO));


        polynomial = polynomialsService.multiplyPolynomials(firstPolynomial, secondPolynomial);
        polynomialsService.printPolynomial(polynomial);

        result = polynomialsService.dividePolynomials(firstPolynomial, secondPolynomial);
        polynomialsService.printPolynomial(result.get(0));
        polynomialsService.printPolynomial(result.get(1));

        roots = polynomialsService.findRoots(firstPolynomial);
        polynomialsService.printComplexArray(roots);
    }
}
