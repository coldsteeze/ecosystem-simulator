package korobkin.nikita.Animals.enums.MulticellularAnimal;

import korobkin.nikita.Animals.interfaces.Order;
import korobkin.nikita.Taxon;

public enum OrderMulticellularAnimal implements Taxon, Order {
    // Порядки для класса Млекопитающие
    CARNIVORA("Хищные", "Млекопитающие, питающиеся в основном мясом.", ClassMulticellularAnimal.MAMMALIA),
    PRIMATES("Приматы", "Млекопитающие с развитыми когнитивными способностями.", ClassMulticellularAnimal.MAMMALIA),
    RODENTIA("Грызуны", "Млекопитающие с резцами, приспособленными для грызения.", ClassMulticellularAnimal.MAMMALIA),

    // Порядки для класса Птицы
    PASSERIFORMES("Воробьинообразные", "Самый крупный порядок птиц.", ClassMulticellularAnimal.AVES),
    FALCONIFORMES("Соколообразные", "Хищные птицы с острыми когтями и клювом.", ClassMulticellularAnimal.AVES),
    STRIGIFORMES("Совообразные", "Ночные птицы, такие как совы.", ClassMulticellularAnimal.AVES),

    // Порядки для класса Насекомые
    COLEOPTERA("Жесткокрылые", "Насекомые с жесткими передними крыльями.", ClassMulticellularAnimal.INSECTA),
    LEPIDOPTERA("Чешуекрылые", "Насекомые с крыльями, покрытыми чешуйками (бабочки).", ClassMulticellularAnimal.INSECTA),
    HYMENOPTERA("Перепончатокрылые", "Насекомые с двумя парами крыльев (пчелы, осы).", ClassMulticellularAnimal.INSECTA);

    private final String name;
    private final String description;
    private final ClassMulticellularAnimal animalClass;

    OrderMulticellularAnimal(String name, String description, ClassMulticellularAnimal animalClass) {
        this.name = name;
        this.description = description;
        this.animalClass = animalClass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public ClassMulticellularAnimal getAnimalClass() {
        return animalClass;
    }
}
