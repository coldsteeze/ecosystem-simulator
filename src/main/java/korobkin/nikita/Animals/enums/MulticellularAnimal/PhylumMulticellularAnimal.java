package korobkin.nikita.Animals.enums.MulticellularAnimal;


import korobkin.nikita.Animals.SubkingdomAnimal;
import korobkin.nikita.Animals.interfaces.Phylum;
import korobkin.nikita.Taxon;

public enum PhylumMulticellularAnimal implements Taxon, Phylum {
    CHORDATA("Хордовые", "Животные, имеющие хорду на каком-то этапе развития.", SubkingdomAnimal.MULTICELLULAR),
    ARTHROPODA("Членистоногие", "Животные с внешним скелетом и сегментированным телом.", SubkingdomAnimal.MULTICELLULAR),
    MOLLUSCA("Моллюски", "Животные с мягким телом, часто имеющие раковину.", SubkingdomAnimal.MULTICELLULAR),
    CNIDARIA("Кишечнополостные", "Животные с радиальной симметрией и специализированными клетками.", SubkingdomAnimal.MULTICELLULAR),
    ECHINODERMATA("Иглокожие", "Морские животные с пятиугольной радиальной симметрией.", SubkingdomAnimal.MULTICELLULAR);

    private final String name;
    private final String description;
    private final SubkingdomAnimal subkingdom;

    PhylumMulticellularAnimal(String name, String description, SubkingdomAnimal subkingdom) {
        this.name = name;
        this.description = description;
        this.subkingdom = subkingdom;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public SubkingdomAnimal getSubkingdom() {
        return subkingdom;
    }
}
