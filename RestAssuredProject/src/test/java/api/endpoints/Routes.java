package api.endpoints;

/**
 * Swagger URI --> https://petstore.swagger.io
 * Routes class allow the testers to design the end-points for all services that are  available
 */

public class Routes {

    public static String baseURL = "https://gorest.co.in/public/v2";

//    public static String baseURL = "https://petstore.swagger.io/v2";
    //User module
    public static String postURL = baseURL + "/users";
    public static String getURL = postURL + "/{id}";

    public static String updateURL = postURL + "/{id}";
    public static String deleteURl = postURL + "/{id}";

    //Store module
        //Create Store module URL's

    //Pet module
        //Create Pet module URL's

}
