import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("N = ");
        n = keyboard.nextInt();
        System.out.println(sumOf3And5Multiples(n));
        System.out.printf("Largest palindrome product of 2 3-digit numbers is : %d\n",
                largestPalindromeProductOf2NumbersThatHave3Digits());

        System.out.printf("Largest palindrome product of 2 4-digit numbers is : %d\n",
                largestPalindromeProductOf2NumbersThatHave4Digits());

        System.out.printf("The sum of all even-valued fibonacci terms bellow 4.000.000 is : " +
                evenFibSum(4000000));

    }

    public static Long sumOf3And5Multiples(int n) {
        if (0 >= n) {
            return Long.valueOf(0);
        }

        int numberOf3Multiples = (n - 1) / 3;
        int numberOf5Multiples = (n - 1) / 5;
        int numberOf15Multiples = (n - 1) / 15;

        Long result = Long.valueOf((numberOf3Multiples * (numberOf3Multiples + 1)) / 2 * 3);
        result = result + (numberOf5Multiples * (numberOf5Multiples + 1)) / 2 * 5;
        result = result - (numberOf15Multiples * (numberOf15Multiples + 1)) / 2 * 15;

        return result;
    }

    private static boolean isProductOf3DigitNumbers(int n) {
        for (int i = 100; i < 1000; i++) {
            if ((0 == n % i) && ((n / i > 100) && (n / i < 1000))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isProductOf4DigitNumbers(int n) {
        for (int i = 1000; i < 10000; i++) {
            if ((0 == n % i) && ((n / i > 1000) && (n / i < 10000))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(int n) {
        String numberToString = String.valueOf(n);
        int i = 0;
        int j = numberToString.length() - 1;

        while (i < j) {
            if (numberToString.charAt(i) != numberToString.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static int largestPalindromeProductOf2NumbersThatHave3Digits() {
        for (int i = 999999; ; i--) {
            if (isPalindrome(i) && isProductOf3DigitNumbers(i)) {
                return i;
            }
        }
    }

    public static int largestPalindromeProductOf2NumbersThatHave4Digits() {
        for (int i = 99999999; ; i--) {
            if (isPalindrome(i) && isProductOf4DigitNumbers(i)) {
                return i;
            }
        }
    }

    public static long evenFibSum(int limit) {
        if (limit < 2)
            return 0;

        long ef1 = 0, ef2 = 2;
        long sum = ef1 + ef2;

        while (ef2 <= limit) {
            long ef3 = 4 * ef2 + ef1;
            if (ef3 > limit) {
                break;
            }
            ef1 = ef2;
            ef2 = ef3;
            sum += ef2;
        }

        return sum;
    }
}
