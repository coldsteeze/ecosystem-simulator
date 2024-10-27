package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfacesPlant.IGenusPlant;

public enum GenusPlantLowerPlant implements IGenusPlant {

    // Род для семейства Вольвоковые
    VOLVOX("Вольвокс",
            "Род колониальных водорослей, включающий виды, образующие сферические колонии.",
            FamilyPlantLowerPlant.VOLVOCACEAE),

    // Род для семейства Улотриксовые
    ULOTHRIX("Улотрикс",
            "Род нитчатых водорослей, обитающих в пресной воде и влажных местообитаниях.",
            FamilyPlantLowerPlant.ULOTRICHACEAE),

    // Род для семейства Ламинариевые
    LAMINARIA("Ламинария",
            "Род крупных бурых водорослей, которые широко известны как морская капуста.",
            FamilyPlantLowerPlant.LAMINARIACEAE),

    // Род для семейства Фукуссовые
    FUCUS("Фукус",
            "Род бурых водорослей, обитающих в морской воде и часто встречающихся на побережьях.",
            FamilyPlantLowerPlant.FUCACEAE),

    // Род для семейства Филлофоровые
    PHYLLOPHORA("Филлофора",
            "Род красных водорослей, которые растут в глубоких морских водах и используются для производства агара.",
            FamilyPlantLowerPlant.PHYLLOPHORACEAE),

    // Род для семейства Кораллтиновые
    CORALLINA("Кораллина",
            "Род кальцинированных красных водорослей, образующих кораллообразные структуры в тропических морях.",
            FamilyPlantLowerPlant.CORALLINACEAE);

    private final String name;
    private final String description;
    private final FamilyPlantLowerPlant family;

    GenusPlantLowerPlant(String name, String description, FamilyPlantLowerPlant family) {
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

    public FamilyPlantLowerPlant getFamily() {
        return family;
    }
}
