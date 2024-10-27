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
}
