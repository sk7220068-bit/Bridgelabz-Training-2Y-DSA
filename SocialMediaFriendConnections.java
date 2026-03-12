class SocialMediaFriendConnections {
    class FriendNode {
        int friendId;
        FriendNode next;
        public FriendNode(int friendId) { this.friendId = friendId; }
    }
    class UserNode {
        int userId;
        String name;
        int age;
        FriendNode headFriend;
        UserNode next;
        public UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
        }
    }
    private UserNode head = null;
    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
    }
    private UserNode findUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }
    public void addFriendConnection(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 != null && u2 != null) {
            addFriendInternal(u1, userId2);
            addFriendInternal(u2, userId1);
        }
    }
    private void addFriendInternal(UserNode user, int fId) {
        FriendNode fn = new FriendNode(fId);
        fn.next = user.headFriend;
        user.headFriend = fn;
    }
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 != null && u2 != null) {
            removeFriendInternal(u1, userId2);
            removeFriendInternal(u2, userId1);
        }
    }
    private void removeFriendInternal(UserNode user, int fId) {
        if (user.headFriend == null) return;
        if (user.headFriend.friendId == fId) {
            user.headFriend = user.headFriend.next;
            return;
        }
        FriendNode temp = user.headFriend;
        while (temp.next != null && temp.next.friendId != fId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public void findMutualFriends(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 == null || u2 == null) return;
        java.util.Set<Integer> set = new java.util.HashSet<>();
        FriendNode f1 = u1.headFriend;
        while (f1 != null) {
            set.add(f1.friendId);
            f1 = f1.next;
        }
        FriendNode f2 = u2.headFriend;
        while (f2 != null) {
            if (set.contains(f2.friendId)) {
                System.out.println(f2.friendId);
            }
            f2 = f2.next;
        }
    }
    public void displayAllFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            FriendNode f = user.headFriend;
            while (f != null) {
                System.out.println(f.friendId);
                f = f.next;
            }
        }
    }
    public void searchUser(String name, int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId || temp.name.equals(name)) {
                System.out.println(temp.userId + " " + temp.name);
            }
            temp = temp.next;
        }
    }
    public int countFriends(int userId) {
        UserNode user = findUser(userId);
        int count = 0;
        if (user != null) {
            FriendNode f = user.headFriend;
            while (f != null) {
                count++;
                f = f.next;
            }
        }
        return count;
    }
}
