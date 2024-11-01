package korobkin.nikita.Animals.enums;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyKingdom;

//Царство животные
public enum KingdomAnimal implements TaxonomyKingdom {
    ANIMALIA("Животные");
    private final String description;

    KingdomAnimal(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
