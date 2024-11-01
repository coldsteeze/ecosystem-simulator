package korobkin.nikita;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Класс для загрузки пищевых цепей и климатических данных
public class FoodChainLoader {
    private Map<String, Set<String>> predatorPreyChains = new HashMap<>();
    private Map<String, Set<String>> plantChains = new HashMap<>();
    private Map<String, PlantClimate> plantClimateData = new HashMap<>(); // Для хранения климатических данных

    public void loadFoodChains(String filename) {
      try  (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            boolean isPlantSection = false;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    if (line.trim().equals("# Климатические показатели растений")) {
                        isPlantSection = true;
                    }
                    continue;
                }

                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    String organism = parts[0].trim();
                    String food = parts[1].trim();

                    if (isPlantSection) {
                        // Добавление пищи для растения
                        plantChains.computeIfAbsent(organism, k -> new HashSet<>()).add(food);
                    } else {
                        // Добавление пищи для хищника
                        predatorPreyChains.computeIfAbsent(organism, k -> new HashSet<>()).add(food);
                    }
                } else if (parts.length == 4 && isPlantSection) {
                    // Чтение данных о климате: Organism, Temperature, Humidity, WaterAvailability
                    String organism = parts[0].trim();
                    double temperature = Double.parseDouble(parts[1].trim());
                    double humidity = Double.parseDouble(parts[2].trim());
                    double waterAvailability = Double.parseDouble(parts[3].trim());

                    plantClimateData.put(organism, new PlantClimate(temperature, humidity, waterAvailability));
                    System.out.println(organism + ": " + temperature + ", " + humidity + ", " + waterAvailability);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<String> getPrey(String predator) {
        return predatorPreyChains.getOrDefault(predator, new HashSet<>());
    }

    public Set<String> getPlants(String organism) {
        return plantChains.getOrDefault(organism, new HashSet<>());
    }

    public PlantClimate getPlantClimate(String organism) {
        return plantClimateData.get(organism);
    }

    public Map<String, Set<String>> getAllPredatorPreyChains() {
        return predatorPreyChains;
    }

    public Map<String, Set<String>> getAllPlantChains() {
        return plantChains;
    }

}
