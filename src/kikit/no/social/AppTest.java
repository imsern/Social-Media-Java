//package kikit.no.social;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class AppTest {
//
//    @Test
//    @Order (1)
//    void findUserIndex() {
//        assertAll("FindIndexMethods",
//                () -> assertEquals(0, Main.app.FindUserIndex(1), "call from int"),
//                () -> assertEquals(0, Main.app.FindUserIndex("ims"), "call from string")
//                );
//    }
//
//    @Test
//    @Order (2)
//    void findUser() {
//        assertAll("FindUserMethods",
//                () -> assertEquals(Main.app.UserList.get(0), Main.app.FindUser(1), "call from int"),
//                () -> assertEquals(Main.app.UserList.get(0), Main.app.FindUser("ims"), "call from string")
//        );
//    }
//
//    @Test
//    @Order (3)
//    void generateId() {
//        var idList = Main.app.UserList.stream().map(x -> x.UserId).toList();
//        var lastId = Collections.max(idList);
//        assertEquals(lastId + 1, Main.app.GenerateId(), "Expected to last ID + 1.");
//    }
//
//    @Test
//    @Order(4)
//    void generateIdIfListEmpty() {
//        Main.app.UserList.clear();
//        assertEquals(1, Main.app.GenerateId(), "Expect to get ID-1 because list is empty");
//    }
//    @Test
//    @Order (5)
//    void addFriend(){
//
//    }
//}