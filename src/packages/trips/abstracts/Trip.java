package packages.trips.abstracts;

import packages.ports.abstracts.Port;
import packages.vehicles.abstracts.Vehicle;

import java.util.Date;

public class Trip {
    private Vehicle vehicle;
    private Date departureDate;
    private Date arrivalDate;
    private Port departurePort;
    private Port arrivalPort;
    private String status;

    public Trip(Vehicle vehicle, Date departureDate, Date arrivalDate, Port departurePort, Port arrivalPort, String status) {
        this.vehicle = vehicle;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Port getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(Port departurePort) {
        this.departurePort = departurePort;
    }

    public Port getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(Port arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
