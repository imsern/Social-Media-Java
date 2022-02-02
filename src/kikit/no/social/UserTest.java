package kikit.no.social;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    App app;
    @BeforeEach
    void setUp() {
        app = new App("testBook");
        user = app.UserList.get(0);
    }

    @Test
    void getFriendList() {
        var testList = new ArrayList<User>();
        for (var friend : user.FriendsList){
            var index = app.FindUserIndex(friend);
            testList.add(app.UserList.get(index));
        }
        assertEquals(testList,user.GetFriendList());
    }
}