import java.io.*;
import java.util.*;

public class ProcessElements {
    public Set<Element> processAOnly = new HashSet<>();
    public Set<Element> processBOnly = new HashSet<>();
    public Set<Element> processAUB = new HashSet<>();
    public Set<Element> SetA = new LinkedHashSet<>();
    public Set<Element> SetB = new LinkedHashSet<>();

    public ProcessElements(String fileA, String fileB, String fileAB) throws IOException {
        // Load data from files into respective sets
        loadElementsFromFile(fileA, processAOnly);
        loadElementsFromFile(fileB, processBOnly);
        loadElementsFromFile(fileAB, processAUB);

        // Building sets A and B
        SetA();
        SetB();
    }

    private void loadElementsFromFile(String filename, Set<Element> set) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                int atomicNo = Integer.parseInt(st.nextToken().trim());
                String symbol = st.nextToken().trim();
                String name = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                int year = Integer.parseInt(st.nextToken().trim());
                int group = Integer.parseInt(st.nextToken().trim());

                // Create an Element object and add to the set
                Element element = new Element(atomicNo, symbol, name, weight, year, group);
                set.add(element);
            }
        }
    }

    public class void SetA() {
        SetA.addAll(processAOnly);
        SetA.removeAll(processAUB);
    }

    public class void SetB() {
        SetB.addAll(processBOnly);
        SetB.removeAll(processAUB);
    }

    public Set<Element> getSortedElementsByName(Set<Element> elements) {
        return new TreeSet<>(elements);  // Sorted by name (natural order)
    }

    public Set<Element> getSortedElementsByWeight(Set<Element> elements) {
        TreeSet<Element> sortedByWeight = new TreeSet<>(Comparator.comparingDouble(Element::getWeight));
        sortedByWeight.addAll(elements);
        return sortedByWeight;
    }

    public Set<Element> getSortedElementsByGroup(Set<Element> elements) {
        TreeSet<Element> sortedByGroup = new TreeSet<>(Comparator.comparingInt(Element::getGroup));
        sortedByGroup.addAll(elements);
        return sortedByGroup;
    }

    public void removeElementsWithAtomicNumberLessThan(Set<Element> elements, int threshold) {
        elements.removeIf(element -> element.getAtomicNo() < threshold);
    }

    public void writeElementsToFile(Set<Element> elements, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Element element : elements) {
                writer.write(element.toString());
                writer.newLine();
            }
        }
    }

    public void displayElements(Set<Element> elements, String message) {
        System.out.println(message);
        for (Element element : elements) {
            System.out.println(element);
        }
        System.out.println();
    }
}
