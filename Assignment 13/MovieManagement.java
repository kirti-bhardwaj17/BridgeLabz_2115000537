import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SocialMedia {
    class User {
        int userId;
        String name;
        int age;
        List<Integer> friends;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }

    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
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

    public void addFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null && !user1.friends.contains(userId2)) {
            user1.friends.add(userId2);
            user2.friends.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.print(user.name + "'s Friends: ");
            for (int friendId : user.friends) {
                User friend = findUserById(friendId);
                if (friend != null) {
                    System.out.print(friend.name + " (" + friend.userId + "), ");
                }
            }
            System.out.println();
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>();
            for (int friendId : user1.friends) {
                if (user2.friends.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
            System.out.print("Mutual Friends between " + user1.name + " and " + user2.name + ": ");
            for (int id : mutualFriends) {
                User friend = findUserById(id);
                if (friend != null) {
                    System.out.print(friend.name + " (" + friend.userId + "), ");
                }
            }
            System.out.println();
        }
    }

    public void searchUserById(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println("User Found: " + user.name + " (ID: " + user.userId + ", Age: " + user.age + ")");
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 28);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "David", 30);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 4);
        sm.addFriend(3, 4);

        sm.displayFriends(1);
        sm.displayFriends(2);
        sm.displayFriends(3);
        sm.findMutualFriends(1, 2);
        sm.findMutualFriends(1, 4);
        sm.countFriends();

        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        sm.countFriends();

        sm.searchUserById(3);
        sm.searchUserByName("David");
    }
}
