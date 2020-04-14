import domain.advert.Advert;
import domain.advert.Description;
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
}
