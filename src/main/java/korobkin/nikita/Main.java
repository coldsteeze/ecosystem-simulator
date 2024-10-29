package korobkin.nikita;



import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        SpeciesLoader<Species<?>> speciesLoader = new SpeciesLoader<>(new GenusFinderImpl());
        FoodChainLoader foodChainLoader = new FoodChainLoader();
        EcosystemSimulation ecosystemSimulation = new EcosystemSimulation();
        EcosystemManager ecosystemManager = new EcosystemManager(speciesLoader, foodChainLoader, ecosystemSimulation);

        EcosystemMenu menu = new EcosystemMenu(ecosystemManager);
        menu.displayMenu();
    }
}