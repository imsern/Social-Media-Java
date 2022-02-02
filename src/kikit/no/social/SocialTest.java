package kikit.no.social;

import org.junit.jupiter.api.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
class SocialTest {

    App app;
    @BeforeEach
    void setup(){
       app = new App("testBook");
    }

    @Test
    void findUserIndexWithId() {
        assertEquals(0, app.FindUserIndex(1));
    }

    @Test
    void findUserIndexWithUsername() {
        assertEquals(0, app.FindUserIndex("ims"));
    }

    @Test
    void generateId() {
        var idList = app.UserList.stream().map(x -> x.UserId).toList();
        var lastId = Collections.max(idList);
        assertEquals(lastId + 1, app.GenerateId(), "Expected to last ID + 1.");
    }

    @Test
    void generateIdIfListEmpty() {
        app.UserList.clear();
        assertEquals(1, app.GenerateId(), "Expect to get ID-1 because list is empty");
    }

    @Test
     void testThatMethodThrowsIllegalArgument() {
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Main.app.Test(1, 2, 3));
        Assertions.assertEquals("feil", exception.getMessage());
    }
}