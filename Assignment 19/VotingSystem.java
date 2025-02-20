import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    private Map<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotes() {
        System.out.println("Votes (Unordered): " + voteMap);
        System.out.println("Votes (Insertion Order): " + orderedVotes);
        System.out.println("Votes (Sorted Order): " + sortedVotes);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        system.displayVotes();
    }
}
