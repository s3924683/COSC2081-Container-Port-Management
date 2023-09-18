package packages.guis;

import packages.guis.abstracts.Interface;
import packages.guis.builders.Menu;
import packages.users.abstracts.User;
import java.util.HashMap;
public class ControlPanel {
    private User user;
    private Menu controlMenu;

    public ControlPanel() {}
    public void run(){
        while (true){
            checkIfNoUser();

            HashMap<Object, Object> guiData = this.controlMenu.run();

            Interface anInterface = (Interface) guiData.get("gui");
            String option = (String) guiData.get("option");
            String id = anInterface.getId();


            switch (id) {
                case "profilePanel" -> {
                    HashMap<String, String> options = anInterface.getOptions();

                    String textOption = options.get(option);
                    switch (textOption) {
                        case "Log out" -> {
                            this.user = null;
                        }

                        case "Change password" ->{
                            //function to change password.
                        }
                    }
                }
                case "vehiclesPanel" ->{
                    HashMap<String, String> options = anInterface.getOptions();

                    String textOption = options.get(option);
                    switch (textOption) {
                        case "Update a vehicle" -> {
                            //generate vehicle list
                            //ask to give input
                            //tell status
                        }

                        case "Change password" ->{
                            //function to change password.
                        }
                    }
                }
            }
        }
    }
    private void checkIfNoUser(){
        if(user == null){
            showLoginPrompt();

            if(this.user.getType().equals("portManager")){
                this.setupForPortManager();
            }else{
                this.setupForSystemAdmin();
            }
        }
    }
    private void showLoginPrompt(){
        Login login = new Login();
        this.user = login.run();
    }

    private  void setupForPortManager(){
        HashMap<String, String> guiOptions = new HashMap<>();

        guiOptions.put("1","Profile panel");
        guiOptions.put("2","Vehicles panel");
        guiOptions.put("3","Containers panel");
        guiOptions.put("4","Ports panel");
        guiOptions.put("5","Trips panel");
        guiOptions.put("6","Statistic");
        Interface mainInterface = new Interface("controlPanel","Control Panel", guiOptions, 4);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Change username");
        guiOptions.put("2","Change password");
        guiOptions.put("4","Log out");
        guiOptions.put("5","Go back");
        Interface profilePanel = new Interface("profilePanel","Profile Panel", guiOptions, 2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Update a vehicle");
        guiOptions.put("2","Go back");
        Interface vehiclesPanel = new Interface("vehiclesPanel","Vehicles Panel", guiOptions,2 );

        guiOptions = new HashMap<>();
        guiOptions.put("1","Add a container");
        guiOptions.put("2","Update a container");
        guiOptions.put("3","Delete a container");
        guiOptions.put("4","Go back");
        Interface containersPanel = new Interface("containersPanel","Containers Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Add a trip");
        guiOptions.put("2","Update a trip");
        guiOptions.put("3","Delete a trip");
        guiOptions.put("4","Go back");
        Interface tripsPanel = new Interface("tripsPanel","Trips Panel", guiOptions, 2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Profile");
        guiOptions.put("2","Port");
        guiOptions.put("3","Containers");
        guiOptions.put("4","Vehicles");
        guiOptions.put("5","Trips");
        guiOptions.put("6","Summary");
        guiOptions.put("7","Go back");
        Interface staticticPanel = new Interface("statisticPanel","Statistic Panel", guiOptions, 4);

        HashMap<String, Interface> guis = new HashMap<>();

        guis.put("1", mainInterface);
        guis.put("1 1", profilePanel);
        guis.put("1 2", vehiclesPanel);
        guis.put("1 3", containersPanel);
        guis.put("1 4", tripsPanel);
        guis.put("1 5", staticticPanel);

        controlMenu = new Menu("controlPanel", "Control Panel", guis);
    }
    private void setupForSystemAdmin(){
        HashMap<String, String> guiOptions = new HashMap<>();

        guiOptions.put("1","Profile panel");
        guiOptions.put("2","Port manager panel");
        guiOptions.put("3","Vehicles panel");
        guiOptions.put("4","Containers panel");
        guiOptions.put("5","Ports panel");
        guiOptions.put("6","Trips panel");
        guiOptions.put("7","Statistic");
        Interface mainInterface = new Interface("controlPanel","Control Panel", guiOptions,4);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Change username");
        guiOptions.put("2","Change password");
        guiOptions.put("3","Log out");
        guiOptions.put("4","Go back");
        Interface profilePanel = new Interface("profilePanel","Profile Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Create an account");
        guiOptions.put("2","Update an account");
        guiOptions.put("3","Delete an account");
        guiOptions.put("4","Go back");
        Interface portManagerPanel = new Interface("portManagerPanel","Port manager Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Add a vehicle");
        guiOptions.put("2","Update a vehicle");
        guiOptions.put("3","Delete a vehicle");
        guiOptions.put("4","Go back");
        Interface vehiclesPanel = new Interface("vehiclesPanel","Vehicles Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Add a container");
        guiOptions.put("2","Update a container");
        guiOptions.put("3","Delete a container");
        guiOptions.put("4","Go back");
        Interface containersPanel = new Interface("containersPanel","Containers Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Add a port");
        guiOptions.put("2","Update a port");
        guiOptions.put("3","Delete a port");
        guiOptions.put("4","Display all ports");
        guiOptions.put("5","Go back");
        Interface portsPanel = new Interface("portsPanel","Ports Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Add a trip");
        guiOptions.put("2","Update a trip");
        guiOptions.put("3","Delete a trip");
        guiOptions.put("4","Go back");
        Interface tripsPanel = new Interface("tripsPanel","Trips Panel", guiOptions,2);

        guiOptions = new HashMap<>();
        guiOptions.put("1","Profile");
        guiOptions.put("2","Port managers");
        guiOptions.put("3","Ports");
        guiOptions.put("4","Containers");
        guiOptions.put("5","Vehicles");
        guiOptions.put("6","Trips");
        guiOptions.put("7","Summary");
        guiOptions.put("8","Go back");
        Interface statisticPanel = new Interface("statisticPanel","Statistic Panel", guiOptions,4);

        HashMap<String, Interface> guis = new HashMap<>();

        guis.put("1", mainInterface);
        guis.put("1 1", profilePanel);
        guis.put("1 2", portManagerPanel);
        guis.put("1 3", vehiclesPanel);
        guis.put("1 4", containersPanel);
        guis.put("1 5", portsPanel);
        guis.put("1 6", tripsPanel);
        guis.put("1 7", statisticPanel);

        controlMenu = new Menu("controlPanel", "Control Panel", guis);
    }

    public void stop(){};
}