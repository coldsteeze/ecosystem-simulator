package korobkin.nikita;



import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        GenusFinder<Species<?>> genusFinder = new GenusFinderImpl();
        SpeciesLoader<Species<?>> loader = new SpeciesLoader<>(genusFinder);

        try {
            List<Species<?>> speciesList = loader.loadSpeciesFromFile("lowerPlants.txt");
            speciesList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}