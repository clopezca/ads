package domain.catalog;

import domain.advert.value_object.AdvertId;

import java.util.*;

public class LessVisitedAdvertStrategy implements RemoverStrategy {
    @Override
    public AdvertId getAdvertIdToRemove(Catalog catalog) {
        List<Map.Entry<AdvertId, Visit>> visitsList = new ArrayList<>(catalog.visits.entrySet());
        visitsList.sort(Comparator.comparingInt(entry -> entry.getValue().getVisits()));
        Map.Entry<AdvertId, Visit> lessVisitedAdvert = visitsList.get(0);
        return lessVisitedAdvert.getKey();
    }
}
