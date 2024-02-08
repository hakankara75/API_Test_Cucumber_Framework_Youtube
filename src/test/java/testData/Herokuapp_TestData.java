package testData;

import java.util.HashMap;
import java.util.Map;

public class Herokuapp_TestData {


    public Map<String, String> bookingdatesMap(String checkin, String checkout) {
    Map<String, String> expectedData = new HashMap<>();
    expectedData.put("checkin", checkin);
    expectedData.put("checkout", checkout);
        return expectedData;

    }

    public Map<String, Object> outerMap(String firstname, String lastname, Integer totalprice,
                                        Boolean depositpaid, Map<String, String> bookingdatesMap,String additionalneeds) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", additionalneeds);
        return expectedData;

    }


}
