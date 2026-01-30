package pst;

import java.util.*;

public class second_largest {  // File should be SecondLargest.java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Need at least 2 elements.");
            sc.close();
            return;
        }

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int secondHighest = list.stream()
                                .distinct()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst()
                                .orElse(-1);

        System.out.println("Second largest element: " + secondHighest);
        sc.close();
    }
}
