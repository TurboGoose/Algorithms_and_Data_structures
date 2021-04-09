package mergesort;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String INPUT_FILE = "input.txt";
        final String OUTPUT_FILE = "output.txt";
        int[] arr = readFile(INPUT_FILE);
        try (OutputStream out = new FileOutputStream(OUTPUT_FILE)) {
            mergeSort(arr, out);
        }
    }

    private static int[] readFile(String filename) throws IOException {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            int n = sc.nextInt();
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = sc.nextInt();
            }
            return result;
        }
    }

    public static int[] mergeSort(int[] source, OutputStream outputStream) {
        int[] src = new int[source.length];
        System.arraycopy(source, 0, src, 0, source.length);
        int[] dest = new int[src.length];
        int[] temp;
        int size = 1;
        try (PrintWriter out = new PrintWriter(outputStream)) {
            while (size < src.length) {
                for (int i = 0; i < src.length; i += 2 * size) {
                    merge(src, i, i + size, dest, i, size, out);
                }
                temp = src;
                src = dest;
                dest = temp;
                size *= 2;
            }
            for (int num : src) {
                out.print(num + " ");
            }
        }
        return src;
    }

    private static void merge(int[] src, int srcStart1, int srcStart2, int[] dest, int destStart, int size, PrintWriter out) {
        srcStart1 = Math.min(srcStart1, src.length);
        srcStart2 = Math.min(srcStart2, src.length);
        int index1 = srcStart1;
        int index2 = srcStart2;
        int srcEnd1 = Math.min(srcStart1 + size, src.length);
        int srcEnd2 = Math.min(srcStart2 + size, src.length);
        int destEnd = destStart + srcEnd1 - srcStart1 + srcEnd2 - srcStart2;
        for (int i = destStart; i < destEnd; i++) {
            if (index1 < srcEnd1 && (index2 >= srcEnd2 || src[index1] < src[index2])) {
                dest[i] = src[index1++];
            } else {
                dest[i] = src[index2++];
            }
        }
        out.println((destStart + 1) + " " + destEnd + " " + dest[destStart] + " " + dest[destEnd - 1]);
    }
}
