package korobkin.nikita.Plants.enums;


import korobkin.nikita.Plants.interfacesPlant.ISubkingdomPlant;

public enum SubkingdomPlant implements ISubkingdomPlant {
    HIGHER_PLANTS("Высшие растения", KingdomPlant.PLANTAE),
    LOWER_PLANTS("Низшие растения", KingdomPlant.PLANTAE);

    private final String description;
    private final KingdomPlant kingdomPlant;

    SubkingdomPlant(String description, KingdomPlant kingdomPlant) {
        this.description = description;
        this.kingdomPlant = kingdomPlant;
    }

    public String getDescription() {
            return description;
    }

    public KingdomPlant getKingdom() {
        return kingdomPlant;
    }
}