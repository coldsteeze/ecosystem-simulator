package korobkin.nikita.Animals.enums;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyKingdom;

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
