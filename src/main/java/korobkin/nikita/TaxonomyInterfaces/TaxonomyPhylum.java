package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomyPhylum<S extends TaxonomySubkingdom<?>> extends Describable {
    S getSubkingdom();
}
