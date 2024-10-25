package korobkin.nikita.Animals;

public enum SubkingdomAnimal {
    SINGLECELLULAR("Одноклеточные", KingdomAnimal.ANIMALIA),
    MULTICELLULAR("Многоклеточные", KingdomAnimal.ANIMALIA),;

    private final String description;
    private final KingdomAnimal kingdomAnimal;

    SubkingdomAnimal(String description, KingdomAnimal kingdomAnimal) {
        this.description = description;
        this.kingdomAnimal = kingdomAnimal;
    }

    public KingdomAnimal getKingdomAnimal() {
        return kingdomAnimal;
    }

    public String getDescription() {
        return description;
    }
}
