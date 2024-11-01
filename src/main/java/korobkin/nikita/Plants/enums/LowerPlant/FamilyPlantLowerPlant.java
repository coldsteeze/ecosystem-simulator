package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfacesPlant.IFamilyPlant;

//Семейства для низших растений
public enum FamilyPlantLowerPlant implements IFamilyPlant {
    //Семейства зеленых водорослей
    VOLVOCACEAE("Вольвоковые",
            "Включает вольвокс и его родственников, которые образуют колонии."
            , OrderPlantLowerPlant.VOLVOCALES),

    ULOTRICHACEAE("Улотриксовые",
                        "Водоросли, такие как улотрикс, обитают в пресной воде и влажных местообитаниях."
                        , OrderPlantLowerPlant.ULVALES),

    //Семейства бурых водорослей
    LAMINARIACEAE("Ламинариевые",
            "Ламинария или морская капуста, крупные бурые водоросли, обитающие в холодных морях."
            , OrderPlantLowerPlant.LAMINARIALES),

    FUCACEAE("Фукуссовые",
            "Фукус, характерный для побережий морей с соленой водой."
            , OrderPlantLowerPlant.FUCALES),

    //Семейства красных водорослей
    PHYLLOPHORACEAE("Филлофоровые",
            "Включает водоросли, такие как филлофора," +
                    " обитающие в глубоких водах и используемые для производства агара."
            , OrderPlantLowerPlant.GIGARTINALES),

    CORALLINACEAE("Кораллтиновые",
            "Это кальцинированные красные водоросли," +
                    " которые образуют кораллообразные структуры в тропических морях."
            , OrderPlantLowerPlant.CORALLINALES);

    private final String name;
    private final String description;
    private final OrderPlantLowerPlant order;

    FamilyPlantLowerPlant(String name, String description, OrderPlantLowerPlant order) {
        this.name = name;
        this.description = description;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OrderPlantLowerPlant getOrder() {
        return order;
    }
}
