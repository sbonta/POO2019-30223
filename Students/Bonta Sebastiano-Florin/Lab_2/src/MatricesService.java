import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.MathContext;

public class MatricesService {

    private static Integer numberOfRowsAndColumns;

    public MatricesService(Integer numberOfRowsAndColumns) {
        MatricesService.numberOfRowsAndColumns = numberOfRowsAndColumns;
    }


    @NotNull
    public static BigDecimal[][] addMatrices(BigDecimal[][] firstMatrix, BigDecimal[][] secondMatrix) {
        BigDecimal[][] result = new BigDecimal[numberOfRowsAndColumns][numberOfRowsAndColumns];

        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                result[line][column] = firstMatrix[line][column].add(secondMatrix[line][column]);
            }
        }
        return result;
    }

    @NotNull
    public static BigDecimal[][] subtractMatrices(BigDecimal[][] firstMatrix, BigDecimal[][] secondMatrix) {
        BigDecimal[][] result = new BigDecimal[numberOfRowsAndColumns][numberOfRowsAndColumns];

        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                result[line][column] = firstMatrix[line][column].subtract(secondMatrix[line][column]);
            }
        }
        return result;
    }

    @NotNull
    public static BigDecimal[][] multiplyMatrices(BigDecimal[][] firstMatrix, BigDecimal[][] secondMatrix) {
        BigDecimal[][] result = new BigDecimal[numberOfRowsAndColumns][numberOfRowsAndColumns];

        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                result[line][column] = BigDecimal.ZERO;

                for (int i = 0; i < numberOfRowsAndColumns; i++) {
                    result[line][column] = result[line][column].add(
                            firstMatrix[line][i].multiply(secondMatrix[i][column]));
                }
            }
        }
        return result;
    }

    @NotNull
    public static BigDecimal[][] multiplyByScalar(BigDecimal[][] matrix, BigDecimal scalar) {
        BigDecimal[][] result = new BigDecimal[numberOfRowsAndColumns][numberOfRowsAndColumns];

        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                result[line][column] = matrix[line][column].multiply(scalar);
            }
        }
        return result;
    }

    @NotNull
    @Contract(pure = true)
    public static Boolean areEqual(BigDecimal[][] firstMatrix, BigDecimal[][] secondMatrix) {
        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                if (!firstMatrix[line][column].equals(secondMatrix[line][column])) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    @Contract(pure = true)
    public static Boolean isZeroMatrix(BigDecimal[][] matrix) {
        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                if (!matrix[line][column].equals(BigDecimal.ZERO)) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    @Contract(pure = true)
    public static Boolean isIdentityMatrix(BigDecimal[][] matrix) {
        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                if ((!matrix[line][column].equals(BigDecimal.ZERO)) &&
                        ((!matrix[line][column].equals(BigDecimal.ONE)) || (line != column))) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    @Contract(pure = true)
    public static Double fillDegree(BigDecimal[][] matrix) {
        double counter = 0d;
        for (int line = 0; line < numberOfRowsAndColumns; line++) {
            for (int column = 0; column < numberOfRowsAndColumns; column++) {
                if (!matrix[line][column].equals(BigDecimal.ZERO)) {
                    counter++;
                }
            }
        }
        return counter / (numberOfRowsAndColumns * numberOfRowsAndColumns);
    }

    private static void swap(@NotNull BigDecimal[][] matrix,
                             @NotNull Integer firstLine,
                             @NotNull Integer firstColumn,
                             @NotNull Integer secondLine,
                             @NotNull Integer secondColumn) {
        BigDecimal auxiliary = matrix[firstLine][firstColumn];
        matrix[firstLine][firstColumn] = matrix[secondLine][secondColumn];
        matrix[secondLine][secondColumn] = auxiliary;
    }

    @NotNull
    private static BigDecimal[][] createCopy(BigDecimal[][] matrix) {
        BigDecimal[][] result = new BigDecimal[numberOfRowsAndColumns][numberOfRowsAndColumns];
        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            System.arraycopy(matrix[i], 0, result[i], 0, numberOfRowsAndColumns);
        }
        return result;
    }

    @NotNull
    public static BigDecimal determinant(BigDecimal[][] matrix) {
        MathContext mathContext = new MathContext(10);
        BigDecimal[][] matrixCopy = createCopy(matrix);
        BigDecimal result = BigDecimal.ONE;
        BigDecimal total = BigDecimal.ONE;
        BigDecimal[] temporaryArray = new BigDecimal[numberOfRowsAndColumns];
        Integer index;
        BigDecimal valueOfDiagonalElement;
        BigDecimal valueOfNextRowElement;

        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            index = i;
            while ((index < numberOfRowsAndColumns) && (matrixCopy[index][i].equals(BigDecimal.valueOf(0)))) {
                index++;
            }
            if (index.equals(numberOfRowsAndColumns)) {
                return BigDecimal.valueOf(0);
            }
            if (index != i) {
                for (int j = 0; j < numberOfRowsAndColumns; j++) {
                    swap(matrixCopy, index, j, i, j);
                }

                if ((index - i) % 2 != 0) {
                    result = BigDecimal.ZERO.subtract(result);
                }
            }
            if (numberOfRowsAndColumns >= 0) System.arraycopy(matrixCopy[i], 0, temporaryArray,
                    0, numberOfRowsAndColumns);

            for (int j = i + 1; j < numberOfRowsAndColumns; j++) {
                valueOfDiagonalElement = temporaryArray[i];
                valueOfNextRowElement = matrixCopy[j][i];

                for (int k = 0; k < numberOfRowsAndColumns; k++) {
                    matrixCopy[j][k] = (valueOfDiagonalElement.multiply(matrixCopy[j][k])).subtract(
                            (valueOfNextRowElement.multiply(temporaryArray[k])));
                }
                total = total.multiply(valueOfDiagonalElement);
            }
        }

        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            result = result.multiply(matrixCopy[i][i]);
        }

        return result.divide(total, mathContext);
    }

    public static void printMatrix(BigDecimal[][] matrix) {
        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            for (int j = 0; j < numberOfRowsAndColumns; j++) {
                if (matrix[i][j].doubleValue() == Math.floor(matrix[i][j].doubleValue())) {
                    System.out.printf("%d ", Math.round(matrix[i][j].doubleValue()));
                } else {
                    System.out.printf("%f ", matrix[i][j]);
                }
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    @NotNull
    private static BigDecimal[][] swapColumn(BigDecimal[][] matrix, Integer column, BigDecimal[] replacer) {
        BigDecimal[][] result = createCopy(matrix);

        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            result[i][column] = replacer[i];
        }
        return result;
    }

    @Nullable
    public static BigDecimal[] solveSystem(BigDecimal[][] matrix, BigDecimal[] array) {
        MathContext mathContext = new MathContext(10);
        BigDecimal[][] auxiliary;
        BigDecimal[] result = new BigDecimal[numberOfRowsAndColumns];
        BigDecimal determinant = determinant(matrix);
        if (determinant.equals(BigDecimal.ZERO)) {
            return null;
        }

        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            auxiliary = swapColumn(matrix, i, array);
            result[i] = determinant(auxiliary).divide(determinant, mathContext);
        }
        return result;
    }

}
