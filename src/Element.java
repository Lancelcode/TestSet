import java.util.Objects;

public class Element implements Comparable<Element> {
    private int atomicNo;
    private String symbol;
    private String eName;
    private double weight;
    private int yearD;
    private int group;

    public Element(int atomicNo, String symbol, String eName, double weight, int yearD, int group) {
        this.atomicNo = atomicNo;
        this.symbol = symbol;
        this.eName = eName;
        this.weight = weight;
        this.yearD = yearD;
        this.group = group;
    }

    public int getAtomicNo() { return atomicNo; }
    public String getSymbol() { return symbol; }
    public String getName() { return eName; }
    public double getWeight() { return weight; }
    public int getYearDiscovered() { return yearD; }
    public int getGroup() { return group; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return atomicNo == element.atomicNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(atomicNo);
    }

    @Override
    public String toString() {
        return atomicNo + ", " + symbol + ", " + eName + ", " + weight + ", " + yearD + ", " + group;
    }

    @Override
    public int compareTo(Element other) {
        return this.eName.compareTo(other.eName);  // Default sorting by element name
    }
}
