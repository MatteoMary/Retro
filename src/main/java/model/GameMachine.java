package model;

public class GameMachine {
    private String machineName;
    private String manufacturer;
    private String description;
    private String type;
    private String media;
    private int launchYear;
    private double initialPrice;
    private String imageUrl;

    // Constructor
    public GameMachine(String machineName, String manufacturer, String description, String type,
                       String media, int launchYear, double initialPrice, String imageUrl) {
        this.machineName = machineName;
        this.manufacturer = manufacturer;
        this.description = description;
        this.type = type;
        this.media = media;
        this.launchYear = launchYear;
        this.initialPrice = initialPrice;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
