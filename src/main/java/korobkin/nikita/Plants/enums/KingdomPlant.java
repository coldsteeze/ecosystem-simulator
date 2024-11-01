package korobkin.nikita.Plants.enums;
import korobkin.nikita.TaxonomyInterfaces.TaxonomyKingdom;

//Царство растения
public enum KingdomPlant implements TaxonomyKingdom {
    PLANTAE("Растения");

    private final String description;

    KingdomPlant(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
