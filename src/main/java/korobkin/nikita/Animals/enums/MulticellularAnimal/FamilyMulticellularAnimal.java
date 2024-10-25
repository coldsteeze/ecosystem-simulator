package korobkin.nikita.Animals.enums.MulticellularAnimal;

import korobkin.nikita.Animals.interfaces.Family;
import korobkin.nikita.Taxon;


public enum FamilyMulticellularAnimal implements Taxon, Family {
    // Семейства для порядка Хищные (Carnivora)
    FELIDAE("Кошачьи", "Семейство хищных, включающее львов, тигров, и домашних кошек.", OrderMulticellularAnimal.CARNIVORA),
    CANIDAE("Псовые", "Семейство хищных, включающее волков, лис и собак.", OrderMulticellularAnimal.CARNIVORA),
    URSIDAE("Медвежьи", "Семейство крупных хищников, включающее медведей.", OrderMulticellularAnimal.CARNIVORA),

    // Семейства для порядка Приматы (Primates)
    HOMINIDAE("Гоминиды", "Семейство приматов, включающее людей, шимпанзе и горилл.", OrderMulticellularAnimal.PRIMATES),
    CERCOPITHECIDAE("Мартышковые", "Семейство приматов, включающее бабуинов и мартышек.", OrderMulticellularAnimal.PRIMATES),

    // Семейства для порядка Воробьинообразные (Passeriformes)
    CORVIDAE("Врановые", "Семейство птиц, включающее воронов и сорок.", OrderMulticellularAnimal.PASSERIFORMES),
    PASSERIDAE("Воробьиные", "Семейство птиц, включающее воробьев.", OrderMulticellularAnimal.PASSERIFORMES),

    // Семейства для порядка Жесткокрылые (Coleoptera)
    CARABIDAE("Жужелицы", "Семейство жуков, известных своим разнообразием.", OrderMulticellularAnimal.COLEOPTERA),
    CUCULIONIDAE("Долгоносики", "Семейство жуков с характерной формой головы.", OrderMulticellularAnimal.COLEOPTERA),

    // Семейства для порядка Чешуекрылые (Lepidoptera)
    PAPILIONIDAE("Парусники", "Семейство крупных бабочек с яркими крыльями.", OrderMulticellularAnimal.LEPIDOPTERA),
    NYMPHALIDAE("Нимфалиды", "Семейство разнообразных дневных бабочек.", OrderMulticellularAnimal.LEPIDOPTERA);

    private final String name;
    private final String description;
    private final OrderMulticellularAnimal order;

    FamilyMulticellularAnimal(String name, String description, OrderMulticellularAnimal order) {
        this.name = name;
        this.description = description;
        this.order = order;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public OrderMulticellularAnimal getOrder() {
        return order;
    }
}

