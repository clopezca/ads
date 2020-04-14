import domain.advert.Advert;
import domain.advert.Description;
import domain.advert.Title;
import domain.advert.exceptions.TooLargeTitleException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class AdvertShould {

    @Test
    public void not_allow_building_without_a_title(){

        Assertions.assertThrows(IllegalStateException.class, () -> new Advert.AdvertBuilder()
                .description(new Description("this is a description"))
                .date(LocalDate.of(2020,4,6))
                .build());
    }

    @Test
    public void not_allow_a_title_length_of_more_than_50_characters(){

        Assertions.assertThrows(TooLargeTitleException.class, () -> new Advert.AdvertBuilder()
                .title(new Title(new String(new char[51]).replace('\0', 'x')))
                .description(new Description("this is a description"))
                .date(LocalDate.of(2020,4,6))
                .build());
    }

    @Test
    public void not_allow_building_with_an_empty_title(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Advert.AdvertBuilder()
                .title(new Title(" "))
                .description(new Description("this is a description"))
                .date(LocalDate.of(2020,4,6))
                .build());
    }

    @Test
    public void not_allow_building_without_a_description(){

        Assertions.assertThrows(IllegalStateException.class, () -> new Advert.AdvertBuilder()
                .title(new Title("this is a title"))
                .date(LocalDate.of(2020,4,6))
                .build());
    }

    @Test
    public void not_allow_building_with_an_empty_description(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Advert.AdvertBuilder()
                .title(new Title("this is a title"))
                .description(new Description(" "))
                .date(LocalDate.of(2020,4,6))
                .build());
    }

    @Test
    public void not_allow_building_without_a_date(){

        Assertions.assertThrows(IllegalStateException.class, () -> new Advert.AdvertBuilder()
                .title(new Title("this is a title"))
                .description(new Description("this is a description"))
                .build());
    }
}
