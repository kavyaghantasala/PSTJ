import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

  public static void matrixRotation(List<List<Integer>> matrix, int r) {

    int m = matrix.size();
    int n = matrix.get(0).size();

    int layers = Math.min(m, n) / 2;

    for (int l = 0; l < layers; l++) {

        List<Integer> ring = new ArrayList<>();

        int top = l;
        int left = l;
        int bottom = m - l - 1;
        int right = n - l - 1;

        // top row
        for (int j = left; j <= right; j++)
            ring.add(matrix.get(top).get(j));

        // right column
        for (int i = top + 1; i <= bottom - 1; i++)
            ring.add(matrix.get(i).get(right));

        // bottom row
        for (int j = right; j >= left; j--)
            ring.add(matrix.get(bottom).get(j));

        // left column
        for (int i = bottom - 1; i >= top + 1; i--)
            ring.add(matrix.get(i).get(left));

        int len = ring.size();
        int rot = r % len;

        // rotate anti-clockwise (left shift)
        List<Integer> rotated = new ArrayList<>(Collections.nCopies(len, 0));
        for (int i = 0; i < len; i++)
            rotated.set(i, ring.get((i + rot) % len));

        // put back into matrix
        int idx = 0;

        // top row
        for (int j = left; j <= right; j++)
            matrix.get(top).set(j, rotated.get(idx++));

        // right column
        for (int i = top + 1; i <= bottom - 1; i++)
            matrix.get(i).set(right, rotated.get(idx++));

        // bottom row
        for (int j = right; j >= left; j--)
            matrix.get(bottom).set(j, rotated.get(idx++));

        // left column
        for (int i = bottom - 1; i >= top + 1; i--)
            matrix.get(i).set(left, rotated.get(idx++));
    }

    // print matrix
    for (List<Integer> row : matrix) {
        for (int val : row)
            System.out.print(val + " ");
        System.out.println();
    }
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
