package packages.controls;

import packages.menu.OptionsMenu;
import packages.menu.builders.OptionsInterface;
import packages.users.SystemAdmin;
import java.util.HashMap;

public class SystemAdminControlPanel {
    private SystemAdmin user;
    private OptionsMenu menu;

    public SystemAdminControlPanel(SystemAdmin user) {
        this.user = user;
        this.setup();
    }
    private void setup(){
        OptionsInterface mainInterface = new OptionsInterface("controlPanel", "Control Panel", 4);
        mainInterface.addOption(1,"profile panel");
        mainInterface.addOption(2,"Port manager panel");
        mainInterface.addOption(3,"Vehicles panel");
        mainInterface.addOption(4,"Containers panel");
        mainInterface.addOption(5,"Ports panel");
        mainInterface.addOption(6,"Trips panel");
        mainInterface.addOption(7,"Statistic");

        OptionsInterface profilePanel = new OptionsInterface("profilePanel","Profiel Panel", 2);
        profilePanel.addOption(1,"Change username");
        profilePanel.addOption(2,"Change password");
        profilePanel.addOption(3,"Log out");
        profilePanel.addOption(4,"Go back");

        OptionsInterface portManagerPanel = new OptionsInterface("portManagerPanel","Port manager Panel",2);
        profilePanel.addOption(1,"Create an account");
        profilePanel.addOption(2,"Update an account");
        profilePanel.addOption(3,"Delete an account");
        profilePanel.addOption(4,"Go back");

        OptionsInterface vehiclesPanel = new OptionsInterface("vehiclesPanel","Vehicles Panel",2);
        vehiclesPanel.addOption(1,"Add a vehicle");
        vehiclesPanel.addOption(2,"Update a vehicle");
        vehiclesPanel.addOption(3,"Delete a vehicle");
        vehiclesPanel.addOption(4,"Go back");

        OptionsInterface containersPanel = new OptionsInterface("containersPanel","Containers Panel",2);
        containersPanel.addOption(1,"Add a container");
        containersPanel.addOption(2,"Update a container");
        containersPanel.addOption(3,"Delete a container");
        containersPanel.addOption(4,"Go back");

        OptionsInterface portsPanel = new OptionsInterface("portsPanel","Ports Panel",2);
        portsPanel.addOption(1,"Add a port");
        portsPanel.addOption(2,"Update a port");
        portsPanel.addOption(3,"Delete a port");
        portsPanel.addOption(4,"Display all ports");
        portsPanel.addOption(5,"Go back");

        OptionsInterface tripsPanel = new OptionsInterface("tripsPanel","Trips Panel",2);
        tripsPanel.addOption(1,"Add a trip");
        tripsPanel.addOption(2,"Update a trip");
        tripsPanel.addOption(3,"Delete a trip");
        tripsPanel.addOption(4,"Go back");

        OptionsInterface statisticPanel = new OptionsInterface("statisticPanel","Statistic Panel",4);
        statisticPanel.addOption(1,"Profile");
        statisticPanel.addOption(2,"Port managers");
        statisticPanel.addOption(3,"Ports");
        statisticPanel.addOption(4,"Containers");
        statisticPanel.addOption(5,"Vehicles");
        statisticPanel.addOption(6,"Trips");
        statisticPanel.addOption(7,"Summary");
        statisticPanel.addOption(8,"Go back");

        menu = new OptionsMenu("controlPanel", "Control Panel");
        menu.addOptionInterface("1", mainInterface);
        menu.addOptionInterface("1 1", profilePanel);
        menu.addOptionInterface("1 2", portManagerPanel);
        menu.addOptionInterface("1 3", vehiclesPanel);
        menu.addOptionInterface("1 4", containersPanel);
        menu.addOptionInterface("1 5", portsPanel);
        menu.addOptionInterface("1 6", tripsPanel);
        menu.addOptionInterface("1 7", statisticPanel);
    }
    public void run(){
        while (true){
            HashMap<String, String> interfaceData = menu.run();

            String id = interfaceData.get("id");
            String option = interfaceData.get("option");

            switch (id) {
                case "profilePanel" -> {}
                case "vehiclesPanel" ->{
                }}
        }
    }
}