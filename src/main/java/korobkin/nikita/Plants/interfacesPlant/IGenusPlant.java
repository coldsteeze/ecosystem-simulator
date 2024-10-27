package korobkin.nikita.Plants.interfacesPlant;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;

public interface IGenusPlant extends TaxonomyGenus<IFamilyPlant> {
    String getName();
}
