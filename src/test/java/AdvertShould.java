import domain.advert.Advert;
import domain.advert.Description;
import domain.advert.Title;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AdvertShould {

    @Test
    public void not_allow_building_without_a_title(){
        String result = "";

        try {
            new Advert.AdvertBuilder()
                    .description(new Description("this is a description"))
                    .date(LocalDate.of(2020,4,6))
                    .build();
        } catch(IllegalStateException e){
            result = e.getMessage();
        }

        Assert.assertEquals("title cannot be empty", result);
    }
}
