package hashset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "input.txt";
        final String OUTPUT_FILE = "output.txt";
        HashSet<Integer> set = new HashSet<>();
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(INPUT_FILE)));
             PrintWriter out = new PrintWriter(OUTPUT_FILE)) {
            int N = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                int num = Integer.parseInt(line.substring(2));
                if (line.startsWith("+ ")) {
                    set.add(num);
                } else if (line.startsWith("- ")) {
                    set.remove(num);
                } else {
                    out.println(set.contains(num));
                }
            }
        }
    }
}


class HashSet<T> {
    private final Map<T, Boolean> map = new HashMap<>();

    public void add(T key) {
        map.putIfAbsent(key, true);
    }

    public void remove(T key) {
        map.remove(key);
    }

    public boolean contains(T key) {
        return map.containsKey(key);
    }
}
