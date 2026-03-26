import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PitchTrackGUI extends JFrame {
    private JTextField playerNameField;
    private JButton startButton;
    private Player currentPlayer;
    private PitchCounter pitchCounter;

    public PitchTrackGUI() {
        setTitle("Pitch Tracking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        playerNameField = new JTextField(20);
        startButton = new JButton("Start Tracking");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTracking();
            }
        });

        add(new JLabel("Enter player's name: "));
        add(playerNameField);
        add(startButton);
    }

    private void startTracking() {
        String playerName = playerNameField.getText().trim();
    
        if (playerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a player's name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        currentPlayer = new Player(playerName);
        pitchCounter = new PitchCounter(currentPlayer);
    
        // Check if the file already exists
        File playerFile = new File("PlayerData" + File.separator + playerName + "_stats.txt");
        boolean fileExists = playerFile.exists();
    
        if (!fileExists) {
            // Create a new player file if it doesn't exist
            currentPlayer = new Player(playerName);
    
            // Initialize player statistics (you may customize this part)
            currentPlayer.setTotalPitches(0);
            currentPlayer.setStrikes(0);
            currentPlayer.setBalls(0);
            // Initialize other statistics as needed
    
            JOptionPane.showMessageDialog(this, "New player file created.");
        } else {
            int choice = JOptionPane.showConfirmDialog(this,
                    "Player file already exists. Do you want to update it?", "File Exists",
                    JOptionPane.YES_NO_OPTION);
    
            if (choice == JOptionPane.NO_OPTION) {
                currentPlayer = null; // Reset current player
                playerNameField.setText(""); // Clear player name field
                return;
            } else {
                // Load existing player statistics from the file and update the player object
                Player existingPlayer = PitchTrack.loadPlayerFromFile(playerFile);
                currentPlayer = existingPlayer;
                pitchCounter = new PitchCounter(currentPlayer);
                JOptionPane.showMessageDialog(this, "Existing player statistics loaded.");
            }
        }
    
        // Create a new frame for pitch tracking
        JFrame pitchFrame = new PitchTrackingFrame(currentPlayer, pitchCounter);
        pitchFrame.setVisible(true);
    
        // Hide the current frame
        setVisible(false);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PitchTrackGUI gui = new PitchTrackGUI();
                gui.setVisible(true);
            }
        });
    }
}

