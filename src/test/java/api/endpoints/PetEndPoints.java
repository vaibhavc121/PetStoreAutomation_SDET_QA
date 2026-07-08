package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndPoints
{
    public static Response createPet()
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body()
                .when()
                .post(Routes.CREATE_PET);
        return response;
    }

    public static Response updatePet()
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body()
                .when()
                .put(Routes.UPDATE_PET);
        return response;
    }

    public static Response getPetById(String petId)
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when()
                .get(Routes.GET_PET_BY_ID);
        return response;
    }

    public static Response uploadPetImage(String petId)
    {
        Response response = given().contentType(ContentType.MULTIPART)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .multiPart("file", "src/test/resources/pet_image.jpg")
                .when()
                .post(Routes.UPLOAD_PET_IMAGE);
        return response;
    }

    public static Response updatePetByStatus(String petId, String status)
    {
        Response response = given().contentType(ContentType.URLENC)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .formParam("status", status)
                .when()
                .post(Routes.UPDATE_PET_FORM);
        return response;
    }

    public static Response findPetByStatus()
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("status", "available")
                .when()
                .get(Routes.FIND_PET_BY_STATUS);
        return response;
    }

    public static Response deletePet(String petId)
    {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .when()
                .delete(Routes.DELETE_PET);
        return response;
    }
}