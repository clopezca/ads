package domain.catalog;

import domain.advert.value_object.AdvertId;

public interface RemoverStrategy {
    AdvertId getAdvertIdToRemove(Catalog catalog);
}
