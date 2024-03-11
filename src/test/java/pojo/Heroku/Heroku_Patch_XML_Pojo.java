package pojo.Heroku;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "booking")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Heroku_Patch_XML_Pojo {

    private String firstname;
    private String lastname;

    public Heroku_Patch_XML_Pojo() {
    }

    public Heroku_Patch_XML_Pojo(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
@XmlElement
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @XmlElement
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
