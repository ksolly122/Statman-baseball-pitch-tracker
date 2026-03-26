public class Player {
    private String name;
    private int totalPitches;
    private int balls;
    private int strikes;
    private int firstPitchStrikes;
    private int twoOfThreeStrikes;
    private int twoStrikeExecution;
    private int batterOutUnderFivePitches;
    private int strikeouts;
    private int walks;
    private int fourPitchWalks;
    private int twoOutHits;
    private int zeroTwoHits;
    private int hits;
    private int threeTwoCount;
    private int hitByPitch;
    private int battersFaced;

    public Player(String name) {
        this.name = name;
    }

    // Getters and setters for player statistics
    public void incrementTotalPitches() {
        totalPitches++;
    }

    public void decrementTotalPitches() {
        totalPitches--;
    }

    public void incrementStrikes() {
        strikes++;
    }

    public void decrementStrikes() {
        strikes--;
    }

    public void incrementBalls() {
        balls++;
    }

    public void decrementBalls() {
        balls--;
    }

    public void incrementFirstPitchStrikes() {
        firstPitchStrikes++;
    }

    public void decrementFirstPitchStrikes() {
        firstPitchStrikes--;
    }

    public void incrementTwoOfThreeStrikes() {
        twoOfThreeStrikes++;
    }

    public void decrementTwoOfThreeStrikes() {
        twoOfThreeStrikes--;
    }

    public void incrementTwoStrikeExecution() {
        twoStrikeExecution++;
    }

    public void decrementTwoStrikeExecution() {
        twoStrikeExecution--;
    }

    public void incrementBatterOutUnderFivePitches() {
        batterOutUnderFivePitches++;
    }

    public void decrementtBatterOutUnderFivePitches() {
        batterOutUnderFivePitches--;
    }

    public void incrementStrikeouts() {
        strikeouts++;
    }

    public void decrementStrikeouts() {
        strikeouts--;
    }

    public void incrementWalks() {
        walks++;
    }

    public void decrementtWalks() {
        walks--;
    }
    
    public void incrementFourPitchWalks() {
        fourPitchWalks++;
    }

    public void decrementFourPitchWalks() {
        fourPitchWalks--;
    }

    public void incrementTwoOutHits() {
        twoOutHits++;
    }

    public void decrementTwoOutHits() {
        twoOutHits--;
    }

    public void incrementZeroTwoHits() {
        zeroTwoHits++;
    }

    public void decrementZeroTwoHits() {
        zeroTwoHits--;
    }

    public void incrementHits() {
        hits++;
    }

    public void decrementHits() {
        hits--;
    }

    public void incrementThreeTwoCount() {
        threeTwoCount++;
    }

    public void decrementThreeTwoCount() {
        threeTwoCount--;
    }

    public void incrementHitByPitch() {
        hitByPitch++;
    }

    public void decrementHitByPitch() {
        hitByPitch--;
    }

    public void incrementBattersFaced() {
        battersFaced++;
    }
    
    public void decrementBattersFaced() {
        if (battersFaced > 0) {
            battersFaced--;
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalPitches() {
        return totalPitches;
    }

    public void setTotalPitches(int totalPitches) {
        this.totalPitches = totalPitches;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getFirstPitchStrikes() {
        return firstPitchStrikes;
    }

    public void setFirstPitchStrikes(int firstPitchStrikes) {
        this.firstPitchStrikes = firstPitchStrikes;
    }

    public int getTwoOfThreeStrikes() {
        return twoOfThreeStrikes;
    }

    public void setTwoOfThreeStrikes(int twoOfThreeStrikes) {
        this.twoOfThreeStrikes = twoOfThreeStrikes;
    }

    public int getTwoStrikeExecution() {
        return twoStrikeExecution;
    }

    public void setTwoStrikeExecution(int twoStrikeExecution) {
        this.twoStrikeExecution = twoStrikeExecution;
    }

    public int getBatterOutUnderFivePitches() {
        return batterOutUnderFivePitches;
    }

    public void setBatterOutUnderFivePitches(int batterOutUnderFivePitches) {
        this.batterOutUnderFivePitches = batterOutUnderFivePitches;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }

    public int getWalks() {
        return walks;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public int getFourPitchWalks() {
        return fourPitchWalks;
    }

    public void setFourPitchWalks(int fourPitchWalkswalks) {
        this.fourPitchWalks = fourPitchWalkswalks;
    }

    public int getTwoOutHits() {
        return twoOutHits;
    }

    public void setTwoOutHits(int twoOutHits) {
        this.twoOutHits = twoOutHits;
    }

    public int getZeroTwoHits() {
        return zeroTwoHits;
    }

    public void setZeroTwoHits(int zeroTwoHits) {
        this.zeroTwoHits = zeroTwoHits;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getThreeTwoCount() {
        return threeTwoCount;
    }

    public void setThreeTwoCount(int threeTwoCount) {
        this.threeTwoCount = threeTwoCount;
    }

    public int getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(int hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public int getBattersFaced() {
        return battersFaced;
    }

    public void setBattersFaced(int battersFaced) {
        this.battersFaced = battersFaced;
    }

    public double getStrikePercentage() {
        if (totalPitches == 0) {
            return 0.0;
        }
        return (double) strikes / totalPitches * 100.0;
    }    

    @Override
    public String toString() {
        double strikePercentage = getStrikePercentage();

        // Include all the statistics in the toString method
        return "Player: " + name + "\nTotal Pitches: " + totalPitches + "\nStrikes: " + strikes +
               "\nBalls: " + balls +  "\nFirst Pitch Strikes: " + firstPitchStrikes + "\nTwo of Three Strikes: " +
               twoOfThreeStrikes + "\nTwo-Strike Execution: " + twoStrikeExecution + "\nBatter Out Under 5 Pitches: " +
               batterOutUnderFivePitches + "\nStrikeouts: " + strikeouts + "\nWalks: " + walks +
               "\nFour-Pitch Walks: " + fourPitchWalks + "\nHit By Pitch: " + hitByPitch + "\nTwo-Out Walks: " + twoOutHits +
               "\n0-2 Walks: " + zeroTwoHits + "\nHits: " + hits + "\n3-2 Count: " +
               threeTwoCount + "\nBatters Faced: " + battersFaced + "\nStrike Percentage: " + strikePercentage + "%";
    }
}