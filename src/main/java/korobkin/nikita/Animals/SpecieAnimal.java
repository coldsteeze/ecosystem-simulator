package korobkin.nikita.Animals;

import korobkin.nikita.Animals.interfaces.Genus;

public class SpecieAnimal {
    private final String scientificName;
    private final String commonName;
    private final String description;
    private final Genus genus;

    public SpecieAnimal(String scientificName, String commonName, String description, Genus genus) {
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.description = description;
        this.genus = genus;
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

    public Genus getGenus() {
        return genus;
    }

    @Override
    public String toString() {
        return "Вид: " + scientificName + " (" + commonName + ") - " + description + ", Род: " + genus.getName();
    }

    public void printTaxonomicHierarchy() {
        System.out.println("Царство: " + genus.getFamily().getOrder().getAnimalClass().getPhylum().getSubkingdom().getKingdomAnimal().getDescription());
        System.out.println("Подцарство: " + genus.getFamily().getOrder().getAnimalClass().getPhylum().getSubkingdom().getDescription());
        System.out.println("Тип: " + genus.getFamily().getOrder().getAnimalClass().getPhylum().getDescription());
        System.out.println("Класс: " + genus.getFamily().getOrder().getAnimalClass().getDescription());
        System.out.println("Порядок: " + genus.getFamily().getOrder().getDescription());
        System.out.println("Семейство: " + genus.getFamily().getDescription());
        System.out.println("Род: " + genus.getDescription());
        System.out.println(this);
    }
}
