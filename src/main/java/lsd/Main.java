package lsd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "input.txt";
        final String OUTPUT_FILE = "output.txt";
        int N, M, K;
        char[][] data;
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(INPUT_FILE)))) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            sc.nextLine();
            data = new char[N][M];
            for (int i = 0; i < M; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    data[j][M - i - 1] = line.charAt(j);
                }
            }
        }
        int[] result = LsdSort(data, K);
        try (PrintWriter out = new PrintWriter(OUTPUT_FILE)) {
            for (int i : result) {
                out.print(i + " ");
            }
        }
    }

    public static int[] LsdSort(char[][] data, int stages) {
        final int rows = data.length;
        final int iterations = Math.min(rows, stages);
        int[] permutation = new int[rows];
        for (int i = 0; i < rows; i++) {
            permutation[i] = i + 1;
        }
        for (int col = 0; col < iterations; col++) {
            int[] count = new int[128];
            for (int i = 0; i < rows; i++) {
                count[data[i][col]]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = count.length - 1; i > 0; i--) {
                count[i] = count[i - 1];
            }
            count[0] = 0;

            int[] newPerm = new int[rows];
            char[][] newData = new char[rows][];
            for (int i = 0; i < rows; i++) {
                int index = count[data[i][col]]++;
                newPerm[index] = permutation[i];
                newData[index] = data[i];
            }
            permutation = newPerm;
            data = newData;
        }
        return permutation;
    }
}
