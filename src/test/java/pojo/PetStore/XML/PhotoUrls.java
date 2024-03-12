package pojo.PetStore.XML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="photoUrls")
public class PhotoUrls {
    private String photoUrl;

    public PhotoUrls() {
    }

    public PhotoUrls(String photoUrl) {
        this.photoUrl = photoUrl;
    }
@XmlElement
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
