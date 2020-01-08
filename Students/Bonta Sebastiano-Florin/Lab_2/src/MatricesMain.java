import java.math.BigDecimal;
import java.util.Arrays;

public class MatricesMain {
    public static void main(String[] args) {
        BigDecimal[][] firstMatrix = {
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
                {BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(7)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(9)},
        };

        BigDecimal[][] secondMatrix = {
                {BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(5)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(1), BigDecimal.valueOf(3)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
        };

        BigDecimal[] array = {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)};
        BigDecimal[] solution;

        new MatricesService(3);
        BigDecimal[][] result = MatricesService.addMatrices(firstMatrix, secondMatrix);
        MatricesService.printMatrix(result);

        result = MatricesService.subtractMatrices(firstMatrix, secondMatrix);
        MatricesService.printMatrix(result);

        result = MatricesService.multiplyMatrices(firstMatrix, secondMatrix);
        MatricesService.printMatrix(result);

        result = MatricesService.multiplyByScalar(firstMatrix, BigDecimal.valueOf(11));
        MatricesService.printMatrix(result);

        System.out.println(MatricesService.determinant(firstMatrix));
        System.out.println(MatricesService.areEqual(firstMatrix, secondMatrix));
        System.out.println(MatricesService.isZeroMatrix(firstMatrix));
        System.out.println(MatricesService.isIdentityMatrix(firstMatrix));
        System.out.println(MatricesService.isIdentityMatrix(firstMatrix));
        System.out.println(MatricesService.fillDegree(firstMatrix));

        solution = MatricesService.solveSystem(firstMatrix, array);
        System.out.println(Arrays.toString(solution));
    }


}
