package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfaces.PlantClass;
import korobkin.nikita.Plants.interfaces.Taxon;

public enum ClassLowerPlant implements Taxon, PlantClass {
    //Классы зеленых водорослей
    CHLOROPHYCEAE("Хлорофициевые",
            "Одноклеточные и многоклеточные водоросли.",
            DivisionLowerPlant.CHLOROPHYTA),


    ULVOPHYCEAE("Ульвофициевые",
            "В основном морские многоклеточные водоросли.",
            DivisionLowerPlant.CHLOROPHYTA),

    ZYGNEMATOPHYCEAE("Конъюгатофициевые",
            "Пресноводные, преимущественно многоклеточные водоросли.",
            DivisionLowerPlant.CHLOROPHYTA),

    //Классы бурых водорослей
    PHAEOPHYCEAE("Бурые водоросли",
            "Все бурые водоросли.",
            DivisionLowerPlant.PHAEOPHYTA),

    //Классы красных водорослей
    FLORIDEOPHYCEAE("Красные водоросли",
            "Многоклеточные формы, обитающие в основном в морской воде.",
            DivisionLowerPlant.RHODOPHYTA);


    private final String name;
    private final String description;
    private final DivisionLowerPlant division;

    ClassLowerPlant(String name, String description, DivisionLowerPlant division) {
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

    public DivisionLowerPlant getDivision() {
        return division;
    }
}
