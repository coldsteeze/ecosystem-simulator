package korobkin.nikita;

import korobkin.nikita.Plants.SpeciePlant;
import korobkin.nikita.Plants.SpeciesPlantLoader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        SpeciesPlantLoader speciesPlantLoader = new SpeciesPlantLoader();
        List<SpeciePlant> species = speciesPlantLoader.loadSpeciesFromFile("lowerPlants.txt");
        for (SpeciePlant s : species) {
            s.printTaxonomicHierarchy();
        }
    }
}