package korobkin.nikita;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FoodChainLoader {
    private Map<String, Set<String>> predatorPreyChains = new HashMap<>();
    private Map<String, Set<String>> plantChains = new HashMap<>();
    private Map<String, PlantClimate> plantClimateData = new HashMap<>(); // Для хранения климатических данных

    public void loadFoodChains(String filename) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            boolean isPlantSection = false;

            while ((line = br.readLine()) != null) {
                // Игнорируем комментарии и пустые строки
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    if (line.trim().equals("# Растения, которые могут быть частью рациона")) {
                        isPlantSection = true; // Переходим к секции растений
                    }
                    continue;
                }

                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    String organism = parts[0].trim();
                    String food = parts[1].trim();

                    if (isPlantSection) {
                        plantChains.computeIfAbsent(organism, k -> new HashSet<>()).add(food);
                    } else {
                        predatorPreyChains.computeIfAbsent(organism, k -> new HashSet<>()).add(food);
                    }
                } else if (parts.length == 4 && isPlantSection) {
                    // Чтение данных о климате: Organism, Temperature, Humidity, WaterAvailability
                    String organism = parts[0].trim();
                    double temperature = Double.parseDouble(parts[1].trim());
                    double humidity = Double.parseDouble(parts[2].trim());
                    double waterAvailability = Double.parseDouble(parts[3].trim());

                    plantClimateData.put(organism, new PlantClimate(temperature, humidity, waterAvailability));
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