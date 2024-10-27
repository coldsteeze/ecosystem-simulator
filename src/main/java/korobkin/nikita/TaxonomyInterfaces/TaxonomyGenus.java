package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomyGenus<F extends TaxonomyFamily<?>> extends Describable {
    String getName();
    F getFamily();
}
