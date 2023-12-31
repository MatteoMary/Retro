package com.example.retro;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FunkyList;
import model.Game;
import model.GameMachine;
import model.GamePort;

import java.io.*;

public class HelloApplication extends Application {

    public static Scene gamesS,gameMachinesS,gamePortsS;
    public static Stage mainStage;
    private static FunkyList<Game> games = new FunkyList<>();
    private static FunkyList<GameMachine> gameMachines = new FunkyList<>();
    private static FunkyList<GamePort> gamePorts = new FunkyList<>();


    public static Scene getGamesS() {
        return gamesS;
    }

    public static FunkyList<GamePort> getGamePorts() {
        return gamePorts;
    }

    public static void setGamePorts(FunkyList<GamePort> gamePorts) {
        HelloApplication.gamePorts = gamePorts;
    }

    public static FunkyList<GameMachine> getGameMachines() {
        return gameMachines;
    }

    public static void setGameMachines(FunkyList<GameMachine> gameMachines) {
        HelloApplication.gameMachines = gameMachines;
    }

    public static FunkyList<Game> getGames() {
        return games;
    }

    public static void setGames(FunkyList<Game> games) {
        HelloApplication.games = games;
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        HelloApplication.mainStage = mainStage;
    }

    public static Scene getGamePortsS() {
        return gamePortsS;
    }

    public static void setGamePortsS(Scene gamePortsS) {
        HelloApplication.gamePortsS = gamePortsS;
    }

    public static Scene getGameMachinesS() {
        return gameMachinesS;
    }

    public static void setGameMachinesS(Scene gameMachinesS) {
        HelloApplication.gameMachinesS = gameMachinesS;
    }

    public static void setGamesS(Scene gamesS) {
        HelloApplication.gamesS = gamesS;
    }

    public static Scene changeScene(String file) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        return new Scene(fxmlLoader.load(), 900, 600);
    }

    @Override
    public void start(Stage stage) throws IOException {

        mainStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("port-view.fxml"));
        Parent root = fxmlLoader.load();
        gamesS = new Scene(root, 900, 600);

        gamesS = changeScene("game-view.fxml");
        gameMachinesS = changeScene("machine-view.fxml");
        gamePortsS = changeScene("port-view.fxml");


        stage.setTitle("Retro Gaming Info System");
        stage.setScene(gamesS);
        stage.show();
    }


    public static void load() throws Exception { // load
        //list of com.example.ca_1_data_structure_mm.classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{Game.class, GameMachine.class, GamePort.class, FunkyList.class};

        //setting up the xstream object with default security and the above com.example.ca_1_data_structure_mm.classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("ships.xml"));
        games = (FunkyList<Game>) in.readObject();
        //shipsAtSea = (FunkyList<Ship>) in.readObject();//loading data from ships.xml
        in.close();
    }

    public static void save() throws Exception { // save
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("ships.xml"));
        out.writeObject(games);
        //out.writeObject(shipsAtSea);//saving only ports and ships at sea to ships.fxml since all data is linked to both of these

        out.close();
    }


    public static void main(String[] args) {
        launch();
    }
}