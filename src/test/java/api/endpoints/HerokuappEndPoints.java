package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.herokuapp.herokuapp.AppModel;
import org.apache.http.conn.routing.RouteInfo;

import static io.restassured.RestAssured.given;

public class HerokuappEndPoints
{
    public static int bookingId;
    public static String token;

    public static Response createToken(AppModel.AuthModel auth)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post(Routes.CREATE_TOKEN);

        return response;
    }

    public static Response createBooking(AppModel.HerokuappModel app)
    {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(app)
                        .when()
                        .post(Routes.CreateBooking);

        bookingId = response.jsonPath().getInt("bookingid");

        return response;
    }

    public static Response getBooking()
    {
        return given()
                .pathParam("id", bookingId)
                .when()
                .get(Routes.GET_BOOKING);
    }

    public static Response updateBooking(AppModel.HerokuappModel app)
    {
        Response response = given()
                .log().all()
                .auth().preemptive().basic("admin", "password123")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .cookie("token", token)
                .pathParam("id", bookingId)
                .body(app)
                .when()
                .put(Routes.UpdateBooking);

        return response;
    }

    public static Response partialUpdateBooking(AppModel.PartialUpdateBookingModel app)
    {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .cookie("token", token)
                .pathParam("id", bookingId)
                .body(app)
                .when()
                .patch(Routes.PartialUpdateBooking);
    }

    public static Response deleteBooking()
    {
        return given()
                .cookie("token", token)
                .pathParam("id", bookingId)
                .when()
                .delete(Routes.DeleteBooking);
    }
}