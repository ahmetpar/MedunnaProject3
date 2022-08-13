package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication2 {


    public static String generateToken() {


        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();


        /*
        {
  "password": "string",
  "rememberMe": true,
  "username": "string"

  expectedData.put("username", "Team63");
expectedData.put("password", "Team63.");
expectedData.put("rememberMe","true" );
}
         */

        //Set the expected data / beklenen datayi ekle
        Map<String,Object > data = new HashMap<String,Object>();
        data.put("username", "medunnateam62");
        data.put("password", "123Medunna.");
        data.put("rememberMe", true);



        //Set the url

        spec.pathParams("ilk", "api", "iki" , "authenticate");


        //Send the request and get the response / Request gonder  response elde et

        Response response    = given().spec(spec).contentType(ContentType.JSON).body(data).when().post("/{ilk}/{iki}");


//        response.prettyPrint();

        JsonPath json = response.jsonPath();

        System.out.println("token : " +json.getString("id_token"));


        return  json.getString("id_token");

    }




}
