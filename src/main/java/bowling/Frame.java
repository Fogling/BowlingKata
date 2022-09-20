package bowling;

public class Frame {
    private int firstThrow;
    private int secondThrow;
    private int frameTotal;
    private boolean isStrike;
    private boolean isSpare;

    public Frame(String roll) {

    }

    public int getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(int firstThrow) {
        this.firstThrow = firstThrow;
    }

    public int getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(int secondThrow) {
        this.secondThrow = secondThrow;
    }

    public int getFrameTotal() {
        return frameTotal;
    }

    public void setFrameTotal(int frameTotal) {
        this.frameTotal = frameTotal;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }


}
