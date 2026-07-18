package api.test;

import api.endpoints.HerokuappEndPoints;
import factory.LoggerFactory;
import io.restassured.response.Response;
import models.herokuapp.herokuapp.AppModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class HerokuappTest
{
    @Test(priority = 1)
    public void createToken()
    {
        try
        {
            String file = FileUtils.getDataFile("herokuapp", "herokuapp", "AppData");

            List<AppModel.AuthModel> authData =
                    JsonUtils.convertJsonListDataModel(
                            file,
                            "createToken",
                            AppModel.AuthModel.class);

            for (AppModel.AuthModel auth : authData)
            {
                Response response = HerokuappEndPoints.createToken(auth);

                response.then().statusCode(200);

                HerokuappEndPoints.token =
                        response.jsonPath().getString("token");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createBooking()
    {
        String file = FileUtils.getDataFile("herokuapp", "herokuapp", "AppData");

        List<AppModel.HerokuappModel> data =
                JsonUtils.convertJsonListDataModel(
                        file,
                        "createBooking",
                        AppModel.HerokuappModel.class);

        for (AppModel.HerokuappModel booking : data)
        {
            Response response =
                    HerokuappEndPoints.createBooking(booking);

            response.then().statusCode(200);

            Assert.assertEquals(
                    response.jsonPath().getString("booking.firstname"),
                    booking.firstname);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void getBooking()
    {
        Response response =
                HerokuappEndPoints.getBooking();
        response.then().log().all();
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
        response.then().statusCode(200);
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3, enabled = false)
    public void updateBooking()
    {
        String file = FileUtils.getDataFile("herokuapp", "herokuapp", "AppData");

        List<AppModel.HerokuappModel> data =
                JsonUtils.convertJsonListDataModel(
                        file,
                        "updateBooking",
                        AppModel.HerokuappModel.class);

        for (AppModel.HerokuappModel booking : data)
        {
            System.out.println("Token = " + HerokuappEndPoints.token);
            System.out.println("BookingId = " + HerokuappEndPoints.bookingId);
            //System.out.println(response.asPrettyString());
            Response response =
                    HerokuappEndPoints.updateBooking(booking);
            response.then().log().all();
            System.out.println(response.getBody().asString());
            System.out.println(response.statusCode());
            response.then().statusCode(200);

            Assert.assertEquals(
                    response.jsonPath().getString("firstname"),
                    booking.firstname);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 4, enabled = false)
    public void partialUpdateBooking()
    {
        String file = FileUtils.getDataFile("herokuapp", "herokuapp", "AppData");

        List<AppModel.PartialUpdateBookingModel> data =
                JsonUtils.convertJsonListDataModel(
                        file,
                        "partialUpdateBooking",
                        AppModel.PartialUpdateBookingModel.class);

        for (AppModel.PartialUpdateBookingModel booking : data)
        {
            Response response =
                    HerokuappEndPoints.partialUpdateBooking(booking);
            response.then().log().all();
            System.out.println(response.statusCode());
            response.then().statusCode(200);

            Assert.assertEquals(
                    response.jsonPath().getString("firstname"),
                    booking.firstname);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void deleteBooking()
    {
        Response response =
                HerokuappEndPoints.deleteBooking();

        response.then().statusCode(201);
    }
}