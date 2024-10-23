package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfaces.Family;
import korobkin.nikita.Plants.interfaces.Taxon;

public enum FamilyLowerPlant implements Taxon, Family {
    //Семейства зеленых водорослей
    VOLVOCACEAE("Вольвоковые",
            "Включает вольвокс и его родственников, которые образуют колонии."
            , OrderLowerPlant.VOLVOCALES),

    ULOTRICHACEAE("Улотриксовые",
                        "Водоросли, такие как улотрикс, обитают в пресной воде и влажных местообитаниях."
                        , OrderLowerPlant.ULVALES),

    //Семейства бурых водорослей
    LAMINARIACEAE("Ламинариевые",
            "Ламинария или морская капуста, крупные бурые водоросли, обитающие в холодных морях."
            , OrderLowerPlant.LAMINARIALES),

    FUCACEAE("Фукуссовые",
            "Фукус, характерный для побережий морей с соленой водой."
            , OrderLowerPlant.FUCALES),

    //Семейства красных водорослей
    PHYLLOPHORACEAE("Филлофоровые",
            "Включает водоросли, такие как филлофора," +
                    " обитающие в глубоких водах и используемые для производства агара."
            , OrderLowerPlant.GIGARTINALES),

    CORALLINACEAE("Кораллтиновые",
            "Это кальцинированные красные водоросли," +
                    " которые образуют кораллообразные структуры в тропических морях."
            , OrderLowerPlant.CORALLINALES);

    private final String name;
    private final String description;
    private final OrderLowerPlant order;

    FamilyLowerPlant(String name, String description, OrderLowerPlant order) {
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

    public OrderLowerPlant getOrder() {
        return order;
    }
}
