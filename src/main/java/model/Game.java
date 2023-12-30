package model;

public class Game {
    private String gameName;
    private String publisher;
    private String description;
    private String originalDeveloper;
    private String originalMachine;
    private int releaseYear;
    private String coverImageUrl;

    // Constructor
    public Game(String gameName, String publisher, String description, String originalDeveloper,
                String originalMachine, int releaseYear, String coverImageUrl) {
        this.gameName = gameName;
        this.publisher = publisher;
        this.description = description;
        this.originalDeveloper = originalDeveloper;
        this.originalMachine = originalMachine;
        this.releaseYear = releaseYear;
        this.coverImageUrl = coverImageUrl;
    }

    // Getters and setters
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalDeveloper() {
        return originalDeveloper;
    }

    public void setOriginalDeveloper(String originalDeveloper) {
        this.originalDeveloper = originalDeveloper;
    }

    public String getOriginalMachine() {
        return originalMachine;
    }

    public void setOriginalMachine(String originalMachine) {
        this.originalMachine = originalMachine;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
}

