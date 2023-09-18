package packages.controls;

import packages.menu.OptionsMenu;
import packages.menu.builders.OptionsInterface;
import packages.users.PortManager;

import java.util.HashMap;

public class PortManagerControlPanel {
    private PortManager user;
    private OptionsMenu menu;

    public PortManagerControlPanel(PortManager user) {
        this.user = user;
        this.setup();
    }

    public void setup(){
        OptionsInterface mainInterface = new OptionsInterface("controlPanel", "Control Panel", 4);
        mainInterface.addOption(1,"profile panel");
        mainInterface.addOption(2,"Vehicles panel");
        mainInterface.addOption(3,"Containers panel");
        mainInterface.addOption(4,"Port panel");
        mainInterface.addOption(5,"Trips panel");
        mainInterface.addOption(6,"Statistic");

        OptionsInterface profilePanel = new OptionsInterface("profilePanel","Profiel Panel", 2);
        profilePanel.addOption(1,"Change username");
        profilePanel.addOption(2,"Change password");
        profilePanel.addOption(3,"Log out");
        profilePanel.addOption(4,"Go back");

        OptionsInterface vehiclesPanel = new OptionsInterface("vehiclesPanel","Vehicles Panel",2);
        vehiclesPanel.addOption(1,"Update a vehicle");
        vehiclesPanel.addOption(2,"Go back");

        OptionsInterface containersPanel = new OptionsInterface("containersPanel","Containers Panel",2);
        containersPanel.addOption(1,"Add a container");
        containersPanel.addOption(2,"Update a container");
        containersPanel.addOption(3,"Delete a container");
        containersPanel.addOption(4,"Go back");

        OptionsInterface portsPanel = new OptionsInterface("portPanel","Port Panel",2);
        portsPanel.addOption(1,"Update a port");
        portsPanel.addOption(2,"Go back");

        OptionsInterface tripsPanel = new OptionsInterface("tripPanel","Trip Panel",2);
        tripsPanel.addOption(1,"Add a trip");
        tripsPanel.addOption(2,"Update a trip");
        tripsPanel.addOption(3,"Delete a trip");
        tripsPanel.addOption(4,"Go back");

        OptionsInterface statisticPanel = new OptionsInterface("statisticPanel","Statistic Panel",4);
        statisticPanel.addOption(1,"Profile");
        statisticPanel.addOption(2,"Port");
        statisticPanel.addOption(3,"Containers");
        statisticPanel.addOption(4,"Vehicles");
        statisticPanel.addOption(5,"Trips");
        statisticPanel.addOption(6,"Summary");
        statisticPanel.addOption(7,"Go back");

        menu = new OptionsMenu("controlPanel", "Control Panel");
        menu.addOptionInterface("1", mainInterface);
        menu.addOptionInterface("1 1", profilePanel);
        menu.addOptionInterface("1 2", vehiclesPanel);
        menu.addOptionInterface("1 3", containersPanel);
        menu.addOptionInterface("1 4", portsPanel);
        menu.addOptionInterface("1 5", tripsPanel);
        menu.addOptionInterface("1 6", statisticPanel);
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