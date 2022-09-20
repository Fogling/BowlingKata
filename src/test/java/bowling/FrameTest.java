package bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class FrameTest {
    Frame frame;
    @Test
    void xEqualsStrike() {
        frame = new Frame("X");
        assertThat(frame.isStrike()).isTrue();
    }
    @Test
    void slashEqualsSpare() {
        frame = new Frame("2/");
        assertThat(frame.isSpare()).isTrue();

        frame = new Frame("-/");
        assertThat(frame.isSpare()).isTrue();
    }

    @Test
    void frameTotalCorrect() {
        frame = new Frame("X");
        assertThat(frame.getFrameTotal()).as("Strike equals 10:").isEqualTo(10);

        frame = new Frame("2/");
        assertThat(frame.getFrameTotal()).as("Spare equals 10:").isEqualTo(10);

        frame = new Frame("24");
        assertThat(frame.getFrameTotal()).as("2 and 4 equals 6:").isEqualTo(6);

        frame = new Frame("-1");
        assertThat(frame.getFrameTotal()).as("Miss and 1 equals 1:").isEqualTo(1);

        frame = new Frame("9-");
        assertThat(frame.getFrameTotal()).as("9 and miss equals 9:").isEqualTo(9);
    }

}