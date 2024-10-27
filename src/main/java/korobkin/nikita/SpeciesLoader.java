package korobkin.nikita;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpeciesLoader<T extends Species<?>> {
    private final GenusFinder<T> genusFinder;

    public SpeciesLoader(GenusFinder<T> genusFinder) {
        this.genusFinder = genusFinder;
    }

    public List<T> loadSpeciesFromFile(String fileName) throws IOException {
        List<T> speciesList = new ArrayList<>();
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

                    TaxonomyGenus<?> genus = genusFinder.findGenusByName(genusName);

                    if (genus != null) {
                        // Assuming genus has a method createSpecies
                        T species = (T) new Species<>(scientificName, commonName, description, genus);
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
}
