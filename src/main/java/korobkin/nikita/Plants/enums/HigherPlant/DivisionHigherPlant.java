package korobkin.nikita.Plants.enums.HigherPlant;

import korobkin.nikita.Plants.enums.SubkingdomPlant;
import korobkin.nikita.Plants.interfacesPlant.IDivisionPlant;

//Отделы высших растений
public enum DivisionHigherPlant implements IDivisionPlant {
    POLYPODIOPHYTA("Папоротниковидные",
            "Споровые растения с хорошо развитыми корнями, стеблями и листьями.",
            SubkingdomPlant.HIGHER_PLANTS),

    EQUISETOPHYTA("Хвощевидные",
            "Древние споровые растения, с членистыми стеблями.",
            SubkingdomPlant.HIGHER_PLANTS),

    LYCOPODIOPHYTA("Плаунообразные",
            "Мелкие споровые растения с ползучими стеблями.",
            SubkingdomPlant.HIGHER_PLANTS),

    PINOPHYTA("Голосеменные",
            "Семенные растения, у которых семена развиваются на открытых чешуях шишек.",
            SubkingdomPlant.HIGHER_PLANTS),

    ANGIOSPERMAE("Покрытосеменные",
            "Самая разнообразная и многочисленная группа. Семена защищены внутри плода.",
            SubkingdomPlant.HIGHER_PLANTS);



    private final String name;
    private final String description;
    private final SubkingdomPlant subkingdom;

    DivisionHigherPlant(String name, String description, SubkingdomPlant subkingdom) {
        this.name = name;
        this.description = description;
        this.subkingdom = subkingdom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public SubkingdomPlant getSubkingdom() {
        return subkingdom;
    }
}