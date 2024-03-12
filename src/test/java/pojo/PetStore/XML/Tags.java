package pojo.PetStore.XML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="tags")
public class Tags {
    private List<Tag> tags;

@XmlElement(name = "tag")
    public List<Tag> getTags() {
        return tags;
    }

    public Tags() {
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Tags(List<Tag> tags) {
        this.tags = tags;
    }
}
