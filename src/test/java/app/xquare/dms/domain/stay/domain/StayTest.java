package app.xquare.dms.domain.stay.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StayTest {

    private StayStatus stayStatus;

    @BeforeEach
    void setUp() {
        stayStatus = StayStatus.builder().build();
    }

    @Test
    void 잔류상태변경_성공_1() {
        String stay = StayOption.VALUES[0];

        stayStatus.setStay(stay);

        assertThat(stayStatus.getStay()).isEqualTo(stay);
    }

    @Test
    void 잔류상태변경_성공_2() {
        String stay = StayOption.VALUES[0];

        stayStatus.setStay(1);

        assertThat(stayStatus.getStay()).isEqualTo(stay);
    }
}
