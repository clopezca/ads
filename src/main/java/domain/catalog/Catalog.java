package domain.catalog;

import domain.advert.Advert;
import domain.advert.exceptions.AdvertDoesNotExistException;
import domain.advert.exceptions.DuplicatedAdvertException;
import domain.advert.exceptions.SameTitleAndDescriptionException;
import domain.advert.value_object.AdvertId;
import domain.dto.CatalogDTO;

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

    public void remove(AdvertId advertId) {
      if (catalog.remove(advertId) == null) throw new AdvertDoesNotExistException();
    }

    public CatalogDTO list() {
        CatalogDTO catalogDTO = new CatalogDTO();
        for (Advert advert : catalog.values()) {
            catalogDTO.adverts.add(advert.createDTO());
        }
        return catalogDTO;
    }
}
