package korobkin.nikita.Animals.enums.MulticellularAnimal;

import korobkin.nikita.Animals.interfacesAnimal.IOrderAnimal;

public enum OrderMulticellularAnimal implements IOrderAnimal {
    // Порядки для класса Млекопитающие
    CARNIVORA("Хищные", "Млекопитающие, питающиеся в основном мясом.", ClassMulticellularIAnimal.MAMMALIA),
    PRIMATES("Приматы", "Млекопитающие с развитыми когнитивными способностями.", ClassMulticellularIAnimal.MAMMALIA),
    RODENTIA("Грызуны", "Млекопитающие с резцами, приспособленными для грызения.", ClassMulticellularIAnimal.MAMMALIA),

    // Порядки для класса Птицы
    PASSERIFORMES("Воробьинообразные", "Самый крупный порядок птиц.", ClassMulticellularIAnimal.AVES),
    FALCONIFORMES("Соколообразные", "Хищные птицы с острыми когтями и клювом.", ClassMulticellularIAnimal.AVES),
    STRIGIFORMES("Совообразные", "Ночные птицы, такие как совы.", ClassMulticellularIAnimal.AVES),

    // Порядки для класса Насекомые
    COLEOPTERA("Жесткокрылые", "Насекомые с жесткими передними крыльями.", ClassMulticellularIAnimal.INSECTA),
    LEPIDOPTERA("Чешуекрылые", "Насекомые с крыльями, покрытыми чешуйками (бабочки).", ClassMulticellularIAnimal.INSECTA),
    HYMENOPTERA("Перепончатокрылые", "Насекомые с двумя парами крыльев (пчелы, осы).", ClassMulticellularIAnimal.INSECTA);

    private final String name;
    private final String description;
    private final ClassMulticellularIAnimal animalClass;

    OrderMulticellularAnimal(String name, String description, ClassMulticellularIAnimal animalClass) {
        this.name = name;
        this.description = description;
        this.animalClass = animalClass;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public ClassMulticellularIAnimal getInfoAboutClass() {
        return animalClass;
    }
}
