package eu.binarystars.cleancode.switchex;

import java.util.Map;

public class Switch {
    String getHero(String power) {
        switch (power) {
            case "wind":
                return "Storm";
            case "laser":
                return "Cyclops";
            default:
                return "Aquaman";
        }
    }

    Map<String, String> powerToHeroMap = Map.of(
            "wind", "Storm",
            "laser", "Cyclops",
            "DEFAULT", "Aquaman"
    );
    String getHero2(String power) {
        return powerToHeroMap.getOrDefault(power, powerToHeroMap.get("DEFAULT"));
    }
}
