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
        assertThat(frame.getFrameTotal()).isEqualTo(10);

        frame = new Frame("2/");
        assertThat(frame.getFrameTotal()).isEqualTo(10);

        frame = new Frame("24");
        assertThat(frame.getFrameTotal()).isEqualTo(6);

        frame = new Frame("-1");
        assertThat(frame.getFrameTotal()).isEqualTo(1);

        frame = new Frame("9-");
        assertThat(frame.getFrameTotal()).isEqualTo(9);
    }

}