package packages.ports.abstracts;

public abstract class Port {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double storingCapacity;
    private boolean hasLandingAbility;

    public Port(String id, String name, double latitude, double longitude, double storingCapacity, boolean hasLandingAbility) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.storingCapacity = storingCapacity;
        this.hasLandingAbility = hasLandingAbility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getStoringCapacity() {
        return storingCapacity;
    }

    public void setStoringCapacity(double storingCapacity) {
        this.storingCapacity = storingCapacity;
    }

    public boolean isHasLandingAbility() {
        return hasLandingAbility;
    }

    public void setHasLandingAbility(boolean hasLandingAbility) {
        this.hasLandingAbility = hasLandingAbility;
    }
}
