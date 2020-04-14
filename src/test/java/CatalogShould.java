import domain.advert.Advert;
import domain.advert.exceptions.AdvertDoesNotExistException;
import domain.advert.exceptions.DuplicatedAdvertException;
import domain.advert.value_object.Description;
import domain.advert.value_object.Title;
import domain.catalog.Catalog;
import domain.dto.AdvertDTO;
import domain.dto.CatalogDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class CatalogShould {

    Catalog catalog;

    Advert advert1 = new Advert.AdvertBuilder()
            .title(new Title("this is a title"))
            .description(new Description("this is a description"))
            .date(LocalDate.of(2020,4,6))
            .build();

    @Test
    public void not_allow_adverts_with_same_title_and_description(){
        catalog = new Catalog();

        Advert sameDataAdvert = new Advert.AdvertBuilder()
                .title(new Title("this is a title"))
                .description(new Description("this is a description"))
                .date(LocalDate.of(2020,4,6))
                .build();

        catalog.add(advert1.getId(), advert1);

        Assertions.assertThrows(DuplicatedAdvertException.class, () -> catalog.add(sameDataAdvert.getId(), sameDataAdvert));
    }

    @Test
    public void not_allow_remove_an_unexciting_advert(){

        catalog = new Catalog();
        catalog.add(advert1.getId(), advert1);
        catalog.remove(advert1.getId());

        Assertions.assertThrows(AdvertDoesNotExistException.class, () -> catalog.remove(advert1.getId()));
    }

    @Test
    public void list_existing_adverts(){
        catalog = new Catalog();
        CatalogDTO expectedDTO = new CatalogDTO();

        AdvertDTO advert1DTO = new AdvertDTO();
        advert1DTO.title = new Title("this is a title").createDTO();
        advert1DTO.description = new Description("this is a description").createDTO();
        advert1DTO.date = LocalDate.of(2020, 4, 6);

        AdvertDTO advert2DTO = new AdvertDTO();
        advert2DTO.title = new Title("Advert two title").createDTO();
        advert2DTO.description = new Description("Advert two description").createDTO();
        advert2DTO.date = LocalDate.of(2020, 4, 6);

        expectedDTO.adverts.add(advert1DTO);
        expectedDTO.adverts.add(advert2DTO);
        Advert advert2 = new Advert.AdvertBuilder()
                .title(new Title("Advert two title"))
                .description(new Description("Advert two description"))
                .date(LocalDate.of(2020, 4, 6))
                .build();
        catalog.add(advert1.getId(), advert1);
        catalog.add(advert2.getId(), advert2);


        Assert.assertEquals(expectedDTO, catalog.list());
    }
}
