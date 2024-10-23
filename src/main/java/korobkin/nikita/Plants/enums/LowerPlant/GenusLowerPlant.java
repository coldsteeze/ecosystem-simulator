package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfaces.Taxon;
import korobkin.nikita.Plants.interfaces.Genus;

public enum GenusLowerPlant implements Taxon, Genus{

    // Род для семейства Вольвоковые
    VOLVOX("Вольвокс",
            "Род колониальных водорослей, включающий виды, образующие сферические колонии.",
            FamilyLowerPlant.VOLVOCACEAE),

    // Род для семейства Улотриксовые
    ULOTHRIX("Улотрикс",
            "Род нитчатых водорослей, обитающих в пресной воде и влажных местообитаниях.",
            FamilyLowerPlant.ULOTRICHACEAE),

    // Род для семейства Ламинариевые
    LAMINARIA("Ламинария",
            "Род крупных бурых водорослей, которые широко известны как морская капуста.",
            FamilyLowerPlant.LAMINARIACEAE),

    // Род для семейства Фукуссовые
    FUCUS("Фукус",
            "Род бурых водорослей, обитающих в морской воде и часто встречающихся на побережьях.",
            FamilyLowerPlant.FUCACEAE),

    // Род для семейства Филлофоровые
    PHYLLOPHORA("Филлофора",
            "Род красных водорослей, которые растут в глубоких морских водах и используются для производства агара.",
            FamilyLowerPlant.PHYLLOPHORACEAE),

    // Род для семейства Кораллтиновые
    CORALLINA("Кораллина",
            "Род кальцинированных красных водорослей, образующих кораллообразные структуры в тропических морях.",
            FamilyLowerPlant.CORALLINACEAE);

    private final String name;
    private final String description;
    private final FamilyLowerPlant family;

    GenusLowerPlant(String name, String description, FamilyLowerPlant family) {
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

    public FamilyLowerPlant getFamily() {
        return family;
    }
}
