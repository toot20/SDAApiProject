package pojos;

public class PetCategoryPojo {

    private Integer id;
    private String name;

    public PetCategoryPojo(){

    }
    public PetCategoryPojo(Integer id, String name) {
        this.id = id;
        this.name = name;

    }
    public Integer getid() {
        return id;
    }

    public void setid(Integer categoryId) {
        this.id = categoryId;
    }

    public String getname() {
        return name;
    }

    public void setname(String categoryName) {
        this.name = categoryName;
    }

    @Override
    public String toString() {
        return "PetCategoryPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
