import java.util.*;
import java.time.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + holderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premium +
                '}';
    }
}

public class InsurancePolicyManagement {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet - Unordered): " + hashSet);
        System.out.println("All Policies (LinkedHashSet - Insertion Order): " + linkedHashSet);
        System.out.println("All Policies (TreeSet - Sorted by Expiry Date): " + treeSet);
    }

    public void displayExpiringSoon() {
        LocalDate now = LocalDate.now();
        System.out.println("Policies expiring in the next 30 days:");
        for (Policy policy : treeSet) {
            if (policy.expiryDate.isBefore(now.plusDays(30))) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("Policies with coverage type: " + coverageType);
        for (Policy policy : hashSet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> seenNumbers = new HashSet<>();
        System.out.println("Duplicate Policies:");
        for (Policy policy : hashSet) {
            if (!seenNumbers.add(policy.policyNumber)) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new Policy("P123", "Alice", LocalDate.of(2024, 8, 20), "Health", 500.0));
        system.addPolicy(new Policy("P124", "Bob", LocalDate.of(2024, 7, 10), "Auto", 700.0));
        system.addPolicy(new Policy("P125", "Charlie", LocalDate.of(2024, 9, 5), "Home", 600.0));
        system.addPolicy(new Policy("P123", "Alice", LocalDate.of(2024, 8, 20), "Health", 500.0)); // Duplicate

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.findDuplicatePolicies();
    }
}
