package bowling;

public class CountingSystem {

    private int[] frameTotals;
    private int totalScore;
    private Frame[] frames;
    private int eleventhRollValue;
    private int twelfthRollValue;

    public void calcGameScore(String rollsequence) {

        initVariables();

        String[] rolls = rollsequence.split(" ");
        Frame currentFrame;

        boolean lastWasSpare = false;
        boolean lastWasStrike = false;
        boolean lastTwoWereStrike = false;

        initFrames(rolls);

        for (int i=0; i<10; i++) {
            currentFrame = frames[i];

            //add basic frame value to total
            frameTotals[i] += currentFrame.getFrameValue();

            if (lastWasSpare) {
                frameTotals[i-1] += currentFrame.getFirstThrow();
            }
            if (lastWasStrike) {
                frameTotals[i-1] += currentFrame.getFrameValue();
            }
            if (lastTwoWereStrike) {
                frameTotals[i-2] += currentFrame.getFirstThrow();
            }

            lastTwoWereStrike = (lastWasStrike && currentFrame.isStrike()) ? true : false;
            lastWasSpare = currentFrame.isSpare() ? true : false;
            lastWasStrike = currentFrame.isStrike() ? true : false;

        }

        //Bonus Throws
        if (rolls.length == 11) {
            String eleventhRoll = rolls[10];
            //no Strike, two Throws
            if (eleventhRoll.length() == 2) {
                Frame tempFrame = new Frame(eleventhRoll);
                eleventhRollValue = tempFrame.getFrameValue();
            }
            //Strike or single Throw after Spare
            else {
                //Strike
                if(eleventhRoll.equalsIgnoreCase("X")) {
                    eleventhRollValue = 10;
                }
                //Single Throw
                else {
                    eleventhRollValue = Integer.valueOf(eleventhRoll);
                }
            }
        }
        //Two final Strikes
        if (rolls.length == 12) {
            //edge case "all Strikes" requires a little dirty fix on 9. Frame
            frameTotals[8] += 10;

            eleventhRollValue = 10;
            twelfthRollValue = 10;
        }

        frameTotals[9] += eleventhRollValue + twelfthRollValue;

        //add up final Score
        for (int i=0; i<10; i++) {
            totalScore += frameTotals[i];
        }

        System.out.println("The total score for the game " + rollsequence + " is: " + totalScore);

    }

    private void initVariables() {
        totalScore = 0;
        eleventhRollValue = 0;
        twelfthRollValue = 0;
        frames = new Frame[10];
        frameTotals = new int[10];
    }

    private void initFrames(String[] rolls) {
        //create Frames from input
        for (int i=0; i<10; i++) {
            frames[i] = new Frame(rolls[i]);
        }
    }

    //for testing methods
    public int getTotalScore() {
        return totalScore;
    }
}
