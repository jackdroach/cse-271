import java.util.Arrays;

public class Recursion {

    public static int power(int x, int n ) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static int sumDigits(int n) {
        if (n == 0 || (int) Math.log10(n) == 0) {
            return n;
        }

        return n % 10 + sumDigits(n / 10);
    }

    public static void printBackwards(String word) {
        if (word.length() == 0) {
            return;
        }

        System.out.print(word.charAt(word.length() - 1));
        printBackwards(word.substring(0, word.length() - 1));
    }

    public static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1));
    }

    public static int sumPositive(int[] array) {
        int sum = 0;

        if (array.length == 0) {
            return sum;
        }

        if (array[0] > 0) {
            sum += array[0];
        }

        return sum + sumPositive(Arrays.copyOfRange(array, 1, array.length));
    }

    public static int max(int[] array) {
        int max = Integer.MIN_VALUE;

        if (array.length == 0) {
            return max;
        }

        max = array[0];

        return Math.max(max, max(Arrays.copyOfRange(array, 1, array.length)));
    }

}