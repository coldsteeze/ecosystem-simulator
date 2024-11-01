package korobkin.nikita;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        SpeciesLoader<Species<?>> speciesLoader = new SpeciesLoader<>(new GenusFinderImpl());
        FoodChainLoader foodChainLoader = new FoodChainLoader();
        EcosystemSimulation ecosystemSimulation = new EcosystemSimulation(foodChainLoader);
        List<Species<?>> species = new ArrayList<>();
        EcosystemManager ecosystemManager = new EcosystemManager(speciesLoader, foodChainLoader, ecosystemSimulation, species);


        EcosystemMenu menu = new EcosystemMenu(ecosystemManager);
        menu.displayMenu();
    }
}