package eu.binarystars.cleancode.switchex;

import java.util.Map;
import java.util.function.Consumer;

public class Switch2 {
    Map<String, Hero> powerToHeroMap = Map.of(
            "wind", new Storm(),
            "laser", new Cyclops(),
            "DEFAULT", new Aquaman()
    );
    void useForce(String power, Consumer<String> forceConsumer) {
        var hero = powerToHeroMap.getOrDefault(power, powerToHeroMap.get("DEFAULT"));
        hero.useForce(forceConsumer);
    }
}
