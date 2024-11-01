package korobkin.nikita;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.Map;

// Класс, предназначенный для работы с файлами: чтения записи
public class SpeciesLoader<T extends Species<?>> {
    private final GenusFinder<T> genusFinder;

    public SpeciesLoader(GenusFinder<T> genusFinder) {
        this.genusFinder = genusFinder;
    }

    // Метод для загрузки доступных видов из файла
    public List<T> loadAvailableSpeciesFromFile(String fileName) throws IOException {
        return loadSpeciesFromResource(fileName);
    }

    // Метод для загрузки видов экосистемы из файла
    public List<T> loadEcosystemSpeciesFromFile(String fileName) throws IOException {
        return loadSpeciesFromResource(fileName);
    }

    // Метод для загрузки видов из ресурсов
    public List<T> loadSpeciesFromResource(String fileName) throws IOException {
        List<T> speciesList = new ArrayList<>();

        // Получаем InputStream из ресурсов
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        // Проверяем, найден ли файл
        if (inputStream == null) {
            throw new IOException("Файл не найден в ресурсах: " + fileName);
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
                        T species = (T) new Species<>(scientificName, commonName, description, genus);
                        speciesList.add(species);
                    } else {
                        System.out.println("Род не найден: " + genusName);
                    }
                }
            }
        }

        return speciesList;
    }

    // Метод сохранения, то есть записи в файл, вида
    public void saveSpeciesToFile(T species, String fileName) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(species.getScientificName() + "," +
                        species.getCommonName() + "," +
                        species.getDescription() + "," +
                        species.getGenus().getEnumName());
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении вида: " + e.getMessage());
            }
    }


    // Метод для случая, если удаляется вид, чтобы он стирался в файле(По научному названию)
    public void rewriteFileExcludingSpeciesByScientificName(String fileName, String scientificName, Map<String, Species<?>> ecosystemSpecies) throws IOException {
        List<Species<?>> speciesList = new ArrayList<>(ecosystemSpecies.values());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Species<?> species : speciesList) {
                // Пропускаем вид, если его научное название совпадает
                if (!species.getScientificName().equalsIgnoreCase(scientificName)) {
                    writer.write(species.getScientificName() + "," +
                            species.getCommonName() + "," +
                            species.getDescription() + "," +
                            species.getGenus().getEnumName());
                    writer.newLine();
                }
            }
        }
    }

    // Метод для случая, если удаляется вид, чтобы он стирался в файле(По общему названию)
    public void rewriteFileExcludingSpeciesByCommonName(String fileName, String commonName, Map<String, Species<?>> ecosystemSpecies) throws IOException {
        List<Species<?>> speciesList = new ArrayList<>(ecosystemSpecies.values());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Species<?> species : speciesList) {
                // Пропускаем вид, если его общее название совпадает
                if (!species.getCommonName().equalsIgnoreCase(commonName)) {
                    writer.write(species.getScientificName() + "," +
                            species.getCommonName() + "," +
                            species.getDescription() + "," +
                            species.getGenus().getEnumName());
                    writer.newLine();
                }
            }
        }
    }
}

