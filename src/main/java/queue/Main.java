package queue;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String INPUT_FILE = "input.txt";
        String OUTPUT_FILE = "output.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE));
             PrintWriter out = new PrintWriter(OUTPUT_FILE)) {
            Scanner sc = new Scanner(in);
            MinQueue queue = new MinQueue();
            while (sc.hasNextLine()){
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
