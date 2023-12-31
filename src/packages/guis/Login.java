package packages.guis;

import packages.guis.builders.Gui;
import packages.guis.builders.Menu;
import packages.users.PortManager;
import packages.users.SystemAdmin;
import packages.users.abstracts.User;

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
        Gui mainGui = new Gui("login","Login Panel", guiOptions, 2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Log in");
        guiOptions.put("2","Go back");
        Gui systemAdminLogin = new Gui("loginSystemAdmin", "System admin", guiOptions,2);
        Gui portManagerLogin = new Gui("loginPortManager", "Port manager", guiOptions,2);

        HashMap<String, Gui> guis = new HashMap<>();
        guis.put("1", mainGui);
        guis.put("1 1", systemAdminLogin);
        guis.put("1 2", portManagerLogin);

        menu = new Menu("login", "Login Menu", guis);
    }
    public User run(){
        keepMenuRunning = true;

        Scanner input = new Scanner(System.in);
        Gui gui;
        Scanner users = null;;

        while (keepMenuRunning){
            try {
                users = new Scanner(new File("database/users.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            HashMap<Object, Object> guiData = menu.run();

            gui = (Gui) guiData.get("gui");

            String id = gui.getId();

            String type;

            if(id.equals("loginSystemAdmin")){
                type = "systemAdmin";
            }else{
                type = "portManager";
            }

            System.out.print("Enter username: ");
            String username = input.next();
            System.out.print("Enter password: ");
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
                User user;

                if(type.equals("systemAdmin")){
                    user = new SystemAdmin(username,password);
                }else{
                    user = new PortManager(username,password);
                }

                return user;
            }else{
                System.out.println("Username or Password is incorrect!");
            }
        }
        return null;
    }
    public void stop(){
        keepMenuRunning = false;
        menu.stop();
    }
}
