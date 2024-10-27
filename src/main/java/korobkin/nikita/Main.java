package korobkin.nikita;



import java.io.IOException;
import java.util.List;
import java.util.Set;

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

        FoodChainLoader loader1 = new FoodChainLoader();
        loader1.loadFoodChains("food_chains.txt");

        // Пример использования
        Set<String> preyOfPanthera = loader1.getPrey("Пантера");
        System.out.println("Добыча для Пантеры: " + preyOfPanthera);

        Set<String> plantsOfHomo = loader1.getPlants("Хомо");
        System.out.println("Растения в рационе Хомо: " + plantsOfHomo);

        PlantClimate wheatClimate = loader1.getPlantClimate("Пшеница");
        System.out.println("Климатические показатели для Пшеницы: " + wheatClimate);
    }
}