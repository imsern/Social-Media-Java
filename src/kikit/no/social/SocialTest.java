package kikit.no.social;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class SocialTest {
    @Test
    @Order(1)
    void findUserIndexWithId() {
        assertEquals(0, Main.app.FindUserIndex(1));
    }

    @Test
    @Order (2)
    void findUserIndexWithUsername() {
        assertEquals(0, Main.app.FindUserIndex("ims"));
    }

    @Test
    @Order (3)
    void generateId() {
        var idList = Main.app.UserList.stream().map(x -> x.UserId).toList();
        var lastId = Collections.max(idList);
        assertEquals(lastId + 1, Main.app.GenerateId(), "Expected to last ID + 1.");
    }

    @Test
    @Order(4)
    void generateIdIfListEmpty() {
        Main.app.UserList.clear();
        assertEquals(1, Main.app.GenerateId(), "Expect to get ID-1 because list is empty");
    }

    @Test
    @Order (5)
     void testThatMethodThrowsIllegalArgument() {
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Main.app.Test(1, 2, 3));
        Assertions.assertEquals("feil", exception.getMessage());
    }
}