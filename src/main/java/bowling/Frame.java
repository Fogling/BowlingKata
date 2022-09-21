package bowling;

public class Frame {
    private int firstThrow;
    private int secondThrow;
    private int frameValue; // Value BEFORE Strike or Spare Bonus
    private boolean isStrike;
    private boolean isSpare;

    public Frame(String roll) {
        char firstDigit = roll.charAt(0);

        //Strike
        if (roll.equalsIgnoreCase("X")) {
            isStrike = true;
            isSpare = false;
            frameValue = 10;
            firstThrow = 10;
        }

        //Spare
        else if (roll.length() > 1 && roll.charAt(1) == '/') {
            isStrike = false;
            isSpare = true;
            frameValue = 10;

            if(firstDigit == '-') {
                firstThrow = 0;
                secondThrow = 10;
            }
            else {
                firstThrow = Character.getNumericValue(firstDigit);
                secondThrow = 10-firstThrow;
            }
        }

        //not all Pins hit
        else {
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

            frameValue = firstThrow + secondThrow;
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

    public int getFrameValue() {
        return frameValue;
    }

    public void setFrameValue(int frameValue) {
        this.frameValue = frameValue;
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
