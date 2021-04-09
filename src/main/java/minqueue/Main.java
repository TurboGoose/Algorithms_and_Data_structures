package minqueue;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "input.txt";
        final String OUTPUT_FILE = "output.txt";
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(INPUT_FILE)));
             PrintWriter out = new PrintWriter(OUTPUT_FILE)) {
            MinQueue queue = new MinQueue();
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                if ("-".equals(line)) {
                    queue.pop();
                } else if ("?".equals(line)) {
                    out.println(queue.min());
                } else {
                    queue.push(Integer.parseInt(line.substring(2)));
                }
            }
        }
    }
}
