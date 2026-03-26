# StatMan Baseball Pitch Tracker

## Overview
StatMan is a Java application for tracking pitcher performance and game-level pitching statistics. It includes both a command-line version and a Swing-based GUI for recording outcomes, updating player stats, and saving results to text files.

This is one of my strongest portfolio projects because it combines programming with baseball in a practical way.

## What It Does
- Tracks pitching stats for individual players
- Records pitch results such as strikes, balls, hits, and first-pitch strikes
- Records game events such as strikeouts, walks, hit-by-pitch, and zero-two hits
- Supports saving player stat summaries to text files
- Includes both a console workflow and a GUI workflow

## Main Features
### Command-Line Tracker
The command-line version lets a user enter a player name, record pitch outcomes, update event data, and save the player's stats to a file.

### GUI Tracker
The GUI version uses Java Swing to provide a more user-friendly interface for entering and updating pitching statistics.

### File-Based Stat Storage
The application can save and load stat files so that player data can be reviewed or updated later.

## Project Structure
- `src/Player.java` - player model and stat counters
- `src/PitchCounter.java` - logic for recording pitch and event outcomes
- `src/PitchTrack.java` - command-line tracker entry point
- `src/PitchTrackGUI.java` - GUI launcher
- `src/PitchTrackingFrame.java` - main GUI tracking interface
- `sample-data/` - example output files generated from tracked players

## Skills Demonstrated
- Java
- Object-oriented programming
- Java Swing GUI development
- File I/O
- User input handling
- State tracking and statistics management

## Why I Built This
As a baseball player, I wanted a way to track pitcher performance in a more organized and useful way. This project gave me a chance to combine sports with software development and build something practical that reflects my interests.

## How to Compile
From the project root:

```bash
javac src/*.java
```

## How to Run the Command-Line Version
```bash
java -cp src PitchTrack
```

## How to Run the GUI Version
```bash
java -cp src PitchTrackGUI
```

## Notes
This project was cleaned up for portfolio use. I removed editor-specific files and kept the core Java source files plus sample output data so the repo stays focused and easy to understand.
