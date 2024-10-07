package Proyecto.Serialization;

public class TagsResponse {

    private Integer id;
    private String name;


    public TagsResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TagsResponse() {
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
        return "TagsResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
