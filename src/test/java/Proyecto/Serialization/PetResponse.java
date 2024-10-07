package Proyecto.Serialization;

import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.util.List;

public class PetResponse {
    private Long id;
    private CategoriesResponse category;
    private String name;
    private List<String> photoUrls;
    private List<TagsResponse> tags;
    private String status;

    public PetResponse(Long id, CategoriesResponse category, String name, List<String> photoUrls, List<TagsResponse> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetResponse(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriesResponse getCategory() {
        return category;
    }

    public void setCategory(CategoriesResponse category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<TagsResponse> getTags() {
        return tags;
    }

    public void setTags(List<TagsResponse> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetResponse{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
