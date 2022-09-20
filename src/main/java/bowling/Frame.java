package bowling;

public class Frame {
    private int firstThrow;
    private int secondThrow;
    private int frameTotal;
    private boolean isStrike;
    private boolean isSpare;

    public Frame(String roll) {

        //Strike
        if (roll.equalsIgnoreCase("X")) {
            isStrike = true;
            isSpare = false;
            frameTotal = 10;
        }

        //Spare
        else if (roll.length() > 1 && roll.charAt(1) == '/') {
            isStrike = false;
            isSpare = true;
            frameTotal = 10;
        }

        //not all Pins hit
        else {
            char firstDigit = roll.charAt(0);
            char secondDigit = roll.charAt(1);
            isStrike = false;
            isSpare = false;
            if(firstDigit == '-') {
                firstThrow = 0;
            }
            else {
                firstThrow = Character.getNumericValue(firstDigit);
            }
            if(secondDigit == '-') {
                secondThrow = 0;
            }
            else {
                secondThrow = Character.getNumericValue(secondDigit);;
            }

            frameTotal = firstThrow + secondThrow;
        }
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
