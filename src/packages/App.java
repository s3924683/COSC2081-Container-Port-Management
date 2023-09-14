package packages;

import packages.guis.ControlPanel;

public class App {
    public App() {}
    public void start(){
        System.out.println("App is starting!");

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.run();

    }
    public void stop(){
        System.out.println("System is stopping!");
    }
}
