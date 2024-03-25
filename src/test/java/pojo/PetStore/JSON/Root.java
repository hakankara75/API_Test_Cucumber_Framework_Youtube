package pojo.PetStore.JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;


}
