package pl.lotto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game lotto =  new Lotto();
        lotto.play();
    }
}
