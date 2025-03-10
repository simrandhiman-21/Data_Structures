import java.util.ArrayList;

class UserNode {
    int userID;
    String name;
    int age;
    ArrayList<Integer> friendIDs;
    UserNode next;

    UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMediaFriendList {
    UserNode head;

    // Add new user
    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added: " + name);
    }

    // Find user by ID
    public UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection
    public void addFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.add(userID2);
            user2.friendIDs.add(userID1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove friend connection
    public void removeFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        UserNode user = findUser(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIDs);
        } else {
            System.out.println("User not found.");
        }
    }

    // Find mutual friends
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            ArrayList<Integer> mutualFriends = new ArrayList<>(user1.friendIDs);
            mutualFriends.retainAll(user2.friendIDs);
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("One or both users not found.");
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMediaFriendList smList = new SocialMediaFriendList();

        smList.addUser(101, "Alice", 25);
        smList.addUser(102, "Bob", 30);
        smList.addUser(103, "Charlie", 28);

        smList.addFriend(101, 102);
        smList.addFriend(101, 103);

        smList.displayFriends(101);
        smList.findMutualFriends(101, 102);

        smList.removeFriend(101, 102);
        smList.displayFriends(101);
    }
}
