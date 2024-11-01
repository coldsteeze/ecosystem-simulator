package korobkin.nikita.Animals.enums.MulticellularAnimal;

import korobkin.nikita.Animals.interfacesAnimal.IAnimalClass;

//Классы для многоклеточных животных
public enum ClassMulticellularIAnimal implements IAnimalClass {
    // Классы для типа Хордовые
    MAMMALIA("Млекопитающие", "Теплокровные животные с волосами и молочными железами.", PhylumMulticellularAnimal.CHORDATA),
    AVES("Птицы", "Животные с перьями и клювом.", PhylumMulticellularAnimal.CHORDATA),
    REPTILIA("Пресмыкающиеся", "Хладнокровные животные, часто покрытые чешуей.", PhylumMulticellularAnimal.CHORDATA),
    AMPHIBIA("Земноводные", "Животные, которые могут жить как в воде, так и на суше.", PhylumMulticellularAnimal.CHORDATA),
    FISH("Рыбы", "Водные позвоночные животные с жабрами.", PhylumMulticellularAnimal.CHORDATA),

    // Классы для типа Членистоногие
    INSECTA("Насекомые", "Членистоногие с тремя парами ног и телом, разделенным на сегменты.", PhylumMulticellularAnimal.ARTHROPODA),
    ARACHNIDA("Паукообразные", "Членистоногие с четырьмя парами ног.", PhylumMulticellularAnimal.ARTHROPODA),
    CRUSTACEA("Ракообразные", "Членистоногие с жестким панцирем, живущие в воде.", PhylumMulticellularAnimal.ARTHROPODA),

    // Классы для типа Моллюски
    GASTROPODA("Брюхоногие", "Моллюски с одной раковиной или без нее.", PhylumMulticellularAnimal.MOLLUSCA),
    BIVALVIA("Двустворчатые", "Моллюски с телом, защищенным двумя раковинами.", PhylumMulticellularAnimal.MOLLUSCA),
    CEPHALOPODA("Головоногие", "Высокоразвитые моллюски с щупальцами.", PhylumMulticellularAnimal.MOLLUSCA);

    private final String name;
    private final String description;
    private final PhylumMulticellularAnimal phylum;

    ClassMulticellularIAnimal(String name, String description, PhylumMulticellularAnimal phylum) {
        this.name = name;
        this.description = description;
        this.phylum = phylum;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public PhylumMulticellularAnimal getPhylum() {
        return phylum;
    }
}

