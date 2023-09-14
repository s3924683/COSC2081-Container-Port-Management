package packages.guis;

import packages.guis.builders.Gui;
import packages.guis.builders.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Login{
    private Menu menu;
    private boolean keepMenuRunning = true;
    public Login() {
        setup();
    }
    private void setup() {
        HashMap<String, String> guiOptions = new HashMap<>();
        guiOptions.put("1","System Admin");
        guiOptions.put("2","Port Manager");
        Gui mainGui = new Gui("login","Login Panel", guiOptions);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Log in");
        guiOptions.put("2","Go back");
        Gui systemAdminLogin = new Gui("loginSystemAdmin", "Login panel for System admin", guiOptions);
        Gui portManagerLogin = new Gui("loginPortManager", "Login panel for Port manager", guiOptions);

        HashMap<String, Gui> guis = new HashMap<>();
        guis.put("1", mainGui);
        guis.put("1 1", systemAdminLogin);
        guis.put("1 2", portManagerLogin);

        menu = new Menu("login", "Login Menu", guis);
    }
    public void run() throws FileNotFoundException {
        keepMenuRunning = true;

        Scanner input = new Scanner(System.in);
        Gui gui;

        while (keepMenuRunning){
            Scanner users = new Scanner(new File("database/users.txt"));

            gui = menu.run();

            String id = gui.getId();

            String type;

            if(id.equals("loginSystemAdmin")){
                type = "systemAdmin";
            }else{
                type = "portManager";
            }

            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();

            boolean userFound = false;

            while (users.hasNextLine()) {
                String line = users.nextLine();

                String[] parts = line.split(","); // Split the line into username and password

                // Check if the username and password match
                if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password) && parts[2].equals(type)) {
                    userFound = true;
                    break; // Exit the loop once a matching user is found
                }
            }

            if(userFound){
                System.out.println(username);
                //User class here
                break;
            }else{
                System.out.println("Username or Password is incorrect!");
            }
        }
    }
    public void stop(){
        keepMenuRunning = false;
        menu.stop();
    }
}
