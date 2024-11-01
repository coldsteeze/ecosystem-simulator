package korobkin.nikita;

import korobkin.nikita.Animals.enums.MulticellularAnimal.GenusAnimalMulticellularAnimal;
import korobkin.nikita.Animals.interfacesAnimal.IGenusAnimal;
import korobkin.nikita.Plants.enums.HigherPlant.GenusPlantHigherPlant;
import korobkin.nikita.Plants.enums.LowerPlant.GenusPlantLowerPlant;
import korobkin.nikita.Plants.interfacesPlant.IGenusPlant;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EcosystemMenu {
    private final EcosystemManager ecosystemManager;

    public EcosystemMenu(EcosystemManager ecosystemManager) {
        this.ecosystemManager = ecosystemManager;
    }

    // Меню
    public void displayMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Загрузка данных экосистемы...");
        ecosystemManager.loadAllSpeciesFromFile();

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
                    selectRemoveSpeciesOption(scanner);
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

    // Метод для функционирования добавления по критериям(Кастомное, из списка доступных)
    private void selectAddSpeciesOption(Scanner scanner) throws IOException {
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

    // Метод для функционирования добавления из списка доступных видов
    private void addSpeciesFromList(Scanner scanner) throws IOException {
        List<Species<?>> availableSpecies = ecosystemManager.getAvailableSpecies();
        System.out.println("Выберите вид для добавления в экосистему:");
        for (int i = 0; i < availableSpecies.size(); i++) {
            System.out.println((i + 1) + ". " + availableSpecies.get(i).toString());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= availableSpecies.size()) {
            Species<?> selectedSpecie = availableSpecies.get(choice - 1);
            ecosystemManager.addSpeciesToEcosystem(selectedSpecie);
        } else {
            System.out.println("Неверный выбор, попробуйте снова.");
        }
    }

    // Метод для функционирования добавления кастомных видов
    private void addCustomSpecies(Scanner scanner) throws IOException {
        System.out.print("Введите научное название вида: ");
        String scientificName = scanner.nextLine();

        System.out.print("Введите общее название вида: ");
        String commonName = scanner.nextLine();

        System.out.print("Введите описание вида: ");
        String description = scanner.nextLine();

        System.out.println("Выберите тип: ");
        System.out.println("1. Высшее растение");
        System.out.println("2. Низшее растение");
        System.out.println("3. Многоклеточное животное");

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        IGenusPlant selectedPlantGenus = null;
        IGenusAnimal selectedAnimalGenus = null;

        switch (typeChoice) {
            case 1:
                // Выбор рода высшего растения
                System.out.println("Выберите род высшего растения:");
                for (int i = 0; i < GenusPlantHigherPlant.values().length; i++) {
                    System.out.println((i + 1) + ". " + GenusPlantHigherPlant.values()[i].getName() + " - " + GenusPlantHigherPlant.values()[i].getDescription());
                }
                break;
            case 2:
                // Выбор рода низшего растения
                System.out.println("Выберите род низшего растения:");
                for (int i = 0; i < GenusPlantLowerPlant.values().length; i++) {
                    System.out.println((i + 1) + ". " + GenusPlantLowerPlant.values()[i].getName() + " - " + GenusPlantLowerPlant.values()[i].getDescription());
                }
                break;
            case 3:
                // Выбор рода многоклеточного животного
                System.out.println("Выберите род многоклеточного животного:");
                for (int i = 0; i < GenusAnimalMulticellularAnimal.values().length; i++) {
                    System.out.println((i + 1) + ". " + GenusAnimalMulticellularAnimal.values()[i].getName() + " - " + GenusAnimalMulticellularAnimal.values()[i].getDescription());
                }
                break;
            default:
                System.out.println("Неверный выбор, возвращение в меню.");
                return;
        }

        System.out.print("Введите номер выбранного рода: ");
        int genusChoice = scanner.nextInt();
        scanner.nextLine();

        // Определение выбранного рода
        switch (typeChoice) {
            case 1:
                if (genusChoice > 0 && genusChoice <= GenusPlantHigherPlant.values().length) {
                    selectedPlantGenus = GenusPlantHigherPlant.values()[genusChoice - 1];
                }
                break;
            case 2:
                if (genusChoice > 0 && genusChoice <= GenusPlantLowerPlant.values().length) {
                    selectedPlantGenus = GenusPlantLowerPlant.values()[genusChoice - 1];
                }
                break;
            case 3:
                if (genusChoice > 0 && genusChoice <= GenusAnimalMulticellularAnimal.values().length) {
                    selectedAnimalGenus = GenusAnimalMulticellularAnimal.values()[genusChoice - 1];
                }
                break;
            default:
                System.out.println("Неверный выбор, возвращение в меню.");
                return;
        }

        // Создаем новый вид
        Species<?> newSpecies;
        if (selectedPlantGenus != null) {
            newSpecies = new Species<>(scientificName, commonName, description, selectedPlantGenus);
        } else {
            newSpecies = new Species<>(scientificName, commonName, description, selectedAnimalGenus);
        }
        ecosystemManager.addSpeciesToEcosystem(newSpecies);
    }

    // Метод для функционирования удаления (По научному или общему названию, из списка нашей экосистемы)
    private void selectRemoveSpeciesOption(Scanner scanner) throws IOException {
        System.out.println("Выберите способ удаления вида:");
        System.out.println("1. По научному названию");
        System.out.println("2. По общему названию");
        System.out.println("3. Выбрать из списка");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                removeSpeciesByScientificName(scanner);
                break;
            case 2:
                removeSpeciesByCommonName(scanner);
                break;
            case 3:
                removeSpeciesFromList(scanner);
                break;
            default:
                System.out.println("Неверный выбор, возвращение в меню.");
        }
    }

    // Метод для функционирования удаления по научному названию
    private void removeSpeciesByScientificName(Scanner scanner) throws IOException {
        System.out.print("Введите научное название вида для удаления: ");
        String scientificName = scanner.nextLine();
        ecosystemManager.removeSpeciesFromEcosystemByScientificName(scientificName);
    }

    // Метод для функционирования удаления по общему названию
    private void removeSpeciesByCommonName(Scanner scanner) throws IOException {
        System.out.print("Введите общее название вида для удаления: ");
        String commonName = scanner.nextLine();
        ecosystemManager.removeSpeciesFromEcosystemByCommonName(commonName);
        System.out.println("Вид удален из экосистемы.");
    }

    // Метод для функционирования удаления из списка нашей экосистемы
    private void removeSpeciesFromList(Scanner scanner) throws IOException {
        System.out.println("Выберите категорию для отображения и удаления видов:");
        System.out.println("1. Все виды");
        System.out.println("2. Все животные");
        System.out.println("3. Все растения");
        System.out.println("4. Многоклеточные животные");
        System.out.println("5. Высшие растения");
        System.out.println("6. Низшие растения");

        int categoryChoice = scanner.nextInt();
        scanner.nextLine();

        Collection<Species<?>> selectedSpeciesList;

        switch (categoryChoice) {
            case 1:
                selectedSpeciesList = ecosystemManager.getEcosystemSpecies();
                break;
            case 2:
                selectedSpeciesList = ecosystemManager.getAllAnimals();
                break;
            case 3:
                selectedSpeciesList = ecosystemManager.getAllPlants();
                break;
            case 4:
                selectedSpeciesList = ecosystemManager.getMulticellularAnimals();
                break;
            case 5:
                selectedSpeciesList = ecosystemManager.getHigherPlants();
                break;
            case 6:
                selectedSpeciesList = ecosystemManager.getLowerPlants();
                break;
            default:
                System.out.println("Неверный выбор, возвращение в меню.");
                return;
        }

        if (selectedSpeciesList.isEmpty()) {
            System.out.println("В данной категории нет добавленных видов.");
            return;
        }

        // Показ списка видов для выбранной категории
        System.out.println("Выберите вид для удаления:");
        int index = 1;
        for (Species<?> species : selectedSpeciesList) {
            System.out.println((index++) + ". " + species.getScientificName() + " (" + species.getCommonName() + ")");
        }

        System.out.print("Введите номер выбранного вида: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= selectedSpeciesList.size()) {
            Species<?> selectedSpecies = selectedSpeciesList.toArray(new Species[0])[choice - 1];
            ecosystemManager.removeSpeciesFromEcosystemByScientificName(selectedSpecies.getScientificName());
            System.out.println("Вид удален из экосистемы.");
        } else {
            System.out.println("Неверный выбор, возвращение в меню.");
        }
    }

    // Метод для установки климатических данных в нашей экосистеме
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

    // Загрузка пищевых цепей и климатических данных
    private void loadFoodChainsAndClimateData(Scanner scanner) {
        String filename = "food_chains.txt";
        ecosystemManager.loadFoodChainsAndClimateData(filename);
        System.out.println("Пищевые цепи и климатические данные загружены.");
    }

    // Фильтрация по всем видам(Растения(высшие и низшие), Животные(многоклеточные, одноклеточные)
    // В данном случае одноклеточных нет
    private void displayEcosystemSpecies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите категорию для отображения видов:");
        System.out.println("1. Все виды");
        System.out.println("2. Все животные");
        System.out.println("3. Многоклеточные животные");
        System.out.println("4. Все растения");
        System.out.println("5. Высшие растения");
        System.out.println("6. Низшие растения");

        int categoryChoice = scanner.nextInt();
        scanner.nextLine();

        Collection<Species<?>> selectedSpeciesList;


        switch (categoryChoice) {
            case 1:
                selectedSpeciesList = ecosystemManager.getEcosystemSpecies();
                break;
            case 2:
                selectedSpeciesList = ecosystemManager.getAllAnimals();
                break;
            case 3:
                selectedSpeciesList = ecosystemManager.getMulticellularAnimals();
                break;
            case 4:
                selectedSpeciesList = ecosystemManager.getAllPlants();
                break;
            case 5:
                selectedSpeciesList = ecosystemManager.getHigherPlants();
                break;
            case 6:
                selectedSpeciesList = ecosystemManager.getLowerPlants();
                break;
            default:
                System.out.println("Неверный выбор, возвращение в меню.");
                return;
        }

        if (selectedSpeciesList.isEmpty()) {
            System.out.println("В данной категории нет добавленных видов.");
        } else {
            System.out.println("Список видов в выбранной категории:");
            int index = 1;
            for (Species<?> species : selectedSpeciesList) {
                System.out.println(index + ". " + species);
                index++;
            }

            System.out.println("\nВведите номер вида, чтобы увидеть подробную информацию, или 0 для возврата:");
            int speciesChoice = scanner.nextInt();
            scanner.nextLine();

            if (speciesChoice > 0 && speciesChoice <= selectedSpeciesList.size()) {
                Species<?> selectedSpecies = (Species<?>) selectedSpeciesList.toArray()[speciesChoice - 1];
                System.out.println("Подробная информация о виде:");
                selectedSpecies.printTaxonomicHierarchy();
            } else if (speciesChoice == 0) {
                System.out.println("Возвращение в меню.");
            } else {
                System.out.println("Неверный выбор.");
            }
        }
    }

}
