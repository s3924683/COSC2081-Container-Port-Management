package packages;

import packages.guis.ControlPanel;

public class App {
    private ControlPanel controlPanel;

    public App() {}
    public void start(){
        System.out.println("App is starting!");

        this.controlPanel = new ControlPanel();
        controlPanel.run();
    }
    public void stop(){
        System.out.println("App is stopping!");
        controlPanel.stop();
    }
}
