package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomyClass<P extends TaxonomyPhylum<?>> extends Describable {
    P getPhylum();
}
