package packages;

import packages.users.abstracts.User;

import java.util.HashMap;

public class App {
    private static HashMap<String, HashMap<String, User[]>>  users;
    private TextGui textGui;
    public App() {
        textGui = new TextGui();
    }

    public void start(){
        System.out.println("System is starting!");

        /*
        while (true){
            Map<String, String> userData = textGui.getLoginPrompts();

            if(Objects.equals(userData.get("type"), "systemAdmin")){
                System.out.println("Passing data to Admin class and try to .login");

                break;
            }else{
                System.out.println("Passing data to Manager class and try to .login");

                break;
            }
        }

         */
    }

    public void stop(){
        System.out.println("System is stopping!");
    }
}
