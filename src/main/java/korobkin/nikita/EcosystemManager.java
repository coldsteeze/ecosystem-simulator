package korobkin.nikita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EcosystemManager {
    private final EcosystemSimulation ecosystemSimulation;
    private final SpeciesLoader<Species<?>> speciesLoader;
    private final FoodChainLoader foodChainLoader;

    private final List<Species<?>> availableSpecies;
    private final List<Species<?>> ecosystemSpecies;
    private static final String AVAILABLE_SPECIES_FILE = "available_species.txt";
    private static final String ECOSYSTEM_SPECIES_FILE = "ecosystem_species.txt";

    public EcosystemManager(SpeciesLoader<Species<?>> speciesLoader, FoodChainLoader foodChainLoader, EcosystemSimulation ecosystemSimulation, List<Species<?>> ecosystemSpecies) throws IOException {
        this.speciesLoader = speciesLoader;
        this.foodChainLoader = foodChainLoader;
        this.ecosystemSimulation = ecosystemSimulation;
        this.availableSpecies = new ArrayList<>();     // Загрузка видов, из списка доступных
        this.ecosystemSpecies = new ArrayList<>();     // Загрузка видов, уже добавленных в экосистему
    }

    // Метод загрузки доступных видов из файла available_species.txt
    private void loadAvailableSpecies() {
        try {
            availableSpecies.addAll(speciesLoader.loadAvailableSpeciesFromFile(AVAILABLE_SPECIES_FILE));
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке доступных видов: " + e.getMessage());
        }
    }

    // Метод загрузки видов в экосистеме из файла ecosystem_species.txt
    private void loadEcosystemSpecies() {
        try {
            ecosystemSpecies.addAll(speciesLoader.loadEcosystemSpeciesFromFile(ECOSYSTEM_SPECIES_FILE));
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке видов экосистемы: " + e.getMessage());
        }
    }




    // Метод загрузки всех видов из файла
    public void loadAllSpeciesFromFile() {
        loadAvailableSpecies();
        loadEcosystemSpecies();
        for (Species<?> species : ecosystemSpecies) {
            {
                ecosystemSimulation.addSpecies(species);
            }
        }
        System.out.println("Загрузка видов завершена.");
    }


    // Метод для добавления нового вида
    public void addSpeciesToEcosystem(Species<?> species) throws IOException {
        if (ecosystemSimulation.containsSpecies(species)) {
            System.out.println("Этот вид уже добавлен в экосистему.");
        } else {
            ecosystemSimulation.addSpecies(species);
            speciesLoader.saveSpeciesToFile(species, ECOSYSTEM_SPECIES_FILE); // Сохраняем новый вид в файл
            System.out.println("Вид добавлен в экосистему: " + species);
        }
    }


    // Метод для удаления вида по научному названию
    public void removeSpeciesFromEcosystemByScientificName(String scientificName) throws IOException {
        ecosystemSimulation.removeSpeciesByScientificName(scientificName);
        speciesLoader.rewriteFileExcludingSpeciesByScientificName(ECOSYSTEM_SPECIES_FILE,
                scientificName, ecosystemSimulation.getEcosystemSpecies());
    }

    // Метод для удаления вида по обычному названию
    public void removeSpeciesFromEcosystemByCommonName(String commonName) throws IOException {
        ecosystemSimulation.removeSpeciesByCommonName(commonName);
        speciesLoader.rewriteFileExcludingSpeciesByCommonName(ECOSYSTEM_SPECIES_FILE,
                commonName, ecosystemSimulation.getEcosystemSpecies());
    }

    // Метод для установки климатических параметров
    public void setEcosystemConditions(double temperature, double humidity, double waterAvailability) {
        ecosystemSimulation.setConditions(temperature, humidity, waterAvailability);
    }

    // Метод для загрузки пищевых цепей и климатических данных
    public void loadFoodChainsAndClimateData(String filename) {
        foodChainLoader.loadFoodChains(filename);
    }

    // Запуск метода прогноза
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
        return ecosystemSimulation.getAllSpecies();
    }

    public List<Species<?>> getAllAnimals() {
        return ecosystemSimulation.getAllAnimals();
    }

    public List<Species<?>> getAllPlants() {
        return ecosystemSimulation.getAllPlants();
    }

    public List<Species<?>> getMulticellularAnimals() {
        return ecosystemSimulation.getMulticellularAnimals();
    }

    public List<Species<?>> getHigherPlants() {
        return ecosystemSimulation.getHigherPlants();
    }

    public List<Species<?>> getLowerPlants() {
        return ecosystemSimulation.getLowerPlants();
    }

    public List<Species<?>> getAvailableSpecies() {
        return availableSpecies;
    }

    public List<Species<?>> getEcoSpecies() {
        return ecosystemSpecies;
    }
}
