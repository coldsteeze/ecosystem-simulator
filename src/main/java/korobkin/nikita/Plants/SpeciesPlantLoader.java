package korobkin.nikita.Plants;

import korobkin.nikita.Plants.enums.HigherPlant.GenusHigherPlant;
import korobkin.nikita.Plants.enums.LowerPlant.GenusLowerPlant;
import korobkin.nikita.Plants.interfaces.Genus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpeciesPlantLoader {

    public List<Species> loadSpeciesFromFile(String fileName) throws IOException {
        List<Species> speciesList = new ArrayList<>();

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
                    Genus genus = findGenusByName(genusName);

                    // Если род найден, создаем объект вида
                    if (genus != null) {
                        Species species = new Species(scientificName, commonName, description, genus);
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
    private Genus findGenusByName(String genusName) {
        try {
            // Пытаемся найти род в высших растениях
            return GenusHigherPlant.valueOf(genusName.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Если не нашли в высших растениях, пытаемся найти в низших
            try {
                return GenusLowerPlant.valueOf(genusName.toUpperCase());
            } catch (IllegalArgumentException ex) {
                // Род не найден ни в одном из перечислений
                return null;
            }
        }
    }
}
