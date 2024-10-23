package korobkin.nikita.Plants.enums;
public enum KingdomPlant {
    PLANTAE("Растения");

    private final String description;

    KingdomPlant(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
