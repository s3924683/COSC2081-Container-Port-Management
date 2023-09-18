package packages.vehicles.abstracts;

import packages.menu.builders.TableInterface;
import packages.ports.abstracts.Port;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Vehicle {
    private String name;
    private double currentFuel;
    private double carryingCapacity;
    private double fuelCapacity;
    private Port currentPort;
    private int totalContainers;
    public Vehicle(String name, double currentFuel, double carryingCapacity, double fuelCapacity, Port currentPort, int totalContainers) {
        this.name = name;
        this.currentFuel = currentFuel;
        this.carryingCapacity = carryingCapacity;
        this.fuelCapacity = fuelCapacity;
        this.currentPort = currentPort;
        this.totalContainers = totalContainers;
    }
    public static void displayAllVehicles() throws FileNotFoundException {
        Scanner vehicles = new Scanner(new File("database/vehicles.txt"));

        HashMap <String, String> vehiclesId = new HashMap<>();

        int count = 1;

        String[] cols = {"Id", "Name", "Type", "Port Id"};
        TableInterface table = new TableInterface("vehicleDisplay","Vehicles",cols, ",");

        while (vehicles.hasNextLine()) {
            String line = vehicles.nextLine();

           table.addRow(line);
        }

        System.out.println(table.toString());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Port getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }

    public int getTotalContainers() {
        return totalContainers;
    }

    public void setTotalContainers(int totalContainers) {
        this.totalContainers = totalContainers;
    }

    public static void main(String[] args) throws FileNotFoundException {
        displayAllVehicles();
    }
}
