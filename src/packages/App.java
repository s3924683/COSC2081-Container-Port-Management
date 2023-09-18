package packages;

import packages.controls.PortManagerControlPanel;
import packages.controls.SystemAdminControlPanel;
import packages.users.PortManager;
import packages.users.SystemAdmin;
import packages.users.abstracts.User;

public class App {
    public App() {}
    public void start(){
        System.out.println("App is starting!");

        Login login = new Login();
        User user = login.run();

        if(user.getType().equals("systemAdmin")){
            new SystemAdminControlPanel((SystemAdmin) user);
        }else{
            new PortManagerControlPanel((PortManager) user);
        }
    }
}
