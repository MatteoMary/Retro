package model;

public class GamePort {
    private Game originalGame;
    private GameMachine newMachine;
    private String portDeveloper;
    private int portReleaseYear;
    private String coverImageUrl;

    // Constructor
    public GamePort(Game originalGame, GameMachine newMachine, String portDeveloper,
                    int portReleaseYear, String coverImageUrl) {
        this.originalGame = originalGame;
        this.newMachine = newMachine;
        this.portDeveloper = portDeveloper;
        this.setPortReleaseYear(portReleaseYear);
        this.coverImageUrl = coverImageUrl;
    }

    // Getters and setters
    public Game getOriginalGame() {
        return originalGame;
    }

    public void setOriginalGame(Game originalGame) {
        this.originalGame = originalGame;
    }

    public GameMachine getNewMachine() {
        return newMachine;
    }

    public void setNewMachine(GameMachine newMachine) {
        this.newMachine = newMachine;
    }

    public String getPortDeveloper() {
        return portDeveloper;
    }

    public void setPortDeveloper(String portDeveloper) {
        this.portDeveloper = portDeveloper;
    }

    public int getPortReleaseYear() {
        return portReleaseYear;
    }

    public void setPortReleaseYear(int portReleaseYear) {
        // Ensure that the release year of the port is not earlier than the original game's release year
        if (originalGame != null && portReleaseYear < originalGame.getReleaseYear()) {
            throw new IllegalArgumentException("Port release year cannot be earlier than the original game release year");
        }
        this.portReleaseYear = portReleaseYear;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
}

