package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "input.txt";
        final String OUTPUT_FILE = "output.txt";
        int n = readFile(INPUT_FILE);
        writeFile(OUTPUT_FILE, generateWorstCaseTest(n));
    }

    private static int readFile(String filename) throws IOException {
        int result;
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            result = sc.nextInt();
        }
        return result;
    }

    private static void writeFile(String filename, List<Integer> data) throws IOException {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (int num : data) {
                out.print(num + " ");
            }
        }
    }

    static List<Integer> generateWorstCaseTest(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            result.add((int) Math.round((result.size() - 1) / 2.0), i);
        }
        return result;
    }
}
