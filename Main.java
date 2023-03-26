import java.util.*;

class Player implements Comparable<Player> {
    private String playerName;
    private int noOfGoals;
    private double average;

    public Player(String playerName, int noOfGoals, double average) {
        this.playerName = playerName;
        this.noOfGoals = noOfGoals;
        this.average = average;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNoOfGoals() {
        return noOfGoals;
    }

    public void setNoOfGoals(int noOfGoals) {
        this.noOfGoals = noOfGoals;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return playerName + " " + noOfGoals + " " + average;
    }

    @Override
    public int compareTo(Player other) {
        if (this.noOfGoals != other.noOfGoals) {
            return other.noOfGoals - this.noOfGoals;
        } else if (this.average != other.average) {
            return Double.compare(other.average, this.average);
        } else {
            return this.playerName.compareTo(other.playerName);
        }
    }
}

public class Main {
    public static TreeMap<Player, Integer> getMapOfSelectedPlayers(Map<Integer, Player> playerMap) {
        TreeMap<Player, Integer> treeMapOfPlayers = new TreeMap<>();
        for (Map.Entry<Integer, Player> entry : playerMap.entrySet()) {
            treeMapOfPlayers.put(entry.getValue(), entry.getValue().getNoOfGoals());
        }
        return treeMapOfPlayers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();
        Map<Integer, Player> playerMap = new HashMap<>();
        for (int i = 1; i <= numPlayers; i++) {
            String playerName = scanner.next();
            int noOfGoals = scanner.nextInt();
            double average = scanner.nextDouble();
            playerMap.put(i, new Player(playerName, noOfGoals, average));
        }
        TreeMap<Player, Integer> result = getMapOfSelectedPlayers(playerMap);
        System.out.println(result);
    }
}
