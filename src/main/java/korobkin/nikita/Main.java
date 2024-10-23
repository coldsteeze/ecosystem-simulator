package korobkin.nikita;

import korobkin.nikita.Plants.Species;
import korobkin.nikita.Plants.SpeciesPlantLoader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        SpeciesPlantLoader speciesPlantLoader = new SpeciesPlantLoader();
        List<Species> species = speciesPlantLoader.loadSpeciesFromFile("lowerPlants.txt");
        for (Species s : species) {
            s.printTaxonomicHierarchy();
        }
    }
}