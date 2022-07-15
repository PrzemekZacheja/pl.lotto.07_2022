package pl.lotto;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class PlayerNumbersTest {

    @Test
    void shouldSavedSixNumberToTable() throws IOException {
        //given
        PlayerNumbersForLotto playerNumbers =  new PlayerNumbersForLotto();
        //when
        int [] result = playerNumbers.getNumbers();
        //then

    }

}