package korobkin.nikita;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EcosystemSimulation {
    private Map<String, Species<?>> ecosystemSpecies = new HashMap<>();

    public void addSpecies(Species<?> species) {
        ecosystemSpecies.put(species.getCommonName(), species);
    }

    public boolean containsSpecies(Species<?> species) {
        return ecosystemSpecies.containsKey(species.getCommonName());
    }

    public void removeSpecies(String commonName) {
        ecosystemSpecies.remove(commonName);
    }

    public void setConditions(double temperature, double humidity, double waterAvailability) {
        // Установка условий для прогноза
    }

    public void runPrediction() {
        // Логика предсказания изменения популяции видов
    }

    public Collection<Species<?>> getEcosystemSpecies() {
        return ecosystemSpecies.values();
    }
}