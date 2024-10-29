package korobkin.nikita;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class EcosystemManager {
    private final EcosystemSimulation ecosystemSimulation;
    private final SpeciesLoader<Species<?>> speciesLoader;
    private final FoodChainLoader foodChainLoader;
    private final List<Species<?>> availableSpecies;

    public EcosystemManager(SpeciesLoader<Species<?>> speciesLoader, FoodChainLoader foodChainLoader, EcosystemSimulation ecosystemSimulation) throws IOException {
        this.speciesLoader = speciesLoader;
        this.foodChainLoader = foodChainLoader;
        this.ecosystemSimulation = ecosystemSimulation;
        this.availableSpecies = speciesLoader.loadSpeciesFromFile("species.txt"); // Загрузка списка видов при инициализации
    }

    public List<Species<?>> getAvailableSpecies() {
        return availableSpecies;
    }

    public void addSpeciesToEcosystem(Species<?> species) {
        if (ecosystemSimulation.containsSpecies(species)) {
            System.out.println("Этот вид уже добавлен в экосистему.");
        } else {
            System.out.println("Вид добавлен в экосистему: " + species);
            ecosystemSimulation.addSpecies(species);
        }
    }

    public void removeSpeciesFromEcosystem(String scientificName) {
        ecosystemSimulation.removeSpecies(scientificName);
    }

    public void setEcosystemConditions(double temperature, double humidity, double waterAvailability) {
        ecosystemSimulation.setConditions(temperature, humidity, waterAvailability);
    }

    public void loadFoodChainsAndClimateData(String filename) {
        foodChainLoader.loadFoodChains(filename);
    }

    public void runSimulationAndPrediction() {
        ecosystemSimulation.runPrediction();
    }

    public EcosystemSimulation getEcosystemSimulation() {
        return ecosystemSimulation;
    }

    public SpeciesLoader<Species<?>> getSpeciesLoader() {
        return speciesLoader;
    }

    public FoodChainLoader getFoodChainLoader() {
        return foodChainLoader;
    }

    public Collection<Species<?>> getEcosystemSpecies() {
        return ecosystemSimulation.getEcosystemSpecies();
    }
}
