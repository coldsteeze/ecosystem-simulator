package korobkin.nikita.Animals;

public enum KingdomAnimal {
    ANIMALIA("Животные");
    private final String description;

    KingdomAnimal(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
