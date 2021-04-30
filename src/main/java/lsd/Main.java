package lsd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        char[][] result = LsdSort(data, K);
    }

    public static char[][] LsdSort(char[][] data, int stages) {
        final int iterations = Math.min(data.length, stages);
        char[][] curData = data;
        for (int i = 0; i < iterations; i++) {
            char[][] newData = new char[data.length][];
            int[] perms = countSort(curData, i);
            for (int j = 0; j < perms.length; j++) {
                newData[perms[j]] = data[j];
            }
            curData = newData;
        }
        return curData;
    }

    public static int[] countSort(char[][] data, int col) {
        final int rows = data.length;
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
        int[] permutations = new int[rows];
        for (int i = 0; i < rows; i++) {
            permutations[i] = count[data[i][col]]++;
        }
        return permutations;
    }
}
