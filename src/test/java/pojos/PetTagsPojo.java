package pojos;

public class PetTagsPojo {

    private Integer id;
    private String name;

    public PetTagsPojo(){

    }
    public PetTagsPojo(Integer id, String name){
        this.id = id;
        this.name = name;
    }
    public Integer getid() {
        return id;
    }

    public void setid(Integer tagsId) {
        this.id = tagsId;
    }

    public String getname() {
        return name;
    }

    public void setname(String tagsName) {
        this.name = tagsName;
    }

    public String toString() {
        return "PetTagsPojo{" +
                ", id=" + id + '\'' +
                ", name=" + name + '\'' +
                '}';
    }

}
