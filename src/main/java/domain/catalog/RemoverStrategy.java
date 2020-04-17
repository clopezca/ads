package domain.catalog;

import domain.advert.Advert;
import domain.advert.value_object.AdvertId;

import java.util.Collection;

public interface RemoverStrategy {
    AdvertId getAdvertIdToRemove(Collection<Advert> catalogValues);
}
