package korobkin.nikita.Plants.enums.LowerPlant;

import korobkin.nikita.Plants.interfaces.Order;
import korobkin.nikita.Plants.interfaces.Taxon;

public enum OrderLowerPlant implements Taxon, Order {
    //Порядки зеленых водорослей
    VOLVOCALES("Вольвокальные",
            "Порядок колониальных водорослей.",
            ClassLowerPlant.CHLOROPHYCEAE),

    ULVALES("Улотриксовые",
                       "Представители преимущественно живут в пресной и морской воде.",
               ClassLowerPlant.CHLOROPHYCEAE),

    ZYGNEMATALES("Зигнемовые",
            "Представители преимущественно живут в пресной и морской воде.",
            ClassLowerPlant.CHLOROPHYCEAE),

    //Порядки бурых водорослей
    LAMINARIALES("Ламинариевые",
            "Включает крупные морские водоросли.",
            ClassLowerPlant.PHAEOPHYCEAE),

    FUCALES("Фукусовые",
            "Образуют плотные заросли в прибрежных зонах, часто обитают в приливно-отливных зонах.",
            ClassLowerPlant.PHAEOPHYCEAE),

    //Порядки красных водорослей
    GIGARTINALES("Багрянковые",
            "Красные водоросли содержат особые пигменты (фикобилины)," +
                    " которые позволяют им поглощать свет на большой глубине." +
                    " Их используют для получения агар-агара, желирующего агента.",
            ClassLowerPlant.FLORIDEOPHYCEAE),

    CORALLINALES("Кораллтиновые",
            "это группа красных водорослей," +
                    " которые известны своей способностью к кальцификации," +
                    " образуя кораллообразные структуры." +
                    " Они играют важную роль в формировании рифов и обитании прибрежных морских экосистем.",
            ClassLowerPlant.FLORIDEOPHYCEAE);







    private final String name;
    private final String description;
    private final ClassLowerPlant plantClass;

    OrderLowerPlant(String name, String description, ClassLowerPlant plantClass) {
        this.name = name;
        this.description = description;
        this.plantClass = plantClass;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ClassLowerPlant getPlantClass() {
        return plantClass;
    }
}

