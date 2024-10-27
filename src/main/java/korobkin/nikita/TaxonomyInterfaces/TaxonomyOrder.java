package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomyOrder<C extends TaxonomyClass<?>> extends Describable {
    C getInfoAboutClass();
}
