package korobkin.nikita;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;

public interface GenusFinder<T extends Species<?>> {
    TaxonomyGenus<?> findGenusByName(String genusName);
}
