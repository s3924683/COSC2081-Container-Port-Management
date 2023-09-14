package packages;

import packages.guis.ControlPanel;
import packages.guis.Login;
import packages.users.PortManager;
import packages.users.SystemAdmin;
import packages.users.abstracts.User;
import java.util.HashMap;

public class App {
    private static HashMap<String, HashMap<String, User[]>>  users;
    public App() {
        users = new HashMap<>();
    }

    public void start(){
        try {
            System.out.println("System is starting!");

            Login login = new Login();
            HashMap<String, String> userData = login.run();

            String username = userData.get("username");
            String password = userData.get("password");
            String type = userData.get("type");

            User user;
            if(type.equals("systemAdmin")){
                user = new SystemAdmin(username,password);
            }else{
                user = new PortManager(username,password);
            }

            ControlPanel controlPanel = new ControlPanel(user);

            controlPanel.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        System.out.println("System is stopping!");
    }
}
