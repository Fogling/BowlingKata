package bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class FrameTest {
    Frame frame;
    @Test
    void xEqualsStrike() {
        frame = new Frame("X");
        assertThat(frame.isStrike()).isTrue();
        assertThat(frame.isSpare()).isFalse();
    }
    @Test
    void slashEqualsSpare() {
        frame = new Frame("2/");
        assertThat(frame.isSpare()).isTrue();
        assertThat(frame.isStrike()).isFalse();

        frame = new Frame("-/");
        assertThat(frame.isSpare()).isTrue();
        assertThat(frame.isStrike()).isFalse();
    }

    @Test
    void frameValueCorrect() {
        frame = new Frame("X");
        assertThat(frame.getFrameValue()).as("Strike equals 10:").isEqualTo(10);

        frame = new Frame("2/");
        assertThat(frame.getFrameValue()).as("2 and Spare equals 10:").isEqualTo(10);

        frame = new Frame("2/");
        assertThat(frame.getFrameValue()).as("miss and Spare equals 10:").isEqualTo(10);

        frame = new Frame("24");
        assertThat(frame.getFrameValue()).as("2 and 4 equals 6:").isEqualTo(6);

        frame = new Frame("-1");
        assertThat(frame.getFrameValue()).as("Miss and 1 equals 1:").isEqualTo(1);

        frame = new Frame("9-");
        assertThat(frame.getFrameValue()).as("9 and miss equals 9:").isEqualTo(9);
    }

}