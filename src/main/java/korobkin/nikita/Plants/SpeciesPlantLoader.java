package korobkin.nikita.Plants;

import korobkin.nikita.Plants.enums.HigherPlant.GenusPlantHigherPlant;
import korobkin.nikita.Plants.enums.LowerPlant.GenusPlantLowerPlant;
import korobkin.nikita.Plants.interfacesPlant.IGenusPlant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpeciesPlantLoader {

    public List<SpeciePlant> loadSpeciesFromFile(String fileName) throws IOException {
        List<SpeciePlant> speciesList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Файл не найден: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String scientificName = parts[0].trim();
                    String commonName = parts[1].trim();
                    String description = parts[2].trim();
                    String genusName = parts[3].trim();

                    // Используем общий метод для поиска рода
                    IGenusPlant IGenusPlant = findGenusByName(genusName);

                    // Если род найден, создаем объект вида
                    if (IGenusPlant != null) {
                        SpeciePlant species = new SpeciePlant(scientificName, commonName, description, IGenusPlant);
                        speciesList.add(species);
                    } else {
                        System.out.println("Род не найден: " + genusName);
                    }
                } else {
                    System.out.println("Неверный формат строки: " + line);
                }
            }
        }
        return speciesList;
    }

    // Метод для поиска рода по имени
    private IGenusPlant findGenusByName(String genusName) {
        try {
            // Пытаемся найти род в высших растениях
            return GenusPlantHigherPlant.valueOf(genusName.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Если не нашли в высших растениях, пытаемся найти в низших
            try {
                return GenusPlantLowerPlant.valueOf(genusName.toUpperCase());
            } catch (IllegalArgumentException ex) {
                // Род не найден ни в одном из перечислений
                return null;
            }
        }
    }
}
