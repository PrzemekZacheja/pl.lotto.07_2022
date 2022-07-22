package pl.lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    Lotto lotto = new Lotto();
    private final Random r = new Random();

    @Test
    void shouldSaveStringToArray() {
        //given
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String givenNumbers = "1 2 3 4 5 6";
        Scanner scanner = mockScannerIn(givenNumbers);
        Lotto lotto = new Lotto();
        //when
        Set<Integer> returnedArray = lotto.getNumbersFromPlayer(scanner);
        //then
        assertEquals(expected, returnedArray);
    }

    @Test
    void shouldReturnSixNumbersFrom1To99(){
        //given
        //when
        Set<Integer> returnedSet = lotto.getRandomNumbers(r);
        //then
        assertEquals(6, returnedSet.size());
    }

    private Scanner mockScannerIn(String string) {
        InputStream in = System.in;
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(in);
        return scanner;
    }

}