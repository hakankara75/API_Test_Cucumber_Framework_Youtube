package utilities;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolder_TestData {
   /* {
        "userId": 5,
            "id": 1,
            "title": "Tamir edilecekler listesi",
            "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    }

    */
    public Map<String, Object> expectedPatchDataMap(Integer userId, Integer id,
      String title, String body){

        Map<String, Object> outher= new HashMap<>();
        if(userId !=null){
            outher.put("userId", userId);
        }
        if(id !=null){
        outher.put("id", id);
        }
        if(title !=null){
            outher.put("title", title);
        }
        if(body !=null){
            outher.put("body", body);
        }

        return outher;

    }
}
