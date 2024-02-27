package pojo.PetStore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetStore_ExpectedPojo {

    private int id;
    private PetStore_Category_Pojo category;
    private String name;
    private List<String> photoUrls;
    private List<PetStore_Tags_Pojo> tags;
    private String status;
}
