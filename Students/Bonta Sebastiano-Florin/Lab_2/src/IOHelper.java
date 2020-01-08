import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class IOHelper {
    @NotNull
    public static ArrayList<ArrayList<BigDecimal>> read2ArraysFromFile(String filename) {
        ArrayList<ArrayList<BigDecimal>> result = new ArrayList<>();
        ArrayList<BigDecimal> firstArray = new ArrayList<>();
        ArrayList<BigDecimal> secondArray = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner;
        Scanner lineScanner;
        String line;

        try {
            scanner = new Scanner(file);
            line = scanner.nextLine();

            lineScanner = new Scanner(line);
            while (lineScanner.hasNextBigDecimal()) {
                firstArray.add(lineScanner.nextBigDecimal());
            }

            line = scanner.nextLine();

            lineScanner = new Scanner(line);
            while (lineScanner.hasNextBigDecimal()) {
                secondArray.add(lineScanner.nextBigDecimal());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        result.add(firstArray);
        result.add(secondArray);

        return result;
    }

    public static void printPolynomial(@NotNull Polynomial polynomial) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt", true);
            fileWriter.write(polynomial.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printBigDecimal(@NotNull BigDecimal value) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt", true);
            fileWriter.write(value.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printComplexArray(@NotNull ArrayList<Complex> complexes) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt", true);
            for(Complex complex : complexes) {
                fileWriter.write(complex.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
