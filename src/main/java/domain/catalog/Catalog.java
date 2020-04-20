package domain.catalog;

import domain.advert.Advert;
import domain.advert.exceptions.AdvertDoesNotExistException;
import domain.advert.exceptions.DuplicatedAdvertException;
import domain.advert.value_object.AdvertId;
import domain.dto.CatalogDTO;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Catalog {

    private static final int MAX = 100;
    Map<AdvertId, Advert> catalog = new LinkedHashMap<>();
    Map<AdvertId, Visit> visits = new LinkedHashMap<>();
    private final RemoverStrategy strategy;

    public Catalog(RemoverStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(AdvertId advertId, Advert advert) {
        if( catalog.size() == MAX) useRemoveStrategy();
        for (Advert existingAdvert : catalog.values()) {
            if (existingAdvert.equals(advert)) throw new DuplicatedAdvertException();
        }
        catalog.put(advertId, advert);
        visits.put(advertId, new Visit());
    }

    private void useRemoveStrategy() {
        this.remove(strategy.getAdvertIdToRemove(this));
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

    public void removeByDate(LocalDate expirationDate) {
        catalog.values().removeIf(advert -> advert.isPublicationDateOlder(expirationDate));
    }

    public Advert getAdvert(AdvertId advertId) {
        if(catalog.get(advertId) == null) throw new AdvertDoesNotExistException();
        return catalog.get(advertId);
    }

    public void addVisit(AdvertId advertId, Visit visit) {
        visits.get(advertId).addVisit();
    }

    public Visit getVisits(AdvertId advertId) {
        return visits.get(advertId);
    }
}