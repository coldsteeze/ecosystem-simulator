package korobkin.nikita;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EcosystemMenu {
    private final EcosystemManager ecosystemManager;

    public EcosystemMenu(EcosystemManager ecosystemManager) {
        this.ecosystemManager = ecosystemManager;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить вид");
            System.out.println("2. Удалить вид");
            System.out.println("3. Показать виды из этой экосистемы");
            System.out.println("4. Изменить условия экосистемы");
            System.out.println("5. Загрузить пищевые цепи и климатические данные");
            System.out.println("6. Запустить симуляцию и прогноз");
            System.out.println("7. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    selectAddSpeciesOption(scanner);
                    break;
                case 2:
                    removeSpecies(scanner);
                    break;
                case 3:
                    displayEcosystemSpecies();
                    break;
                case 4:
                    modifyEcosystemConditions(scanner);
                    break;
                case 5:
                    loadFoodChainsAndClimateData(scanner);
                    break;
                case 6:
                    ecosystemManager.runSimulationAndPrediction();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void selectAddSpeciesOption(Scanner scanner) {
        System.out.println("Выберите способ добавления вида:");
        System.out.println("1. Добавить вид из списка");
        System.out.println("2. Добавить пользовательский вид");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addSpeciesFromList(scanner);
                break;
            case 2:
                addCustomSpecies(scanner);
                break;
            default:
                System.out.println("Неверный выбор, попробуйте снова.");
        }
    }

    private void addSpeciesFromList(Scanner scanner) {
        List<Species<?>> availableSpecies = ecosystemManager.getAvailableSpecies();
        System.out.println("Выберите вид для добавления в экосистему:");
        for (int i = 0; i < availableSpecies.size(); i++) {
            System.out.println((i + 1) + ". " + availableSpecies.get(i).toString());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= availableSpecies.size()) {
            Species<?> selectedSpecies = availableSpecies.get(choice - 1);
            ecosystemManager.addSpeciesToEcosystem(selectedSpecies);
        } else {
            System.out.println("Неверный выбор, попробуйте снова.");
        }
    }

    private void addCustomSpecies(Scanner scanner) {

    }

    private void removeSpecies(Scanner scanner) {
        System.out.print("Введите научное название вида для удаления: ");
        String scientificName = scanner.nextLine();
        ecosystemManager.removeSpeciesFromEcosystem(scientificName);
        System.out.println("Вид удален из экосистемы.");
    }

    private void modifyEcosystemConditions(Scanner scanner) {
        System.out.print("Введите новую температуру: ");
        double temperature = scanner.nextDouble();
        System.out.print("Введите новую влажность: ");
        double humidity = scanner.nextDouble();
        System.out.print("Введите новую доступность воды: ");
        double waterAvailability = scanner.nextDouble();
        scanner.nextLine();

        ecosystemManager.setEcosystemConditions(temperature, humidity, waterAvailability);
        System.out.println("Условия экосистемы обновлены.");
    }

    private void loadFoodChainsAndClimateData(Scanner scanner) {
        System.out.print("Введите имя файла для загрузки пищевых цепей и климатических данных: ");
        String filename = scanner.nextLine();
        ecosystemManager.loadFoodChainsAndClimateData(filename);
        System.out.println("Пищевые цепи и климатические данные загружены.");
    }

    private void displayEcosystemSpecies() {
        Collection<Species<?>> speciesInEcosystem = ecosystemManager.getEcosystemSpecies();
        if (speciesInEcosystem.isEmpty()) {
            System.out.println("В экосистеме нет добавленных видов.");
        } else {
            System.out.println("Список видов в экосистеме:");
            for (Species<?> species : speciesInEcosystem) {
                System.out.println(species);
            }
        }
    }
}
