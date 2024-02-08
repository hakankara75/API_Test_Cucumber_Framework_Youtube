package utilities;

import java.util.HashMap;
import java.util.Map;

public class Herokuapp_TestData {
   /* {
        "firstname" : "hakan",
            "lastname" : "kara",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
    },
        "additionalneeds" : "Breakfast"
    }
    */
    public Map<String, String> bookingdatesMapMethod(String checkin, String checkout) {

        Map<String, String> expected= new HashMap<>();
        expected.put("checkin", checkin);
        expected.put("checkout", checkout);
        return expected;

    }

    public Map<String, Object> outherMapMethod(String firstname, String lastname,
     Integer totalprice, Boolean depositpaid, Map<String, String> bookingdatesMapMethod, String additionalneeds){

        Map<String, Object> outher= new HashMap<>();
        outher.put("firstname", firstname);
        outher.put("lastname", lastname);
        outher.put("totalprice", totalprice);
        outher.put("depositpaid", depositpaid);
        outher.put("bookingdates", bookingdatesMapMethod);
        outher.put("additionalneeds", additionalneeds);
        return outher;

    }
}
