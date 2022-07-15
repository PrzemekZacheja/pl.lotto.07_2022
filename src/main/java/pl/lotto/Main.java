package pl.lotto;

import pl.lotto.games.Lotto;
import pl.lotto.interfaces.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game lotto =  new Lotto();
        lotto.play();
    }
}
