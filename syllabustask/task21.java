import java.util.*;

class Task21 {

    public static int colorful(int A) {
        String num = String.valueOf(A);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < num.length(); i++) {
            int product = 1;

            for (int j = i; j < num.length(); j++) {
                product *= (num.charAt(j) - '0');

                if (set.contains(product)) {
                    return 0;
                }

                set.add(product);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int A = 23;
        System.out.println(colorful(A)); // Output: 1
    }
}
