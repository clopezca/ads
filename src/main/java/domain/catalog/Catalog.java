package domain.catalog;

import domain.advert.Advert;
import domain.advert.exceptions.DuplicatedAdvertException;
import domain.advert.exceptions.SameTitleAndDescriptionException;
import domain.advert.value_object.AdvertId;

import java.util.LinkedHashMap;
import java.util.Map;

public class Catalog {

    Map<AdvertId, Advert> catalog = new LinkedHashMap<AdvertId, Advert>();

    public void add(AdvertId advertId, Advert advert) {
        for (Advert existingAdvert : catalog.values()) {
            if(existingAdvert.equals(advert)) throw new DuplicatedAdvertException();
        }
        catalog.put(advertId, advert);
    }
}
