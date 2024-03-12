package pojo.PetStore.XML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Pet")
public class Pet {
    private int id;
    private Category Category;
    private String name;
    private PhotoUrls photoUrls;
    private Tags tags;
    private String status;

    public Pet() {
    }

    public Pet(int id, pojo.PetStore.XML.Category category, String name, PhotoUrls photoUrls, Tags tags, String status) {
        this.id = id;
        Category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public pojo.PetStore.XML.Category getCategory() {
        return Category;
    }

    public void setCategory(pojo.PetStore.XML.Category category) {
        Category = category;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public PhotoUrls getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(PhotoUrls photoUrls) {
        this.photoUrls = photoUrls;
    }
    @XmlElement
    public pojo.PetStore.XML.Tags getTags() {
        return tags;
    }

    public void setTags(pojo.PetStore.XML.Tags tags) {
        this.tags = tags;
    }
    @XmlElement
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
