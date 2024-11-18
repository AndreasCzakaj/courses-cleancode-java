package eu.binarystars.cleancode.switchex;

import java.util.function.Consumer;

public class Storm  implements Hero{
    public void useForce(Consumer<String> forceConsumer) {
        forceConsumer.accept("blow'em away!");
    }
}
