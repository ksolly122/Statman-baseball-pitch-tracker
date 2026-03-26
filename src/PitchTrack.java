import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PitchTrack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter player's name (or 'exit' to quit): ");
            String playerName = scanner.nextLine().trim();

            if (playerName.equalsIgnoreCase("exit")) {
                break;
            }

            Player player = new Player(playerName);
            PitchCounter pitchCounter = new PitchCounter(player);

            // Check if the file already exists
            File playerFile = new File(playerName + "_stats.txt");
            boolean fileExists = playerFile.exists();

            if (fileExists) {
                System.out.print("Player file already exists. Do you want to update it? (yes/no): ");
                String updateChoice = scanner.nextLine().toLowerCase();

                if (updateChoice.equals("yes")) {
                    // Load existing player statistics from the file and update the player object
                    Player existingPlayer = loadPlayerFromFile(playerFile);
                    player = existingPlayer;
                    pitchCounter = new PitchCounter(player);
                    System.out.println("Existing player statistics loaded.");
                } else {
                    System.out.println("Starting a new file.");
                }
            }

            while (true) {
                System.out.print("Enter pitch result:\n 1. first pitch strike\n 2. strike\n 3. ball\n 4. hit\n 5. exit\n ");
                String pitchResult = scanner.nextLine().toLowerCase();

                if (pitchResult.equals("5")) {
                    break;
                }

                pitchCounter.recordPitch(pitchResult);
                updateStatistics(player, pitchResult);
                pitchCounter.recordWhatHappened();
            }

            // Save player statistics to a text file
            try {
                FileWriter writer = new FileWriter(playerName + "_stats.txt");
                writer.write(player.toString());
                writer.close();
                System.out.println("Player stats saved to " + playerName + "_stats.txt");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }

        System.out.println("Program exited.");
    }

    // Load player statistics from a file
    // Load player statistics from a file
    public static Player loadPlayerFromFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String playerName = scanner.nextLine().replace("Player: ", "");
            Player player = new Player(playerName);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String statName = parts[0];
                    int statValue = Integer.parseInt(parts[1]);
                    switch (statName) {
                        case "Total Pitches":
                            player.setTotalPitches(statValue);
                            break;
                        case "Strikes":
                            player.setStrikes(statValue);
                            break;
                        case "Balls":
                            player.setBalls(statValue);
                            break;
                        case "First Pitch Strikes":
                            player.setFirstPitchStrikes(statValue);
                            break;
                        case "Two of Three Strikes":
                            player.setTwoOfThreeStrikes(statValue);
                            break;
                        case "Two-Strike Execution":
                            player.setTwoStrikeExecution(statValue);
                            break;
                        case "Batter Out Under 5 Pitches":
                            player.setBatterOutUnderFivePitches(statValue);
                            break;
                        case "Strikeouts":
                            player.setStrikeouts(statValue);
                            break;
                        case "Walks":
                            player.setWalks(statValue);
                            break;
                        case "Four-Pitch Walks":
                            player.setFourPitchWalks(statValue);
                            break;
                        case "Two-Out Walks":
                            player.setTwoOutHits(statValue);
                            break;
                        case "0-2 Hits":
                            player.setZeroTwoHits(statValue);
                            break;
                        case "Hits":
                            player.setHits(statValue);
                            break;
                        case "3-2 Count":
                            player.setThreeTwoCount(statValue);
                            break;
                        case "Hit By Pitch":
                            player.setHitByPitch(statValue);
                            break;
                    }
                }
            }

            scanner.close();
            return player;
        } catch (IOException e) {
            System.err.println("Error loading player statistics from file: " + e.getMessage());
        }
        return null;
    }

    // Update player statistics based on pitch result
    private static void updateStatistics(Player player, String pitchResult) {
        switch (pitchResult) {
            case "strike":
                player.incrementStrikes();
                break;
            case "ball":
                player.incrementBalls();
                break;
            case "hit":
                player.incrementHits();
                break;
            case "first pitch strike":
                player.incrementFirstPitchStrikes();
                player.incrementStrikes();
        }
    }
}