package api.endpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get) : https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/

public class Routes
{
    public static String BASE_URL = "https://petstore.swagger.io/v2";
    public static String BASE_URL_HEROKUAPP = "https://restful-booker.herokuapp.com/booking";
    public static String token = "https://restful-booker.herokuapp.com/auth";

    // User Module
    public static String post_url = BASE_URL + "/user"; // Create user
    public static String get_url = BASE_URL + "/user/{username}"; // Get user
    public static String update_url = BASE_URL + "/user/{username}"; // Update user
    public static String delete_url = BASE_URL + "/user/{username}"; // Delete user

    //==========================
    // Pet Module
    //==========================

    public static final String CREATE_PET = BASE_URL + "/pet";
    public static final String UPDATE_PET = BASE_URL + "/pet";
    public static final String GET_PET_BY_ID = BASE_URL + "/pet/{petId}";
    public static final String DELETE_PET = BASE_URL + "/pet/{petId}";
    public static final String FIND_PET_BY_STATUS = BASE_URL + "/pet/findByStatus";
    public static final String UPLOAD_PET_IMAGE = BASE_URL + "/pet/{petId}/uploadImage";
    public static final String UPDATE_PET_FORM = BASE_URL + "/pet/{petId}";

    //==========================
    // Store Module
    //==========================

    public static final String GET_INVENTORY = BASE_URL + "/store/inventory";
    public static final String PLACE_ORDER = BASE_URL + "/store/order";
    public static final String GET_ORDER = BASE_URL + "/store/order/{orderId}";
    public static final String DELETE_ORDER = BASE_URL + "/store/order/{orderId}";

    //==========================
    // Booking Module
    //==========================
    public static final String CREATE_TOKEN = token;
    public static final String GET_BOOKING_IDS = BASE_URL_HEROKUAPP;
    public static final String GET_BOOKING = BASE_URL_HEROKUAPP + "/{id}";
    public static final String CreateBooking = BASE_URL_HEROKUAPP;
    public static final String UpdateBooking = BASE_URL_HEROKUAPP + "/{id}";
    public static final String PartialUpdateBooking = BASE_URL_HEROKUAPP + "/{id}";
    public static final String DeleteBooking = BASE_URL_HEROKUAPP + "/{id}";
}