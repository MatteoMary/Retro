package controller;

import model.Game;
import model.GameMachine;
import model.GamePort;

import java.util.Arrays;

public class GameMachineAPI {

    private static final int INITIAL_CAPACITY = 10;
    private static final int HASH_TABLE_SIZE = 20;

    private GameMachine[] gameMachines;
    private int numGameMachines;

    private Game[] games;
    private int numGames;

    private GamePort[] gamePorts;
    private int numGamePorts;

    private GameMachine[] machineHashTable;

    public GameMachineAPI() {
        this.gameMachines = new GameMachine[INITIAL_CAPACITY];
        this.numGameMachines = 0;

        this.games = new Game[INITIAL_CAPACITY];
        this.numGames = 0;

        this.gamePorts = new GamePort[INITIAL_CAPACITY];
        this.numGamePorts = 0;

        this.machineHashTable = new GameMachine[HASH_TABLE_SIZE];
    }

    public void addGameMachine(GameMachine gameMachine) {
        ensureCapacity(gameMachines, numGameMachines);
        gameMachines[numGameMachines++] = gameMachine;

        // Update the hash table
        addToHashTable(gameMachine);
    }

    public void addGame(Game game) {
        ensureCapacity(games, numGames);
        games[numGames++] = game;
    }

    public void addGamePort(GamePort gamePort) {
        ensureCapacity(gamePorts, numGamePorts);
        gamePorts[numGamePorts++] = gamePort;
    }

    // Merge sort for sorting game machines
    public void sortGameMachinesByLaunchYear() {
        mergeSort(gameMachines, 0, numGameMachines - 1);
    }

    // Binary search for game machines
    public GameMachine findGameMachineByName(String machineName) {
        int hashIndex = hashFunction(machineName);
        return searchHashTable(machineHashTable, hashIndex, machineName);
    }

    // Additional methods for accessing and managing your data can be added as needed

    private void ensureCapacity(Object[] array, int size) {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    private void addToHashTable(GameMachine gameMachine) {
        int hashIndex = hashFunction(gameMachine.getMachineName());
        if (machineHashTable[hashIndex] == null) {
            machineHashTable[hashIndex] = gameMachine;
        } else {
            // Handle collision (simple linear probing)
            int newIndex = (hashIndex + 1) % HASH_TABLE_SIZE;
            while (machineHashTable[newIndex] != null) {
                newIndex = (newIndex + 1) % HASH_TABLE_SIZE;
            }
            machineHashTable[newIndex] = gameMachine;
        }
    }

    private int hashFunction(String key) {
        // A simple hash function for demonstration purposes
        return key.length() % HASH_TABLE_SIZE;
    }

    private void mergeSort(GameMachine[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(GameMachine[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        GameMachine[] leftArray = new GameMachine[n1];
        GameMachine[] rightArray = new GameMachine[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getLaunchYear() <= rightArray[j].getLaunchYear()) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private GameMachine searchHashTable(GameMachine[] table, int hashIndex, String machineName) {
        int index = hashIndex;
        while (table[index] != null && !table[index].getMachineName().equals(machineName)) {
            index = (index + 1) % HASH_TABLE_SIZE;
        }
        return table[index];
    }
}

