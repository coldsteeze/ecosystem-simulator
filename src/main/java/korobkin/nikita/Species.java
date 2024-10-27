package korobkin.nikita;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;

public class Species<G extends TaxonomyGenus<?>> {
    private final String scientificName;
    private final String commonName;
    private final String description;
    private final G genus;

    public Species(String scientificName, String commonName, String description, G genus) {
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

    public G getGenus() {
        return genus;
    }

    @Override
    public String toString() {
        return "Вид: " + scientificName + " (" + commonName + ") - " + description + ", Род: " + genus.getName();
    }

    public void printTaxonomicHierarchy() {
        System.out.println("Царство: " + genus.getFamily().getOrder().getInfoAboutClass().getPhylum().getSubkingdom().getKingdom().getDescription());
        System.out.println("Подцарство: " + genus.getFamily().getOrder().getInfoAboutClass().getPhylum().getSubkingdom().getDescription());
        System.out.println("Отдел: " + genus.getFamily().getOrder().getInfoAboutClass().getPhylum().getDescription());
        System.out.println("Класс: " + genus.getFamily().getOrder().getInfoAboutClass().getDescription());
        System.out.println("Порядок: " + genus.getFamily().getOrder().getDescription());
        System.out.println("Семейство: " + genus.getFamily().getDescription());
        System.out.println("Род: " + genus.getDescription());
        System.out.println(this);
    }
}
