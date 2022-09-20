package bowling;

public class BowlingLine {

    private Frame[] frames;
    private int totalScore;


    public BowlingLine (Frame[] frames) {

    }

    public Frame[] getFrames() {
        return frames;
    }

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
