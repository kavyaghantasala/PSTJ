import java.util.*;

public class Solution {

    public static int longestPalindrome(String s) {
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            maxLen = Math.max(maxLen, expand(s, i, i));

            // Even length palindrome
            maxLen = Math.max(maxLen, expand(s, i, i + 1));
        }

        return maxLen;
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        for (int i = 0; i < n; i++) {
            // Create rotation
            String rotated = s.substring(i) + s.substring(0, i);

            // Find longest palindrome in this rotation
            int result = longestPalindrome(rotated);

            System.out.println(result);
        }

        sc.close();
    }
}
