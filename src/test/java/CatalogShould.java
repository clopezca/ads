import domain.advert.Advert;
import domain.advert.exceptions.DuplicatedAdvertException;
import domain.advert.value_object.Description;
import domain.advert.value_object.Title;
import domain.catalog.Catalog;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class CatalogShould {

    @Test
    public void not_allow_adverts_with_same_title_and_description(){
        Catalog catalog = new Catalog();

        Advert testDataAdvert = new Advert.AdvertBuilder()
                .title(new Title("this is a title"))
                .description(new Description("this is a description"))
                .date(LocalDate.of(2020,4,6))
                .build();

        Advert sameDataAdvert = new Advert.AdvertBuilder()
                .title(new Title("this is a title"))
                .description(new Description("this is a description"))
                .date(LocalDate.of(2020,4,6))
                .build();

        catalog.add(testDataAdvert.getId(), testDataAdvert);

        Assertions.assertThrows(DuplicatedAdvertException.class, () -> catalog.add(sameDataAdvert.getId(), sameDataAdvert));
    }
}
