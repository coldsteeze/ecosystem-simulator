package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.enums.SubkingdomPlant;
import korobkin.nikita.Plants.interfaces.Division;
import korobkin.nikita.Plants.interfaces.Taxon;

public enum DivisionLowerPlant implements Taxon, Division {
    CHLOROPHYTA("Зеленые водоросли",
            "Фотосинтезирующие организмы, обитающие как в пресных, так и в морских водах.",
            SubkingdomPlant.LOWER_PLANTS),

    PHAEOPHYTA("Бурые водоросли",
            "Многоклеточные водоросли, обитающие в основном в морских условиях," +
                    " содержат пигмент фукоксантин.",
            SubkingdomPlant.LOWER_PLANTS),

    RHODOPHYTA("Красные водоросли",
            "Морские водоросли, содержащие пигменты фикоэритрин и фикоцианин.",
            SubkingdomPlant.LOWER_PLANTS);

    private final String name;
    private final String description;
    private final SubkingdomPlant subkingdom;

    DivisionLowerPlant(String name, String description, SubkingdomPlant subkingdom) {
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
