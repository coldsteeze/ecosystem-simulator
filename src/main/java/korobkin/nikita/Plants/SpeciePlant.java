package korobkin.nikita.Plants;

import korobkin.nikita.Plants.interfacesPlant.IGenusPlant;

public class SpeciePlant {
    private final String scientificName;
    private final String commonName;
    private final String description;
    private final IGenusPlant IGenusPlant;

    public SpeciePlant(String scientificName, String commonName, String description, IGenusPlant IGenusPlant) {
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.description = description;
        this.IGenusPlant = IGenusPlant;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getDescription() {
        return description;
    }

    public IGenusPlant getGenus() {
        return IGenusPlant;
    }

    @Override
    public String toString() {
        return "Вид: " + scientificName + " (" + commonName + ") - " + description + ", Род: " + IGenusPlant.getName();
    }

    public void printTaxonomicHierarchy() {
        System.out.println("Царство: " + IGenusPlant.getFamily().getOrder().getInfoAboutClass().getPhylum().getSubkingdom().getKingdom().getDescription());
        System.out.println("Подцарство: " + IGenusPlant.getFamily().getOrder().getInfoAboutClass().getPhylum().getSubkingdom().getDescription());
        System.out.println("Отдел: " + IGenusPlant.getFamily().getOrder().getInfoAboutClass().getPhylum().getDescription());
        System.out.println("Класс: " + IGenusPlant.getFamily().getOrder().getInfoAboutClass().getDescription());
        System.out.println("Порядок: " + IGenusPlant.getFamily().getOrder().getDescription());
        System.out.println("Семейство: " + IGenusPlant.getFamily().getDescription());
        System.out.println("Род: " + IGenusPlant.getDescription());
        System.out.println(this);
    }
}
