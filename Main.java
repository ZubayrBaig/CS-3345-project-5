import java.io.*;
import java.time.Duration;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.err.println("Usage: Java Main {size_of_array) report.txt unsorted.txt sorted.txt");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String reportFile = args[1];
        String unsortedFile = args[2];
        String sortedFile = args[3];

        
        ArrayList<Integer> list = QuickSorter.generateRandomList(size);

        writeListToFile(list, unsortedFile);

        StringBuilder report = new StringBuilder("Array Size = " + size + "\n");
        for (QuickSorter.PivotStrategy strategy : QuickSorter.PivotStrategy.values()) {
            ArrayList<Integer> listCopy = new ArrayList<>(list); // Copy to avoid modifying the original
            Duration timeTaken = QuickSorter.timedQuickSort(listCopy, strategy);
            report.append(strategy + " : " + timeTaken + "\n");
        }

        QuickSorter.timedQuickSort(list, QuickSorter.PivotStrategy.FIRST_ELEMENT); //using FIRST_ELEMENT for ease, but I tested all of them and they all work.
        writeListToFile(list, sortedFile);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            writer.write(report.toString());
        }
    }

    private static void writeListToFile(ArrayList<Integer> list, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : list) {
                writer.write(num + "\n");
            }
        }
    }
}