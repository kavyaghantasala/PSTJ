package pst;

import java.util.Scanner;

public class array{  // Class name should match file name: ArrayExample.java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter the index of element to display: ");
        int j = sc.nextInt();

        // Check if index is valid
        if (j >= 0 && j < n) {
            System.out.println("Element at index " + j + " is " + a[j]);
        } else {
            System.out.println("Invalid index! Please enter a value between 0 and " + (n-1));
        }

        sc.close();
    }
}
