package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfacesPlant.IPlantClass;

//Классы низших растений
public enum ClassLowerPlant implements IPlantClass {
    //Классы зеленых водорослей
    CHLOROPHYCEAE("Хлорофициевые",
            "Одноклеточные и многоклеточные водоросли.",
            DivisionPlantLowerPlant.CHLOROPHYTA),


    ULVOPHYCEAE("Ульвофициевые",
            "В основном морские многоклеточные водоросли.",
            DivisionPlantLowerPlant.CHLOROPHYTA),

    ZYGNEMATOPHYCEAE("Конъюгатофициевые",
            "Пресноводные, преимущественно многоклеточные водоросли.",
            DivisionPlantLowerPlant.CHLOROPHYTA),

    //Классы бурых водорослей
    PHAEOPHYCEAE("Бурые водоросли",
            "Все бурые водоросли.",
            DivisionPlantLowerPlant.PHAEOPHYTA),

    //Классы красных водорослей
    FLORIDEOPHYCEAE("Красные водоросли",
            "Многоклеточные формы, обитающие в основном в морской воде.",
            DivisionPlantLowerPlant.RHODOPHYTA);


    private final String name;
    private final String description;
    private final DivisionPlantLowerPlant division;

    ClassLowerPlant(String name, String description, DivisionPlantLowerPlant division) {
        this.name = name;
        this.description = description;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DivisionPlantLowerPlant getPhylum() {
        return division;
    }
}
