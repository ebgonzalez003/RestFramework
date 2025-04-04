package Proyecto.Serialization;

public class CategoriesResponse {
    private Integer id;
    private String name;

    public CategoriesResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoriesResponse(Integer id) {
        this.id = id;
    }

    public CategoriesResponse(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoriesResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
