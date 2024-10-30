package Proyecto.Api;

import Proyecto.Serialization.CategoriesResponse;
import Proyecto.Serialization.PetResponse;
import Proyecto.Serialization.TagsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pet {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void findPetByStatus() throws JsonProcessingException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
       Response response =  RestAssured.given()
                    .queryParam("status", "available")
                .when()
                    .get("/pet/findByStatus");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().getString("[0].status"), "available");
        TypeReference <List<PetResponse>> tiposMascotas = new TypeReference<List<PetResponse>>() {
        };
        List<PetResponse> listaMascotas = objectMapper.readValue(response.getBody().asString(), tiposMascotas);
        System.out.println(listaMascotas.stream().filter(mascota -> mascota.getName().startsWith("ch")).collect(Collectors.toList()));

    }
    @Test
    public void findPetById() throws JsonProcessingException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Response response = RestAssured
                .given()
                    .pathParam("petid", "33")
                .when()
                    .get("/pet/{petid}");
        PetResponse respuesta = objectMapper.readValue(response.getBody().asString(), PetResponse.class);
        Assert.assertEquals(respuesta.getId(), 33);
        Assert.assertEquals(respuesta.getName(), "aisha" );
        System.out.println(respuesta.getCategory());
    }
    @Test
    public void updatePet() throws JsonProcessingException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        CategoriesResponse category = new CategoriesResponse(666, "ninipelon");
        TagsResponse tags = new TagsResponse(14, "tai");
        PetResponse mascote = new PetResponse(88L, category, "Ronald", Arrays.asList("ronald.com"), Arrays.asList(tags), "sold");
        String mascotaJson = objectMapper.writeValueAsString(mascote);
        System.out.println(mascotaJson);
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(mascotaJson).when().post("/pet");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.prettyPrint());
    }
    @Test
    public void addNewPet() throws JsonProcessingException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        CategoriesResponse category = new CategoriesResponse(10, "xolocanguro");
        TagsResponse tags = new TagsResponse(96, "chicha");
        PetResponse mascote = new PetResponse(80L, category, "Rolly", Arrays.asList("rolly.com"), Arrays.asList(tags), "sold");
        String mascotaJson = objectMapper.writeValueAsString(mascote);
        System.out.println(mascotaJson);
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(mascotaJson).when().post("/pet");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.prettyPrint());
    }


}
