package kikit.no.social;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static kikit.no.social.Main.console;


public class App {
    public String Name;
    public User CurrentUser;
    //public String Password;
    public String UserInput;
    List<User> UserList = new ArrayList<>();


    public App(String name) {
        this.Name = name;
        initUser();
    }

    public void Run() throws IOException {
        while (CurrentUser == null) {
            logIn();
            while (CurrentUser != null) {
                GetCommand();
            }
        }
    }

    public Integer Test(int a, int b, int c){
        var sum = a + b + c;
        if(sum < 8) throw new IllegalArgumentException("feil");
        return sum;
    }

    private void GetCommand() throws IOException {
        GetUserInput(true, true);

        switch (UserInput) {
            case "logoff", "logout":
                logOut();
                break;
            case "show friends":
                CurrentUser.PrintFriends();
                break;
            case "add friend":
                AddFriend();
                break;
            default:
                System.out.println("Unknown command!");
                break;
        }
    }

    private void logOut() {
        CurrentUser.Online = false;
        CurrentUser = null;
        System.out.println("Logged out!");
    }

    public void logIn() throws IOException {
        System.out.println("--Log in--");
        while (CurrentUser == null) {
            System.out.print("Username: ");
            var UserInput = console.readLine();
            var index = FindUserIndex(UserInput);
            if (index != -1) {
                var tempUser = UserList.get(index);
                System.out.print("Password: ");
                UserInput = console.readLine();
                if (UserInput.equals(tempUser.Password)) {
                    CurrentUser = tempUser;
                    CurrentUser.Online = true;
                    System.out.println("Login success! - Welcome " + CurrentUser.Name);
                }
            }
            if (CurrentUser == null) {
                //System.out.println("Wrong username or password!");
                throw new IllegalArgumentException("Feil");
            }
        }
    }

    private void initUser() {
        UserList.add(new User(GenerateId(), "Kristoffer", "ims", "ims123", "kristoffer@kikit.no", 30, false));
        UserList.add(new User(GenerateId(), "Marius", "mariustb", "mari123", "m@kikit.no", 28, false));
        UserList.add(new User(GenerateId(), "Stigh", "stighg", "sti123", "s@kikit.no", 39, false));
        UserList.add(new User(GenerateId(), "Stian", "stians", "stian123", "st@kikit.no", 19, false));
        UserList.add(new User(GenerateId(), "John Espen", "jesp", "jesp123", "je@kikit.no", 52, false));
    }

    public void GetUserInput(boolean showName, boolean toLowerChars) throws IOException {
        if (showName) System.out.print(CurrentUser.Name + ": ");
        UserInput = toLowerChars ? console.readLine().toLowerCase() : console.readLine();
    }

    public void RemoveUser(Integer id) {
        UserList.remove(FindUser(id));
    }

    public void RemoveUser(String username) {
        UserList.remove(FindUser(username));
    }

    public void CreateNewUser(String name, String username, String password, String email, Integer age) {
        UserList.add(new User(GenerateId(), name, username, password, email, age, false));
    }

    public void AddFriend() throws IOException {
        for (var user : UserList) {
            if (user != CurrentUser) {
                System.out.println("ID: " + user.UserId + " Name: " + user.Name);
            }
        }
        System.out.print("Write the ID of the person: ");
        GetUserInput(false, true);
        var index = FindUserIndex(Integer.parseInt(UserInput));
        if (index != -1) {
            var selectedUser = UserList.get(index);
            CurrentUser.AddFriend(selectedUser.UserId);
            System.out.println(selectedUser.Name + " was added to your friends list.");
        } else {
            System.out.println("Couldnt find the user");
        }
    }

    // Find user methods - START
    public Integer FindUserIndex(Integer id) {
        var found = UserList.stream().filter(x -> id == x.UserId).findAny().orElse(null);
        return UserList.indexOf(found);
    }

    public Integer FindUserIndex(String username) {
        var found = UserList.stream().filter(x -> username.equalsIgnoreCase(x.UserName)).findAny().orElse(null);
        return UserList.indexOf(found);
    }

    public User FindUser(Integer id) {
        return UserList.get(FindUserIndex(id));
    }

    public User FindUser(String username) {
        return UserList.get(FindUserIndex(username));
    }
    // Find user methods - STOP

    public void PrintAllUsers() {
        for (var user : UserList) {
            System.out.println(user.Name);
        }
    }

    public Integer GenerateId() {
        if (UserList.stream().count() > 0) {
            var idList = UserList.stream().map(x -> x.UserId).toList();
            var lastId = Collections.max(idList);
            return lastId + 1;
        }
        return 1;
    }

}
