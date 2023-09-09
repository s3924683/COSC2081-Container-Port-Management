package packages.containers.abstracts;

public abstract class Container {
    private String id;
    private Double weight;

    public Container(String id, Double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
