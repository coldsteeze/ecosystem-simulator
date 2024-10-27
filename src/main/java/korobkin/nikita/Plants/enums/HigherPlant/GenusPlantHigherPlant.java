package korobkin.nikita.Plants.enums.HigherPlant;

import korobkin.nikita.Plants.interfacesPlant.IGenusPlant;


public enum GenusPlantHigherPlant implements IGenusPlant {

    // Роды для семейства Полиподиевые
    POLYPODIUM("Многоножка",
            "Род папоротников с перистыми листьями, широко распространен в умеренных регионах.",
            FamilyPlantHigherPlant.POLYPODIACEAE),

    // Роды для семейства Асплениевые
    ASPLENIUM("Асплениум",
            "Род папоротников, известен своим разнообразием форм, обитающий в тропических и субтропических регионах.",
            FamilyPlantHigherPlant.ASPLENIACEAE),

    // Роды для семейства Щитовниковые
    DRYOPTERIS("Щитовник",
            "Род папоротников, распространенный в лесных зонах, включает такие виды, как щитовник мужской.",
            FamilyPlantHigherPlant.DRYOPTERIDACEAE),

    // Роды для семейства Сальвиниевые
    SALVINIA("Сальвиния",
            "Род водных папоротников, часто встречающихся в аквариумах и влажных местах.",
            FamilyPlantHigherPlant.SALVINIACEAE),

    // Роды для семейства Марсилеевые
    MARSILEA("Марсилия",
            "Род водных папоротников, обитающих в стоячих водоемах.",
            FamilyPlantHigherPlant.MARSILEACEAE),

    // Роды для семейства Хвощевые
    EQUISETUM("Хвощ",
            "Единственный род семейства хвощевых, включает растения с характерными членистыми стеблями.",
            FamilyPlantHigherPlant.EQUISETACEAE),

    // Роды для семейства Плауновые
    LYCOPODIUM("Плаун",
            "Род ползучих растений, размножающихся спорами, часто растущих в хвойных лесах.",
            FamilyPlantHigherPlant.LYCOPODIACEAE),

    // Роды для семейства Полушниковые
    ISOETES("Полушник",
            "Род водных и болотных растений, которые обитают на болотах и мелководьях.",
            FamilyPlantHigherPlant.ISOETACEAE),

    // Роды для семейства Сосновые
    PINUS("Сосна",
            "Род хвойных деревьев, включающий многие виды, такие как сосна обыкновенная.",
            FamilyPlantHigherPlant.PINACEAE),

    // Роды для семейства Кипарисовые
    CUPRESSUS("Кипарис",
            "Род хвойных деревьев и кустарников с чешуйчатыми листьями, распространен в теплых регионах.",
            FamilyPlantHigherPlant.CUPRESSACEAE),

    // Роды для семейства Араукариевые
    ARAUCARIA("Араукария",
            "Род древних хвойных деревьев, встречающихся в тропических регионах.",
            FamilyPlantHigherPlant.ARAUCARIACEAE),

    // Роды для семейства Саговниковые
    CYCAS("Саговник",
            "Род древних голосеменных растений, внешне напоминающих пальмы.",
            FamilyPlantHigherPlant.CYCADACEAE),

    // Роды для семейства Гинкговые
    GINKGO("Гинкго",
            "Единственный представитель рода — гинкго двулопастный, древнее дерево с уникальной листвой.",
            FamilyPlantHigherPlant.GINKGOACEAE),

    // Роды для семейства Розовые
    ROSA("Роза",
            "Род кустарников, широко известный своими декоративными цветами.",
            FamilyPlantHigherPlant.ROSACEAE),

    MALUS("Яблоня",
            "Род деревьев, включающий яблоню домашнюю (Malus domestica), одно из важнейших плодовых растений.",
            FamilyPlantHigherPlant.ROSACEAE),

    // Роды для семейства Тутовые
    FICUS("Инжир",
            "Род деревьев и кустарников, включая виды, такие как инжир обыкновенный.",
            FamilyPlantHigherPlant.MORACEAE),

    // Роды для семейства Крапивные
    URTICA("Крапива",
            "Род растений с жгучими волосками, широко распространенных по всему миру.",
            FamilyPlantHigherPlant.URTICACEAE),

    // Роды для семейства Мятликовые
    TRITICUM("Пшеница",
            "Род злаков, включающий виды, такие как пшеница мягкая, важная сельскохозяйственная культура.",
            FamilyPlantHigherPlant.POACEAE),

    // Роды для семейства Бобовые
    GLYCINE("Соя",
            "Род растений, включающий соевые бобы, важный источник белка.",
            FamilyPlantHigherPlant.FABACEAE),

    // Роды для семейства Астровые
    HELIANTHUS("Подсолнечник",
            "Род растений с крупными соцветиями-корзинками, включающий подсолнечник однолетний.",
            FamilyPlantHigherPlant.ASTERACEAE),

    // Роды для семейства Капустные
    BRASSICA("Капуста",
            "Род растений, включающий капусту, горчицу и редьку.",
            FamilyPlantHigherPlant.BRASSICACEAE),

    // Роды для семейства Лилейные
    LILIUM("Лилия",
            "Род декоративных растений с крупными цветами, широко распространенных в садах.",
            FamilyPlantHigherPlant.LILIACEAE),

    // Роды для семейства Пальмовые
    COCOS("Кокосовая пальма",
            "Род пальм, включающий кокосовую пальму, произрастающую в тропиках.",
            FamilyPlantHigherPlant.ARECACEAE);

    private final String name;
    private final String description;
    private final FamilyPlantHigherPlant family;

    GenusPlantHigherPlant(String name, String description, FamilyPlantHigherPlant family) {
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

    public FamilyPlantHigherPlant getFamily() {
        return family;
    }
}
