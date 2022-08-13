package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.jxc.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Room1;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication2.generateToken;

public class RoomSteps {


    Response response;


    Room1 [] rooms ;

    @Given("kullanici roomlar icin get request yapar")
    public void kullanici_roomlar_icin_get_request_yapar() {

       response = given().headers(
               "Authorization",
               "Bearer " + generateToken(),
               "Content-Type",
               ContentType.JSON,
               "Accept",
               ContentType.JSON).when().get(ConfigReader.getProperty("room_endpoint"));

       response.then().assertThat().statusCode(200);

//       response.prettyPrint();



    }



    @Given("kullanici gelen room datayi deserialize eder")
    public void kullanici_gelen_room_datayi_deserialize_eder() throws Exception{

        ObjectMapper obj = new ObjectMapper();

        rooms = obj.readValue(response.asString(), Room1[].class);


        System.out.println("kac tane room obejesi var? " +rooms.length);

        for(int i=0; i < rooms.length; i++){

            System.out.println(rooms[i].getDescription());
            System.out.println(rooms[i].getRoomNumber());

        }

    }



    @Then("kullanici room datasini validate eder")
    public void kullanici_room_datasini_validate_eder() {

    }


}
