package packages;

import packages.guis.Login;
import packages.users.abstracts.User;
import java.util.HashMap;

public class App {
    private static HashMap<String, HashMap<String, User[]>>  users;
    public App() {}

    public void start(){
        System.out.println("System is starting!");

        try {
            Login login = new Login();
            login.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        System.out.println("System is stopping!");
    }
}
