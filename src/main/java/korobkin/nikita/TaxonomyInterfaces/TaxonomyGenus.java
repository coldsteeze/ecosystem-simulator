package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomyGenus<F extends TaxonomyFamily<?>> extends Describable {
    String getName();
    String getEnumName();
    F getFamily();
}
