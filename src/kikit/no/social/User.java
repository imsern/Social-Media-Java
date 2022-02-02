package kikit.no.social;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    public final int UserId;
    public String UserName;
    public String Password;
    public String Name;
    public String Email;
    public boolean Online;
    public int Age;
    public List<Integer> FriendsList = new ArrayList<>();

    public User(int userId, String name, String username, String password, String email, int age, boolean online) {
        this.Name = name;
        this.Age = age;
        this.UserName = username;
        this.Password = password;
        this.Email = email;
        this.Online = online;
        this.UserId = userId;
    }

    public List<User> GetFriendList() {
        var list = new ArrayList<User>();
        for (var i : FriendsList) {
            var index = Main.app.FindUserIndex(i);
            list.add(Main.app.UserList.get(index));
        }
        return list;
    }

    public void PrintFriends() throws IOException {
        var list = GetFriendList();
        if (list.stream().count() == 0) {
            System.out.println("You got no friends!");
        } else {
            for (var friend : list) {
                System.out.println("ID: " + friend.UserId + " - " + friend.Name);
            }
        }
        System.out.println("Write the ID for more information or push Enter to move on!");
        Main.app.GetUserInput(false, true);
        var index = Main.app.FindUserIndex(Integer.parseInt(Main.app.UserInput));
        if (index != -1 && !Main.app.UserInput.equals("")) {
            var selectedFriend = Main.app.UserList.get(index);
            System.out.println("ID: " + selectedFriend.UserId + "\n" +
                    "Name: " + selectedFriend.Name + "\n" +
                    "Age: " + selectedFriend.Age + "\n" +
                    "Username: " + selectedFriend.UserName + "\n" +
                    "Email: " + selectedFriend.Email + "\n" +
                    "Online status: " + (selectedFriend.Online ? "Online" : "Offline"));
        }

    }

    public void AddFriend(int id) {
        FriendsList.add(id);
    }

}
