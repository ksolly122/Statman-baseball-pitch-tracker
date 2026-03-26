import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class PitchTrackingFrame extends JFrame {
    private Player currentPlayer;
    private PitchCounter pitchCounter;

    // GUI components for statistics
    private JLabel nameLabel;

    private JButton incrementTotalPitchesButton;
    private JButton decrementTotalPitchesButton;
    private JLabel totalPitchesLabel;

    private JButton incrementStrikesButton;
    private JButton decrementStrikesButton;
    private JLabel strikesLabel;

    private JButton incrementBallsButton;
    private JButton decrementBallsButton;
    private JLabel ballsLabel;

    private JButton incrementFirstPitchStrikesButton;
    private JButton decrementFirstPitchStrikesButton;
    private JLabel firstPitchStrikesLabel;

    private JButton incrementTwoOfThreeStrikesButton;
    private JButton decrementTwoOfThreeStrikesButton;
    private JLabel twoOfThreeStrikesLabel;

    private JButton incrementTwoStrikeExecutionButton;
    private JButton decrementTwoStrikeExecutionButton;
    private JLabel twoStrikeExecutionLabel;

    private JButton incrementBatterOutUnderFivePitchesButton;
    private JButton decrementBatterOutUnderFivePitchesButton;
    private JLabel batterOutUnderFivePitchesLabel;

    private JButton incrementStrikeoutsButton;
    private JButton decrementStrikeoutsButton;
    private JLabel strikeoutsLabel;

    private JButton incrementWalksButton;
    private JButton decrementWalksButton;
    private JLabel walksLabel;

    private JButton incrementFourPitchWalksButton;
    private JButton decrementFourPitchWalksButton;
    private JLabel fourPitchWalksLabel;

    // private JButton incrementTwoOutHitsButton;
    // private JButton decrementTwoOutHitsButton;
    // private JLabel twoOutHitsLabel;

    private JButton incrementZeroTwoHitsButton;
    private JButton decrementZeroTwoHitsButton;
    private JLabel zeroTwoHitsLabel;

    private JButton incrementHitsButton;
    private JButton decrementHitsButton;
    private JLabel hitsLabel;

    private JButton incrementThreeTwoCountButton;
    private JButton decrementThreeTwoCountButton;
    private JLabel threeTwoCountLabel;

    private JButton incrementHitByPitchButton;
    private JButton decrementHitByPitchButton;
    private JLabel hitByPitchLabel;

    private JButton incrementBattersFacedButton;
    private JButton decrementBattersFacedButton;
    private JLabel battersFacedLabel;

    private JButton saveAndExitButton;

    private JPanel leftColumnPanel;
    private JPanel rightColumnPanel;

    public PitchTrackingFrame(Player player, PitchCounter pitchCounter) {
        this.currentPlayer = player;
        this.pitchCounter = pitchCounter;

        setTitle("Pitch Tracking for " + player.getName());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 

        // Initialize GUI components
        initGUI();

        // Update labels with player's current statistics
        updateLabels();

        // Initialize the save and exit button
        saveAndExitButton = new JButton("Save & Exit");
        saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndExit();
            }
        });

        // Add the save and exit button to the frame
        add(saveAndExitButton, BorderLayout.SOUTH);
    }

    private void saveAndExit() {
        int choice = JOptionPane.showOptionDialog(
                this,
                "Do you want to save the player's statistics and return to the main menu?",
                "Save & Exit",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Save & Return", "Return Without Saving", "Cancel"},
                "Save & Return"
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Save player statistics to a file
            File playerFile = new File("PlayerData" + File.separator + currentPlayer.getName() + "_stats.txt");
            try {
                String playerStats = currentPlayer.toString();
                Files.write(playerFile.toPath(), playerStats.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                JOptionPane.showMessageDialog(this, "Player statistics saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to save player statistics.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Return to the main menu
            returnToMainMenu();
        } else if (choice == JOptionPane.NO_OPTION) {
            // Return to the main menu without saving
            returnToMainMenu();
        }
        // If the user selects "Cancel," do nothing
    }

    private void returnToMainMenu() {
        // Create a new frame for the main menu
        PitchTrackGUI mainMenuFrame = new PitchTrackGUI();
        mainMenuFrame.setVisible(true);

        // Close the current frame
        dispose();
    }

    private void initGUI() {
        // Create buttons and labels for each statistic
        nameLabel = new JLabel("Player: " + currentPlayer.getName());

        // Initialize left and right column panels
        leftColumnPanel = new JPanel();
        leftColumnPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Single column layout
        
        rightColumnPanel = new JPanel();
        rightColumnPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Single column layout

        incrementTotalPitchesButton = new JButton("+ Total Pitches");
        decrementTotalPitchesButton = new JButton("- Total Pitches");
        totalPitchesLabel = new JLabel("Total Pitches: " + currentPlayer.getTotalPitches());
    
        incrementStrikesButton = new JButton("+ Strikes");
        decrementStrikesButton = new JButton("- Strikes");
        strikesLabel = new JLabel("Strikes: " + currentPlayer.getStrikes());
    
        incrementBallsButton = new JButton("+ Balls");
        decrementBallsButton = new JButton("- Balls");
        ballsLabel = new JLabel("Balls: " + currentPlayer.getBalls());
    
        incrementFirstPitchStrikesButton = new JButton("+ First Pitch Strikes");
        decrementFirstPitchStrikesButton = new JButton("- First Pitch Strikes");
        firstPitchStrikesLabel = new JLabel("First Pitch Strikes: " + currentPlayer.getFirstPitchStrikes());
    
        incrementTwoOfThreeStrikesButton = new JButton("+ Two of Three Strikes");
        decrementTwoOfThreeStrikesButton = new JButton("- Two of Three Strikes");
        twoOfThreeStrikesLabel = new JLabel("Two of Three Strikes: " + currentPlayer.getTwoOfThreeStrikes());
    
        incrementTwoStrikeExecutionButton = new JButton("+ Two-Strike Execution");
        decrementTwoStrikeExecutionButton = new JButton("- Two-Strike Execution");
        twoStrikeExecutionLabel = new JLabel("Two-Strike Execution: " + currentPlayer.getTwoStrikeExecution());
    
        incrementBatterOutUnderFivePitchesButton = new JButton("+ Batter Out Under Five Pitches");
        decrementBatterOutUnderFivePitchesButton = new JButton("- Batter Out Under Five Pitches");
        batterOutUnderFivePitchesLabel = new JLabel("Batter Out Under Five Pitches: " + currentPlayer.getBatterOutUnderFivePitches());
    
        incrementStrikeoutsButton = new JButton("+ Strikeouts");
        decrementStrikeoutsButton = new JButton("- Strikeouts");
        strikeoutsLabel = new JLabel("Strikeouts: " + currentPlayer.getStrikeouts());
    
        incrementWalksButton = new JButton("+ Walks");
        decrementWalksButton = new JButton("- Walks");
        walksLabel = new JLabel("Walks: " + currentPlayer.getWalks());
    
        incrementFourPitchWalksButton = new JButton("+ Four-Pitch Walks");
        decrementFourPitchWalksButton = new JButton("- Four-Pitch Walks");
        fourPitchWalksLabel = new JLabel("Four-Pitch Walks: " + currentPlayer.getFourPitchWalks());
    
        // incrementTwoOutHitsButton = new JButton("+ Two-Out Hits");
        // decrementTwoOutHitsButton = new JButton("- Two-Out Hits");
        // twoOutHitsLabel = new JLabel("Two-Out Hits: " + currentPlayer.getTwoOutHits());
    
        incrementZeroTwoHitsButton = new JButton("+ 0-2 Hits");
        decrementZeroTwoHitsButton = new JButton("- 0-2 Hits");
        zeroTwoHitsLabel = new JLabel("0-2 Hits: " + currentPlayer.getZeroTwoHits());
    
        incrementHitsButton = new JButton("+ Hits");
        decrementHitsButton = new JButton("- Hits");
        hitsLabel = new JLabel("Hits: " + currentPlayer.getHits());
    
        incrementThreeTwoCountButton = new JButton("+ 3-2 Count");
        decrementThreeTwoCountButton = new JButton("- 3-2 Count");
        threeTwoCountLabel = new JLabel("Stolen Bases: " + currentPlayer.getThreeTwoCount());
    
        incrementHitByPitchButton = new JButton("+ Wild Pitches");
        decrementHitByPitchButton = new JButton("- Wild Pitches");
        hitByPitchLabel = new JLabel("Wild Pitches: " + currentPlayer.getHitByPitch());

        incrementBattersFacedButton = new JButton("+ Batters Faced");
        decrementBattersFacedButton = new JButton("- Batters Faced");
        battersFacedLabel = new JLabel("Batters Faced: " + currentPlayer.getBattersFaced());
    
        // Add action listeners for increment/decrement buttons
        incrementTotalPitchesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementTotalPitches();
                updateLabels();
            }
        });
    
        decrementTotalPitchesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementTotalPitches();
                updateLabels();
            }
        });

        incrementStrikesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementStrikes();
                updateLabels();
            }
        });
    
        decrementStrikesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementStrikes();
                updateLabels();
            }
        });

        incrementBallsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementBalls();
                updateLabels();
            }
        });
    
        decrementBallsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementBalls();
                updateLabels();
            }
        });

        incrementFirstPitchStrikesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementFirstPitchStrikes();
                updateLabels();
            }
        });
    
        decrementFirstPitchStrikesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementFirstPitchStrikes();
                updateLabels();
            }
        });

        incrementTwoOfThreeStrikesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementTwoOfThreeStrikes();
                updateLabels();
            }
        });
    
        decrementTwoOfThreeStrikesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementTwoOfThreeStrikes();
                updateLabels();
            }
        });

        incrementTwoStrikeExecutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementTwoStrikeExecution();
                updateLabels();
            }
        });
    
        decrementTwoStrikeExecutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementTwoStrikeExecution();
                updateLabels();
            }
        });

        incrementBatterOutUnderFivePitchesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementBatterOutUnderFivePitches();
                updateLabels();
            }
        });
    
        decrementBatterOutUnderFivePitchesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementtBatterOutUnderFivePitches();
                updateLabels();
            }
        });

        incrementStrikeoutsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementStrikeouts();
                updateLabels();
            }
        });
    
        decrementStrikeoutsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementStrikeouts();
                updateLabels();
            }
        });

        incrementWalksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementWalks();
                updateLabels();
            }
        });
    
        decrementWalksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementtWalks();
                updateLabels();
            }
        });

        incrementFourPitchWalksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementFourPitchWalks();;
                updateLabels();
            }
        });
    
        decrementFourPitchWalksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementFourPitchWalks();
                updateLabels();
            }
        });

        incrementZeroTwoHitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementZeroTwoHits();
                updateLabels();
            }
        });
    
        decrementZeroTwoHitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementZeroTwoHits();
                updateLabels();
            }
        });

        incrementHitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementHits();
                updateLabels();
            }
        });
    
        decrementHitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementHits();
                updateLabels();
            }
        });

        incrementThreeTwoCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementThreeTwoCount();
                updateLabels();
            }
        });
    
        decrementThreeTwoCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementThreeTwoCount();;
                updateLabels();
            }
        });

        incrementHitByPitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementHitByPitch();;
                updateLabels();
            }
        });
    
        decrementHitByPitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementHitByPitch();;
                updateLabels();
            }
        });

        incrementBattersFacedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.incrementBattersFaced();
                updateLabels();
            }
        });
        
        decrementBattersFacedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.decrementBattersFaced();
                updateLabels();
            }
        });
    
        // Add buttons and labels to the frame
        add(nameLabel);

        leftColumnPanel.add(totalPitchesLabel);
        leftColumnPanel.add(incrementTotalPitchesButton);
        leftColumnPanel.add(decrementTotalPitchesButton);

        leftColumnPanel.add(strikesLabel);
        leftColumnPanel.add(incrementStrikesButton);
        leftColumnPanel.add(decrementStrikesButton);

        leftColumnPanel.add(ballsLabel);
        leftColumnPanel.add(incrementBallsButton);
        leftColumnPanel.add(decrementBallsButton);

        leftColumnPanel.add(firstPitchStrikesLabel);
        leftColumnPanel.add(incrementFirstPitchStrikesButton);
        leftColumnPanel.add(decrementFirstPitchStrikesButton);

        leftColumnPanel.add(twoOfThreeStrikesLabel);
        leftColumnPanel.add(incrementTwoOfThreeStrikesButton);
        leftColumnPanel.add(decrementTwoOfThreeStrikesButton);

        leftColumnPanel.add(twoStrikeExecutionLabel);
        leftColumnPanel.add(incrementTwoStrikeExecutionButton);
        leftColumnPanel.add(decrementTwoStrikeExecutionButton);

        leftColumnPanel.add(batterOutUnderFivePitchesLabel);
        leftColumnPanel.add(incrementBatterOutUnderFivePitchesButton);
        leftColumnPanel.add(decrementBatterOutUnderFivePitchesButton);

        rightColumnPanel.add(strikeoutsLabel);
        rightColumnPanel.add(incrementStrikeoutsButton);
        rightColumnPanel.add(decrementStrikeoutsButton);

        rightColumnPanel.add(walksLabel);
        rightColumnPanel.add(incrementWalksButton);
        rightColumnPanel.add(decrementWalksButton);

        rightColumnPanel.add(fourPitchWalksLabel);
        rightColumnPanel.add(incrementFourPitchWalksButton);
        rightColumnPanel.add(decrementFourPitchWalksButton);

        // add(twoOutHitsLabel);
        // add(incrementTwoOutHitsButton);
        // add(decrementTwoOutHitsButton);

        rightColumnPanel.add(hitsLabel);
        rightColumnPanel.add(incrementHitsButton);
        rightColumnPanel.add(decrementHitsButton);

        rightColumnPanel.add(zeroTwoHitsLabel);
        rightColumnPanel.add(incrementZeroTwoHitsButton);
        rightColumnPanel.add(decrementZeroTwoHitsButton);

        rightColumnPanel.add(threeTwoCountLabel);
        rightColumnPanel.add(incrementThreeTwoCountButton);
        rightColumnPanel.add(decrementThreeTwoCountButton);

        rightColumnPanel.add(hitByPitchLabel);
        rightColumnPanel.add(incrementHitByPitchButton);
        rightColumnPanel.add(decrementHitByPitchButton);

        rightColumnPanel.add(battersFacedLabel);
        rightColumnPanel.add(incrementBattersFacedButton);
        rightColumnPanel.add(decrementBattersFacedButton);

        // Add nameLabel and the left and right column panels to the frame
        add(nameLabel, BorderLayout.NORTH); // Place nameLabel at the top
        add(leftColumnPanel, BorderLayout.WEST); // Left column
        add(rightColumnPanel, BorderLayout.EAST); // Right column
    
        // Pack and center the frame
        pack();
        setLocationRelativeTo(null);
    }
    

    private void updateLabels() {
        nameLabel.setText("Player: " + currentPlayer.getName());
        totalPitchesLabel.setText("Total Pitches: " + currentPlayer.getTotalPitches());
        strikesLabel.setText("Strikes: " + currentPlayer.getStrikes());
        ballsLabel.setText("Balls: " + currentPlayer.getBalls());
        firstPitchStrikesLabel.setText("First Pitch Strikes: " + currentPlayer.getFirstPitchStrikes());
        twoOfThreeStrikesLabel.setText("Two of Three Strikes: " + currentPlayer.getTwoOfThreeStrikes());
        twoStrikeExecutionLabel.setText("Two-Strike Execution: " + currentPlayer.getTwoStrikeExecution());
        batterOutUnderFivePitchesLabel.setText("Batter Out Under 5 Pitches: " + currentPlayer.getBatterOutUnderFivePitches());
        strikeoutsLabel.setText("Strikeouts: " + currentPlayer.getStrikeouts());
        walksLabel.setText("Walks: " + currentPlayer.getWalks());
        fourPitchWalksLabel.setText("Four-Pitch Walks: " + currentPlayer.getFourPitchWalks());
        // twoOutHitsLabel.setText("Two-Out Walks: " + currentPlayer.getTwoOutHits());
        hitsLabel.setText("Hits: " + currentPlayer.getHits());
        zeroTwoHitsLabel.setText("0-2 Hits: " + currentPlayer.getZeroTwoHits());
        threeTwoCountLabel.setText("3-2 Count: " + currentPlayer.getThreeTwoCount());
        hitByPitchLabel.setText("Hit By Pitch: " + currentPlayer.getHitByPitch());
        battersFacedLabel.setText("Batters Faced: " + currentPlayer.getBattersFaced());

        // // Repaint the frame
        // repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Player player = new Player("TestPlayer");
                PitchCounter pitchCounter = new PitchCounter(player);
                PitchTrackingFrame frame = new PitchTrackingFrame(player, pitchCounter);
                frame.setVisible(true);
            }
        });
    }
}
