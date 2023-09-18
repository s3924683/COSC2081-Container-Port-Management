package packages;

import packages.menu.OptionsMenu;
import packages.menu.builders.OptionsInterface;
import packages.menu.builders.PromptsInterface;
import packages.users.PortManager;
import packages.users.SystemAdmin;
import packages.users.abstracts.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    private OptionsMenu optionsMenu;
    private PromptsInterface promptsInterface;

    public Login() {
        setup();
    }

    private void setup() {
        OptionsInterface mainInterface = new OptionsInterface("login", "Login Panel", 2);
        mainInterface.addOption(1, "System Admin");
        mainInterface.addOption(2, "Port Manager");

        OptionsInterface systemAdminInterface = new OptionsInterface("loginSystemAdmin", "System admin", 2);
        systemAdminInterface.addOption(1, "Log in");
        systemAdminInterface.addOption(2, "Go back");

        OptionsInterface portManagerInterface = new OptionsInterface("loginPortManager", "Port Manager", 2);
        systemAdminInterface.addOption(1, "Log in");
        systemAdminInterface.addOption(2, "Go back");

        optionsMenu = new OptionsMenu("login", "Login Menu");
        optionsMenu.addOptionInterface("1", mainInterface);
        optionsMenu.addOptionInterface("1 1", systemAdminInterface);
        optionsMenu.addOptionInterface("1 2", portManagerInterface);

        promptsInterface = new PromptsInterface("loginPrompts","Log in prompt");
        promptsInterface.addPrompt("Enter username");
        promptsInterface.addPrompt("Enter password");
    }

    public User run() {
        while (true){
            String role = null;

            HashMap<String, String> interfaceData = optionsMenu.run();

            String id = interfaceData.get("id");

            if(id.equals("loginSystemAdmin")){
                role = "systemAdmin";
            }else {
                role = "portManager";
            }

            HashMap<Number, String> results = promptsInterface.startPrompts();

            Scanner users =  null;

            try {
                users = new Scanner(new File("database/users.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            boolean userFound = false;

            String username = results.get(1);
            String password = results.get(2);

            while (users.hasNextLine()) {
                String line = users.nextLine();

                String[] parts = line.split(","); // Split the line into username and password

                // Check if the username and password match
                if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password) && parts[2].equals(role)) {
                    userFound = true;
                    break; // Exit the loop once a matching user is found
                }
            }

            if(userFound){
                User user;

                if (role.equals("systemAdmin")) {
                    user = new SystemAdmin(username, password);
                } else {
                    user = new PortManager(username, password);
                }

                return user;
            }
        }
    }
}
/*
public class Login {
    private OptionsMenu optionsMenu;
    private boolean keepMenuRunning = true;

    public Login() {
        setup();
    }

    private void setup() {
        HashMap<String, String> guiOptions = new HashMap<>();
        guiOptions.put("1", "System Admin");
        guiOptions.put("2", "Port Manager");
        OptionsInterface mainOptionsInterface = new OptionsInterface("login", "Login Panel", guiOptions, 2);

        guiOptions = new HashMap<>();
        guiOptions.put("1", "Log in");
        guiOptions.put("2", "Go back");
        OptionsInterface systemAdminLogin = new OptionsInterface("loginSystemAdmin", "System admin", guiOptions, 2);
        OptionsInterface portManagerLogin = new OptionsInterface("loginPortManager", "Port manager", guiOptions, 2);

        HashMap<String, OptionsInterface> guis = new HashMap<>();
        guis.put("1", mainOptionsInterface);
        guis.put("1 1", systemAdminLogin);
        guis.put("1 2", portManagerLogin);

        optionsMenu = new OptionsMenu("login", "Login Menu", guis);
    }

    public User run() {
        keepMenuRunning = true;

        Scanner input = new Scanner(System.in);
        OptionsInterface anOptionsInterface;
        Scanner users = null;
        ;

        while (keepMenuRunning) {
            try {
                users = new Scanner(new File("database/users.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            HashMap<Object, Object> guiData = optionsMenu.run();

            anOptionsInterface = (OptionsInterface) guiData.get("gui");

            String id = anOptionsInterface.getId();

            String type;

            if (id.equals("loginSystemAdmin")) {
                type = "systemAdmin";
            } else {
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

            if (userFound) {
                User user;

                if (type.equals("systemAdmin")) {
                    user = new SystemAdmin(username, password);
                } else {
                    user = new PortManager(username, password);
                }

                return user;
            } else {
                System.out.println("Username or Password is incorrect!");
            }
        }
        return null;
    }

    public void stop() {
        keepMenuRunning = false;
        optionsMenu.stop();
    }
}
*/