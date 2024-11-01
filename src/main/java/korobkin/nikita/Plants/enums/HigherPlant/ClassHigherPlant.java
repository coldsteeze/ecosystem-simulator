package korobkin.nikita.Plants.enums.HigherPlant;

import korobkin.nikita.Plants.interfacesPlant.IPlantClass;

//Классы для высших растений
public enum ClassHigherPlant implements IPlantClass {
    //Классы папоротниковидных
    POLYPODIOPSIDA("Папоротниковые",
            "Основной класс папоротников.",
            DivisionHigherPlant.POLYPODIOPHYTA),

    //Классы хвощевидных
    EQUISETOPSIDA("Хвощевые",
            "Единственный класс, включающий современные хвощи.",
            DivisionHigherPlant.EQUISETOPHYTA),

    //Классы плаунообразных
    LYCOPODIOPSIDA("Плауновые",
            "Включает современных представителей плаунов.",
            DivisionHigherPlant.LYCOPODIOPHYTA),

    ISOETOPSIDA("Полушниковые",
            "Включает полушники и некоторые водные растения.",
            DivisionHigherPlant.LYCOPODIOPHYTA),

    //Классы голосеменных
    PINOPSIDA("Хвойные",
            "Основной класс голосеменных, включающий все хвойные деревья.",
            DivisionHigherPlant.PINOPHYTA),

    CYCADOPSIDA("Саговниковые",
            "Реликтовые, медленнорастущие растения.",
            DivisionHigherPlant.PINOPHYTA),

    GINKGOPSIDA("Гинкговые",
            "Единственный представитель: гинкго двулопастный.",
            DivisionHigherPlant.PINOPHYTA),

    GNETOPSIDA("Гнетовые",
            "Реликтовые голосеменные растения, близкие к цветковым.",
            DivisionHigherPlant.PINOPHYTA),

    //Классы покрытосеменных
    DICOTYLEDONAE("Двудольные",
            "Растения, у которых семядоли делятся на две части.",
            DivisionHigherPlant.ANGIOSPERMAE),

    MONOCOTYLEDONAE("Однодольные",
            "Растения с одной семядолей.",
            DivisionHigherPlant.ANGIOSPERMAE);


    private final String name;
    private final String description;
    private final DivisionHigherPlant division;

    ClassHigherPlant(String name, String description, DivisionHigherPlant division) {
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

    public DivisionHigherPlant getPhylum() { return division; }
}