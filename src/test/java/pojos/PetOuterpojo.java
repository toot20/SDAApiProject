package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.swing.text.html.HTML;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetOuterpojo {

    private Integer id;
    private PetCategoryPojo category;
    private String name;
    private List<String> photoUrls;
    private List<PetTagsPojo> tags;
    private String status;
    public PetOuterpojo(){

    }
    public PetOuterpojo(Integer id, PetCategoryPojo category, String name, List<String> photoUrls, List<PetTagsPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public PetCategoryPojo getcategory() {
        return category;
    }

    public void setcategory(PetCategoryPojo category) {
        this.category = category;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public List<String> getphotoUrls() {
        return photoUrls;
    }

    public void setphotoUrls(List<String> photoUrls) {this.photoUrls = photoUrls;
    }

    public List<PetTagsPojo> gettags() {
        return tags;
    }

    public void settags(List<PetTagsPojo> tags) {
        this.tags = tags;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetOuterpojo{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", name=" + name +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }


}
