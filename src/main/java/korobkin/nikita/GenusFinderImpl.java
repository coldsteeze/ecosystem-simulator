package korobkin.nikita;

import korobkin.nikita.TaxonomyInterfaces.TaxonomyGenus;
import korobkin.nikita.Animals.enums.MulticellularAnimal.GenusAnimalMulticellularAnimal;
import korobkin.nikita.Plants.enums.HigherPlant.GenusPlantHigherPlant;
import korobkin.nikita.Plants.enums.LowerPlant.GenusPlantLowerPlant;

public class GenusFinderImpl implements GenusFinder<Species<?>> {

    @Override
    public TaxonomyGenus<?> findGenusByName(String genusName) {
        // Поиск в GenusAnimalMulticellularAnimal
        for (GenusAnimalMulticellularAnimal genus : GenusAnimalMulticellularAnimal.values()) {
            if (genus.name().equalsIgnoreCase(genusName)) {
                return genus;
            }
        }

        // Поиск в GenusPlantHigherPlant
        for (GenusPlantHigherPlant genus : GenusPlantHigherPlant.values()) {

            if (genus.name().equalsIgnoreCase(genusName)) {
                return genus;
            }
        }

        // Поиск в GenusPlantLowerPlant
        for (GenusPlantLowerPlant genus : GenusPlantLowerPlant.values()) {
            if (genus.name().equalsIgnoreCase(genusName)) {
                return genus;
            }
        }

        // Если не найдено
        //System.out.println("Род с именем '" + genusName + "' не найден.");
        return null;
    }
}
