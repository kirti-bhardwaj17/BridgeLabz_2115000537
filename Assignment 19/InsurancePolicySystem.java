import java.util.*;
import java.time.*;

class Policy {
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

public class InsurancePolicySystem {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicies = new LinkedHashMap<>();
    Map<LocalDate, Policy> sortedPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedPolicies.put(policy.expiryDate, policy);
    }

    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies() {
        LocalDate now = LocalDate.now();
        List<Policy> expiring = new ArrayList<>();
        for (Map.Entry<LocalDate, Policy> entry : sortedPolicies.entrySet()) {
            if (!entry.getKey().isAfter(now.plusDays(30))) {
                expiring.add(entry.getValue());
            }
        }
        return expiring;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.holderName.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(now));
        orderedPolicies.values().removeIf(policy -> policy.expiryDate.isBefore(now));
        sortedPolicies.entrySet().removeIf(entry -> entry.getKey().isBefore(now));
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        system.addPolicy(new Policy("P123", "Alice", LocalDate.of(2024, 8, 20), "Health", 500.0));
        system.addPolicy(new Policy("P124", "Bob", LocalDate.of(2024, 7, 10), "Auto", 700.0));
        system.addPolicy(new Policy("P125", "Charlie", LocalDate.of(2024, 9, 5), "Home", 600.0));

        System.out.println("Policy by Number: " + system.getPolicy("P124"));
        System.out.println("Expiring Policies: " + system.getExpiringPolicies());
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));
        system.removeExpiredPolicies();
    }
}
