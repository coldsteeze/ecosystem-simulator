package korobkin.nikita.Plants.enums.HigherPlant;

import korobkin.nikita.Plants.interfacesPlant.IOrderPlant;

//Порядки высших растений
public enum OrderHigherPlant implements IOrderPlant {
    //Порядки папоротниковых
    POLYPODIALES("Полиподиевые",
            "Самый распространенный порядок папоротников," +
                    " включающий растения с крупными перистыми листьями." +
                    "Размножаются спорами, которые находятся на обратной стороне листьев.",
            ClassHigherPlant.POLYPODIOPSIDA),

    SALVINIALES("Сальвиниевые",
            "Водные папоротники," +
                    " растут на поверхности воды и часто используются в аквариумистике и сельском хозяйстве" +
                    " для удобрения почвы.",
            ClassHigherPlant.POLYPODIOPSIDA),

    //Порядки хвощевых
    EQAISETALES("Хвощевые",
            "Единственный порядок, включающий современные хвощи. " +
                    "Эти растения имеют членистые стебли и чешуйчатые листья, " +
                    "растут на влажных почвах и способны поглощать кремнезем.",
            ClassHigherPlant.EQUISETOPSIDA),

    //Порядки плаунообразных
    LYCOPODIALES("Плауновые",
            "Включает мелкие растения с ползучими стеблями. " +
                    "Размножаются спорами и часто растут в хвойных лесах.",
            ClassHigherPlant.LYCOPODIOPSIDA),

    ISOETALES("Полушниковые ",
            "Представители растут в водоемах или на болотах," +
                    " обладают толстым корневищем и полыми листьями.",
            ClassHigherPlant.ISOETOPSIDA),

    //Порядки голосеменных
    PINALES("Сосновые",
            "Включает хвойные деревья и кустарники." +
                    " Cемена развиваются на чешуях шишек." +
                    " Это одни из самых распространенных деревьев в умеренном климате.",
            ClassHigherPlant.PINOPSIDA),

    CYCADALES("Саговниковые",
            "Древние голосеменные растения, похожие на пальмы." +
                    " Обладают толстым стволом и крупными перистыми листьями.",
            ClassHigherPlant.CYCADOPSIDA),

    GINKGOALES("Гинкговые",
            "Единственный представитель — гинкго двулопастный," +
                    " древнее дерево с веерообразными листьями, уникальное для современных лесов.",
            ClassHigherPlant.GINKGOPSIDA),

    GNETALES("Гнетовые",
            "Включает редкие растения, часто растущие в пустынных или горных регионах.",
            ClassHigherPlant.GNETOPSIDA),

    WELWITSCHIALES("Вельвичиевые",
            "Вельвичия — уникальное растение, живущее в пустыне Намиб," +
                    " у которого есть только два огромных листа, которые растут на протяжении всей жизни.",
            ClassHigherPlant.GNETOPSIDA),

    //Порядки покрытосеменных
    ROSALES("Розоцветные",
            "Включает деревья и кустарники. " +
                    "Цветки часто с пятью лепестками, а плоды — костянки или ягоды.",
            ClassHigherPlant.DICOTYLEDONAE),

    POALES_DICOT("Злаковые",
            "Включает важные сельскохозяйственные культуры, такие как пшеница, рожь и овес." +
                    " Стебли полые, а листья узкие и длинные.",
            ClassHigherPlant.DICOTYLEDONAE),

    FABALES("Бобовые",
            " Включает растения, такие как горох, клевер и соя," +
                    " с цветками бабочкового типа и плодами в виде бобов..",
            ClassHigherPlant.DICOTYLEDONAE),

    ASTERALES("Астровые",
            " Включает такие растения, как подсолнечник, ромашка и астра," +
                    " с соцветиями в виде корзинок.",
            ClassHigherPlant.DICOTYLEDONAE),

    BRASSICALES("Крестоцветные",
            "Включает капусту, горчицу и редьку." +
                    " Цветки имеют четыре лепестка, часто располагаются крестом.",
            ClassHigherPlant.DICOTYLEDONAE),

    LILIALES("Лилейные",
            "Включает декоративные растения, такие как лилия и тюльпан." +
                    " Имеют крупные цветки и узкие листья.",
            ClassHigherPlant.MONOCOTYLEDONAE),

    POALES_MONOCOT("Злаковые",
            "Включает такие сельскохозяйственные культуры, как кукуруза, рис и бамбук.",
            ClassHigherPlant.MONOCOTYLEDONAE),

    ARECALES("Пальмоцветные",
            "Включает пальмы и кокосы — крупные деревья с перистыми листьями," +
                    " произрастающие в тропиках.",
            ClassHigherPlant.MONOCOTYLEDONAE);

    private final String name;
    private final String description;
    private final ClassHigherPlant plantClass;

    OrderHigherPlant(String name, String description, ClassHigherPlant plantClass) {
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

    public ClassHigherPlant getInfoAboutClass() {
        return plantClass;
    }
}

