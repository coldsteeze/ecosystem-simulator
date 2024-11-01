package korobkin.nikita;

import korobkin.nikita.Animals.enums.MulticellularAnimal.GenusAnimalMulticellularAnimal;
import korobkin.nikita.Animals.interfacesAnimal.IGenusAnimal;
import korobkin.nikita.Plants.enums.HigherPlant.GenusPlantHigherPlant;
import korobkin.nikita.Plants.enums.LowerPlant.GenusPlantLowerPlant;
import korobkin.nikita.Plants.interfacesPlant.IGenusPlant;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.*;

public class EcosystemSimulation {
    private Map<String, Species<?>> ecosystemSpecies = new HashMap<>();
    private FoodChainLoader foodChainLoader;
    private double temperature;
    private double humidity;
    private double waterAvailability;

    public EcosystemSimulation(FoodChainLoader foodChainLoader) {
        this.foodChainLoader = foodChainLoader;
    }

    // Добавление видов
    public void addSpecies(Species<?> species) {
        ecosystemSpecies.put(species.getCommonName(), species);
    }

    // Проверка на то, чтобы не было дубликатов при создании видов
    public boolean containsSpecies(Species<?> species) {
        return ecosystemSpecies.containsKey(species.getCommonName());
    }

    // Метод для функционирования удаления по общему названию
    public void removeSpeciesByCommonName(String commonName) {
        ecosystemSpecies.remove(commonName);
    }

    // Метод для функционирования удаления по научному названию
    public void removeSpeciesByScientificName(String scientificName) {
        Species<?> speciesToRemove = findSpeciesByScientificName(scientificName);
        if (speciesToRemove != null) {
            ecosystemSpecies.remove(speciesToRemove.getCommonName());
            System.out.println("Вид " + scientificName + " удален из экосистемы.");
        } else {
            System.out.println("Вид с научным названием " + scientificName + " не найден.");
        }
    }

    // Метод для поиска по научному названию
    private Species<?> findSpeciesByScientificName(String scientificName) {
        for (Species<?> species : ecosystemSpecies.values()) {
            if (species.getScientificName().equalsIgnoreCase(scientificName)) {
                return species;
            }
        }
        return null;
    }

    public void setConditions(double temperature, double humidity, double waterAvailability) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterAvailability = waterAvailability;
    }

    // Метод для запуска прогноза изменения популяций
    public void runPrediction() {
        for (Species<?> species : ecosystemSpecies.values()) {
            String genusName = species.getGenus().getName(); // Научное название рода
            String commonName = species.getCommonName(); // Общее название
            boolean populationChanged = false;

            // Проверка на хищника
            Set<String> prey = foodChainLoader.getPrey(genusName);
            if (!prey.isEmpty()) {
                boolean preyExists = prey.stream().anyMatch(preyName ->
                        ecosystemSpecies.values().stream().anyMatch(s ->
                                s.getGenus().getName().equalsIgnoreCase(preyName))
                );

                if (!preyExists) {
                    populationChanged = true;
                    System.out.println("Популяция вида " + commonName + " (" + genusName + ") уменьшена из-за отсутствия добычи.");
                } else {
                    populationChanged = true;
                    System.out.println("Популяция вида " + commonName + " (" + genusName + ") увеличена из-за наличия добычи.");
                }
            }
            // Проверка на растение
            else if (foodChainLoader.getPlantClimate(genusName) != null) {
                PlantClimate climateData = foodChainLoader.getPlantClimate(genusName);
                boolean favorableConditions = true;

                // Проверка климатических условий
                if (climateData != null) {
                    double tempOptimal = climateData.getTemperature();
                    double humidityOptimal = climateData.getHumidity();
                    double waterOptimal = climateData.getWaterAvailability();

                    // Установим точные пороги для идеальных, приемлемых и неблагоприятных условий
                    boolean isIdealConditions = (temperature >= tempOptimal - 3 && temperature <= tempOptimal + 3) &&
                            (humidity >= humidityOptimal - 5 && humidity <= humidityOptimal + 5) &&
                            (waterAvailability >= waterOptimal - 3 && waterAvailability <= waterOptimal + 3);

                    boolean isAcceptableConditions = !isIdealConditions &&
                            (temperature >= tempOptimal - 5 && temperature <= tempOptimal + 5) &&
                            (humidity >= humidityOptimal - 10 && humidity <= humidityOptimal + 10) &&
                            (waterAvailability >= waterOptimal - 5 && waterAvailability <= waterOptimal + 5);

                    // Логика изменения популяции на основе условий
                    if (isIdealConditions) {
                        populationChanged = true;
                        System.out.println("Популяция вида " + commonName + " (" + genusName + ") увеличена из-за благоприятных условий.");
                    } else if (isAcceptableConditions) {
                        populationChanged = true;
                        System.out.println("Популяция вида " + commonName + " (" + genusName + ") осталась стабильной из-за приемлемых условий.");
                    } else {
                        populationChanged = true;
                        System.out.println("Популяция вида " + commonName + " (" + genusName + ") уменьшена из-за неблагоприятных условий.");
                    }
                }
            }
            // Если популяция не изменилась
            if (!populationChanged) {
                System.out.println("Популяция вида " + commonName + " (" + genusName + ") осталась стабильной.");
            }
        }
    }

    public Collection<Species<?>> getAllSpecies() {
        return ecosystemSpecies.values();
    }

    public List<Species<?>> getAllAnimals() {
        return ecosystemSpecies.values().stream()
                .filter(species -> species.getGenus() instanceof IGenusAnimal)
                .collect(Collectors.toList());
    }

    public List<Species<?>> getAllPlants() {
        return ecosystemSpecies.values().stream()
                .filter(species -> species.getGenus() instanceof IGenusPlant)
                .collect(Collectors.toList());
    }

    public List<Species<?>> getMulticellularAnimals() {
        return getAllAnimals().stream()
                .filter(species -> species.getGenus() instanceof GenusAnimalMulticellularAnimal)
                .collect(Collectors.toList());
    }

    public List<Species<?>> getHigherPlants() {
        return getAllPlants().stream()
                .filter(species -> species.getGenus() instanceof GenusPlantHigherPlant)
                .collect(Collectors.toList());
    }

    public List<Species<?>> getLowerPlants() {
        return getAllPlants().stream()
                .filter(species -> species.getGenus() instanceof GenusPlantLowerPlant)
                .collect(Collectors.toList());
    }

    public Map<String, Species<?>> getEcosystemSpecies() {
        return ecosystemSpecies;
    }
}

