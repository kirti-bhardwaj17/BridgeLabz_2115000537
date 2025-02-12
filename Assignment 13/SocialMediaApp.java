import java.util.ArrayList;
import java.util.List;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head; // Head of the linked list

    // Add a new user to the list
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    private User findUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);
        if (user1 != null && user2 != null && userID1 != userID2) {
            if (!user1.friendIDs.contains(userID2)) user1.friendIDs.add(userID2);
            if (!user2.friendIDs.contains(userID1)) user2.friendIDs.add(userID1);
        }
    }

    public void removeFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            List<Integer> mutual = new ArrayList<>();
            for (int id : user1.friendIDs) {
                if (user2.friendIDs.contains(id)) {
                    mutual.add(id);
                }
            }
            System.out.println("Mutual Friends: " + mutual);
        }
    }

    public void displayFriends(int userID) {
        User user = findUser(userID);
        if (user != null) {
            System.out.println(user.name + "'s Friends: " + user.friendIDs);
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUser(String name, int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name) || temp.userID == userID) {
                System.out.println("User Found: " + temp.userID + " - " + temp.name + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friends.");
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 24);
        sm.addUser(3, "Charlie", 26);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);

        sm.displayFriends(1);
        sm.displayFriends(2);
        sm.displayFriends(3);

        sm.findMutualFriends(1, 2);

        sm.searchUser("Alice", -1);
        sm.searchUser("", 3);

        sm.countFriends();

        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        sm.countFriends();
    }
}
