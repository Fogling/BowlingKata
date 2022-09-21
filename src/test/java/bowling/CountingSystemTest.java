package bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class CountingSystemTest {
    CountingSystem countingSystem;

    @Test
    void allMissEqualsZero() {
        countingSystem = new CountingSystem();
        countingSystem.calcGameScore("-- -- -- -- -- -- -- -- -- --");
        assertThat(countingSystem.getTotalScore()).as("Zero Frames equals 0:").isEqualTo(0);
    }

    @Test
    void allStrikesEquals300() {
        countingSystem = new CountingSystem();
        countingSystem.calcGameScore("X X X X X X X X X X X X");
        assertThat(countingSystem.getTotalScore()).as("All Strikes equals 300").isEqualTo(300);

    }

    @Test
    void edgeCases() {
        countingSystem = new CountingSystem();

        countingSystem.calcGameScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        assertThat(countingSystem.getTotalScore()).as("All Nines and Miss").isEqualTo(90);

        countingSystem.calcGameScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5");
        assertThat(countingSystem.getTotalScore()).as("All Fives and Spare").isEqualTo(150);

        countingSystem.calcGameScore("X 11 11 11 11 11 11 11 11 11");
        assertThat(countingSystem.getTotalScore()).as("Strike in First Roll and Ones").isEqualTo(30);

        countingSystem.calcGameScore("11 11 11 11 11 11 11 11 11 X 11");
        assertThat(countingSystem.getTotalScore()).as("Strike in Last Roll and Ones").isEqualTo(30);

        countingSystem.calcGameScore("4/ 11 11 11 11 11 11 11 11 11");
        assertThat(countingSystem.getTotalScore()).as("Spare in First Roll and Ones, One after Spare").isEqualTo(29);

        countingSystem.calcGameScore("4/ -1 11 11 11 11 11 11 11 11");
        assertThat(countingSystem.getTotalScore()).as("Spare in First Roll and Ones, Miss after Spare").isEqualTo(27);

        countingSystem.calcGameScore("11 11 11 11 11 11 11 11 11 4/ 1");
        assertThat(countingSystem.getTotalScore()).as("Spare in Last Roll and Ones").isEqualTo(29);

        countingSystem.calcGameScore("11 11 11 11 11 11 11 11 11 11");
        assertThat(countingSystem.getTotalScore()).as("All Ones").isEqualTo(20);

        countingSystem.calcGameScore("22 22 22 22 22 22 22 22 22 22");
        assertThat(countingSystem.getTotalScore()).as("All Twos").isEqualTo(40);

    }

    @Test
    void realisticGames() {
        countingSystem = new CountingSystem();

        countingSystem.calcGameScore("X 3/ 5- 7/ -2 33 X X 4- 6/ X");
        assertThat(countingSystem.getTotalScore()).as("Realistic Game 1").isEqualTo(120);

        countingSystem.calcGameScore("2/ X -- 4/ 5- X 34 71 5/ X 3/");
        assertThat(countingSystem.getTotalScore()).as("Realistic Game 2").isEqualTo(122);

    }
}
