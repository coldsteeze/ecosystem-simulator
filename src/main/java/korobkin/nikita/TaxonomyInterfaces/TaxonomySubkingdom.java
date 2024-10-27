package korobkin.nikita.TaxonomyInterfaces;

public interface TaxonomySubkingdom<K extends TaxonomyKingdom> extends Describable {
    K getKingdom();
}
