package domain.catalog;

import domain.advert.Advert;
import domain.advert.value_object.AdvertId;

import java.util.Collection;

public class LessVisitedAdvertStrategy implements RemoverStrategy {
    @Override
    public AdvertId getAdvertIdToRemove(Collection<Advert> catalogValues) {
        // logica compareTo para obtener el menos visitado
        return null;
    }
}
