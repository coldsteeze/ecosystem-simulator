package korobkin.nikita.Animals.interfacesAnimal;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;

public interface IGenusAnimal extends TaxonomyGenus<IFamilyAnimal> {
    String getName();
}
