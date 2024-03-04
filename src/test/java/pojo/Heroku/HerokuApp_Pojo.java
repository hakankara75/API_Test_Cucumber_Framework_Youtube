package pojo.Heroku;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.java.sl.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HerokuApp_Pojo {
    private String firstname;

    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;

    private BookingDates_Pojo bookingDatesPojo;
    private String additionalneeds;

}
