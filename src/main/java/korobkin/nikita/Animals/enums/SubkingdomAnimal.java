package korobkin.nikita.Animals.enums;

import korobkin.nikita.Animals.interfacesAnimal.ISubkingdomAnimal;

//Подцарство животные
public enum SubkingdomAnimal implements ISubkingdomAnimal {
    SINGLECELLULAR("Одноклеточные", KingdomAnimal.ANIMALIA),
    MULTICELLULAR("Многоклеточные", KingdomAnimal.ANIMALIA),;

    private final String description;
    private final KingdomAnimal kingdomAnimal;

    SubkingdomAnimal(String description, KingdomAnimal kingdomAnimal) {
        this.description = description;
        this.kingdomAnimal = kingdomAnimal;
    }

    public KingdomAnimal getKingdom() {
        return kingdomAnimal;
    }

    public String getDescription() {
        return description;
    }
}
