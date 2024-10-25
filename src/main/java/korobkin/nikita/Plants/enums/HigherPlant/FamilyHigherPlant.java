package korobkin.nikita.Plants.enums.HigherPlant;

import korobkin.nikita.Plants.interfaces.Family;
import korobkin.nikita.Taxon;

public enum FamilyHigherPlant implements Taxon, Family {

    // Семейства папоротниковых
    POLYPODIACEAE("Полиподиевые",
            "Включает папоротники с перистыми листьями, такими как многоножка (Polypodium).",
            OrderHigherPlant.POLYPODIALES),

    ASPLENIACEAE("Асплениевые",
            "Включает растения, такие как аспления, которые широко распространены в тропиках.",
            OrderHigherPlant.POLYPODIALES),

    DRYOPTERIDACEAE("Щитовниковые",
            "Включает растения, такие как щитовник мужской (Dryopteris filix-mas).",
            OrderHigherPlant.POLYPODIALES),

    // Семейства сальвиниевых
    SALVINIACEAE("Сальвиниевые",
            "Водные папоротники, такие как сальвиния, часто используются в аквариумистике.",
            OrderHigherPlant.SALVINIALES),

    MARSILEACEAE("Марсилеевые",
            "Включает водные папоротники, такие как марсилия, обитающие в стоячих водоемах.",
            OrderHigherPlant.SALVINIALES),

    // Семейства хвощевых
    EQUISETACEAE("Хвощевые",
            "Единственное семейство, включающее все современные виды хвощей, с членистыми стеблями и чешуйчатыми листьями.",
            OrderHigherPlant.EQAISETALES),

    // Семейства плаунообразных
    LYCOPODIACEAE("Плауновые",
            "Включает ползучие растения, такие как плаун булавовидный (Lycopodium clavatum).",
            OrderHigherPlant.LYCOPODIALES),

    ISOETACEAE("Полушниковые",
            "Включает водные и болотные растения, такие как полушник (Isoetes).",
            OrderHigherPlant.ISOETALES),

    // Семейства голосеменных
    PINACEAE("Сосновые",
            "Включает сосну, ель, лиственницу, пихту — широко распространенные хвойные деревья.",
            OrderHigherPlant.PINALES),

    CUPRESSACEAE("Кипарисовые",
            "Включает кипарис, можжевельник, туи — хвойные деревья и кустарники с чешуевидными листьями.",
            OrderHigherPlant.PINALES),

    ARAUCARIACEAE("Араукариевые",
            "Древние хвойные растения, такие как араукария, встречающиеся в тропиках и субтропиках.",
            OrderHigherPlant.PINALES),

    CYCADACEAE("Саговниковые",
            "Древние голосеменные растения, похожие на пальмы с толстым стволом и крупными перистыми листьями.",
            OrderHigherPlant.CYCADALES),

    GINKGOACEAE("Гинкговые",
            "Единственный представитель семейства — гинкго двулопастный (Ginkgo biloba), древнее дерево с веерообразными листьями.",
            OrderHigherPlant.GINKGOALES),

    GNETACEAE("Гнетовые",
            "Включает редкие растения, такие как гнетум, обитающие в тропических и пустынных регионах.",
            OrderHigherPlant.GNETALES),

    WELWITSCHIACEAE("Вельвичиевые",
            "Семейство включает уникальную вельвичию, растение пустыни Намиб с двумя постоянно растущими листьями.",
            OrderHigherPlant.WELWITSCHIALES),

    EPHEDRACEAE("Эфедровые",
            "Включает растения эфедру, которые растут в горных и пустынных регионах.",
            OrderHigherPlant.GNETALES),

    // Семейства покрытосеменных (двудольные)
    ROSACEAE("Розовые",
            "Включает яблоню, грушу, розу, малину — плодовые и декоративные деревья и кустарники.",
            OrderHigherPlant.ROSALES),

    MORACEAE("Тутовые",
            "Включает инжир, шелковицу — деревья и кустарники, часто встречающиеся в теплых климатах.",
            OrderHigherPlant.ROSALES),

    URTICACEAE("Крапивные",
            "Включает крапиву, растения с жгучими волосками, распространенные в различных регионах.",
            OrderHigherPlant.ROSALES),

    POACEAE("Мятликовые",
            "Включает пшеницу, кукурузу, рис, овес, бамбук — важные сельскохозяйственные злаки.",
            OrderHigherPlant.POALES_MONOCOT),

    FABACEAE("Бобовые",
            "Включает горох, фасоль, клевер, сою — растения с бабочковидными цветками и плодами-бобами.",
            OrderHigherPlant.FABALES),

    ASTERACEAE("Астровые",
            "Включает подсолнечник, ромашку, астру — растения с соцветиями в виде корзинок.",
            OrderHigherPlant.ASTERALES),

    BRASSICACEAE("Капустные",
            "Включает капусту, горчицу, редьку — растения с цветками, имеющими четыре лепестка.",
            OrderHigherPlant.BRASSICALES),

    // Семейства покрытосеменных (однодольные)
    LILIACEAE("Лилейные",
            "Включает лилии, тюльпаны, лук, чеснок — декоративные и съедобные растения.",
            OrderHigherPlant.LILIALES),

    ARECACEAE("Пальмовые",
            "Включает кокосовую пальму, финиковую пальму — деревья тропических регионов с перистыми листьями.",
            OrderHigherPlant.ARECALES);

    private final String name;
    private final String description;
    private final OrderHigherPlant order;

    FamilyHigherPlant(String name, String description, OrderHigherPlant order) {
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

    public OrderHigherPlant getOrder() {
        return order;
    }
}
