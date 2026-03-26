import java.util.Scanner;

public class PitchCounter {
    private Player player;

    public PitchCounter(Player player) {
        this.player = player;
    }

    public void recordPitch(String pitchResult) {
        player.incrementTotalPitches();

        if (pitchResult.equalsIgnoreCase("1")) {
            player.incrementFirstPitchStrikes();;
            player.incrementStrikes();
        }
        else if (pitchResult.equalsIgnoreCase("2")) {
            player.incrementStrikes();
        } 
        else if (pitchResult.equalsIgnoreCase("3")) {
            player.incrementBalls();
        }
        else if (pitchResult.equalsIgnoreCase("4")) {
            player.incrementHits();
        }
    }

    public void recordWhatHappened() {
       Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter what happened:\n 1. Strikeout\n 2. Walk\n 3. Four-pitch walk\n 4. Two-out walk\n 5. Zero-two hit\n"+
            " 6. Stolen base\n 7. Wild pitch\n 8. Batter out under 5 pitches\n 9. 2/3 strikes\n 10. 0-2 execution\n e. exit\n");
            String event = scanner.nextLine().toLowerCase();

            if (event.equals("e")) {
                break;
            }

            // Depending on the event, call the corresponding method to record it
            switch (event) {
                case "1":
                    player.incrementStrikeouts();
                    break;
                case "2":
                    player.incrementWalks();
                    break;
                case "3":
                    player.incrementFourPitchWalks();
                    break;
                case "4":
                    player.incrementTwoOutHits();
                    break;
                case "5":
                    player.incrementZeroTwoHits();
                    break;
                case "6":
                    player.incrementThreeTwoCount();
                    break;
                case "7":
                    player.incrementHitByPitch();
                    break;
                case "8":
                    player.incrementBatterOutUnderFivePitches();
                    break;
                case "9":
                    player.incrementTwoOfThreeStrikes();
                    break;
                case "10":
                    player.incrementTwoStrikeExecution();
                    break;
                default:
                    System.out.println("Invalid event. Please enter a valid event or 'exit' to finish.");
            }
        } 
    }
}