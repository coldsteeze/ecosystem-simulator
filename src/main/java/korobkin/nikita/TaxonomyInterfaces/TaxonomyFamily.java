package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomyFamily<O extends TaxonomyOrder<?>> extends Describable {
    O getOrder();
}
