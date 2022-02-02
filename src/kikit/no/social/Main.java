package kikit.no.social;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
public static App app = new App("kikBook");

    public static void main(String[] args) throws IOException {
        //app.PrintAllUsers();
        app.Run();
    }
}
