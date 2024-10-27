package korobkin.nikita.Animals.enums.MulticellularAnimal;

import korobkin.nikita.Animals.interfacesAnimal.IGenusAnimal;

public enum GenusAnimalMulticellularAnimal implements IGenusAnimal {
    // Роды для семейства Кошачьи (Felidae)
    PANTHERA("Пантера", "Род крупных кошек, включая льва, тигра и леопарда.", FamilyMulticellularAnimal.FELIDAE),
    FELIS("Фелис", "Род мелких кошек, включая домашнюю кошку.", FamilyMulticellularAnimal.FELIDAE),

    // Роды для семейства Псовые (Canidae)
    CANIS("Канис", "Род, включающий волков, койотов и собак.", FamilyMulticellularAnimal.CANIDAE),
    VULPES("Вульпес", "Род лисиц, включая рыжую лисицу.", FamilyMulticellularAnimal.CANIDAE),

    // Роды для семейства Гоминиды (Hominidae)
    HOMO("Хомо", "Род, включающий современных людей.", FamilyMulticellularAnimal.HOMINIDAE),
    PAN("Пан", "Род, включающий шимпанзе и бонобо.", FamilyMulticellularAnimal.HOMINIDAE),

    // Роды для семейства Врановые (Corvidae)
    CORVUS("Ворон", "Род крупных птиц, включая ворон и ворону.", FamilyMulticellularAnimal.CORVIDAE),
    PICA("Сорока", "Род сорок и близких видов.", FamilyMulticellularAnimal.CORVIDAE),

    // Роды для семейства Парусники (Papilionidae)
    PAPILIO("Папилио", "Род крупных ярких бабочек.", FamilyMulticellularAnimal.PAPILIONIDAE),
    BATTUS("Баттус", "Род бабочек, встречающихся в Америке.", FamilyMulticellularAnimal.PAPILIONIDAE);

    private final String name;
    private final String description;
    private final FamilyMulticellularAnimal family;

    GenusAnimalMulticellularAnimal(String name, String description, FamilyMulticellularAnimal family) {
        this.name = name;
        this.description = description;
        this.family = family;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public FamilyMulticellularAnimal getFamily() {
        return family;
    }
}
