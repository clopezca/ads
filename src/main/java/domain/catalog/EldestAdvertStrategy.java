package domain.catalog;

import domain.advert.Advert;
import domain.advert.value_object.AdvertId;

import java.util.*;

public class EldestAdvertStrategy implements RemoverStrategy{
    @Override
    public AdvertId getAdvertIdToRemove(Collection<Advert> catalogValues) {
        List<Advert> catalogList = new ArrayList<>(catalogValues);
        catalogList.sort(Comparator.comparing(Advert::getPublicationDate));
        Advert eldestAdvert = catalogList.get(0);

        return eldestAdvert.getId();
    }
}


