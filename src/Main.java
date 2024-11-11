import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║           Welcome to the Element Processor       ║");
            System.out.println("╚══════════════════════════════════════════════════╝\n");

            // Initialize the ProcessElements class with file paths
            ProcessElements elementsReader = new ProcessElements(
                    "C:\\Users\\Djiby\\IdeaProjects\\Assessment\\src\\ProcessAonly.txt",
                    "C:\\Users\\Djiby\\IdeaProjects\\Assessment\\src\\ProcessBonly.txt",
                    "C:\\Users\\Djiby\\IdeaProjects\\Assessment\\src\\ProcessAUB.txt"
            );

            // Display sorted sets by name for Process A
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║        Complete Process A Sorted by Name         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.displayElements(
                    elementsReader.getSortedElementsByName(elementsReader.SetA),
                    "Elements sorted by name in Process A:"
            );

            // Display sorted sets by name for Process B
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║        Complete Process B Sorted by Name         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.displayElements(
                    elementsReader.getSortedElementsByName(elementsReader.SetB),
                    "Elements sorted by name in Process B:"
            );

            // Display sorted sets by atomic weight for Process A
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║       Complete Process A Sorted by Weight        ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.displayElements(
                    elementsReader.getSortedElementsByWeight(elementsReader.SetA),
                    "Elements sorted by atomic weight in Process A:"
            );

            // Display sorted sets by atomic weight for Process B
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║       Complete Process B Sorted by Weight        ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.displayElements(
                    elementsReader.getSortedElementsByWeight(elementsReader.SetB),
                    "Elements sorted by atomic weight in Process B:"
            );

            // Display sorted sets by group number for Process A
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║       Complete Process A Sorted by Group         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.displayElements(
                    elementsReader.getSortedElementsByGroup(elementsReader.SetA),
                    "Elements sorted by group number in Process A:"
            );

            // Display sorted sets by group number for Process B
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║       Complete Process B Sorted by Group         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.displayElements(
                    elementsReader.getSortedElementsByGroup(elementsReader.SetB),
                    "Elements sorted by group number in Process B:"
            );

            // Remove elements with atomic number < 10
            System.out.println("\nRemoving elements with atomic number less than 10...");
            elementsReader.removeElementsWithAtomicNumberLessThan(elementsReader.SetA, 10);
            elementsReader.removeElementsWithAtomicNumberLessThan(elementsReader.SetB, 10);
            System.out.println("Removal complete!\n");

            // Write the results back to files
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║       Writing Final Sets to Output Files         ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            elementsReader.writeElementsToFile(elementsReader.SetA, "CompleteProcessA_AfterRemoval.txt");
            elementsReader.writeElementsToFile(elementsReader.SetB, "CompleteProcessB_AfterRemoval.txt");

            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║             Process Completed Successfully       ║");
            System.out.println("║         Output files have been generated!        ║");
            System.out.println("╚══════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║        An error occurred while reading files     ║");
            System.out.println("║       Error: " + e.getMessage() + "      ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
        }
    }
}
