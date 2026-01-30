package pst;

import java.util.*;
import java.util.function.*;

interface PerformOperation {
    boolean check(int n);
}

public class LambdaOperation {

    // Returns a lambda to check if a number is odd
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Returns a lambda to check if a number is prime
    public static PerformOperation isPrime() {
        return n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    // Returns a lambda to check if a number is palindrome
    public static PerformOperation isPalindrome() {
        return n -> {
            String s = String.valueOf(n);
            String rev = new StringBuilder(s).reverse().toString();
            return s.equals(rev);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int condition = sc.nextInt(); // 1=Odd/Even, 2=Prime/Composite, 3=Palindrome
            int num = sc.nextInt();

            PerformOperation op;
            String result = "";

            switch (condition) {
                case 1: // Odd/Even
                    op = isOdd();
                    result = op.check(num) ? "ODD" : "EVEN";
                    break;
                case 2: // Prime/Composite
                    op = isPrime();
                    result = op.check(num) ? "PRIME" : "COMPOSITE";
                    break;
                case 3: // Palindrome
                    op = isPalindrome();
                    result = op.check(num) ? "PALINDROME" : "NOT PALINDROME";
                    break;
                default:
                    result = "INVALID CONDITION";
            }

            System.out.println(result);
        }

        sc.close();
    }
}
