package com.scrolltest.api.tests.helpers;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;

import com.scrolltest.api.constants.EndPoints;
import com.scrolltest.api.model.Person;
import com.scrolltest.api.utils.ConfigManager;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PersonServiceHelper {

    //We need to read the config variable
    //Rest Assured About the URL,parte
    //make a get request on this url and send the data to TestGETPerson

    private  static  final String BaseUrl = ConfigManager.getInstance().getString("base_url");
    private  static  final String port = ConfigManager.getInstance().getString("port");

    public PersonServiceHelper(){

        RestAssured.baseURI = BaseUrl;
        RestAssured.port = Integer.parseInt(port);
        RestAssured.useRelaxedHTTPSValidation();

}
    public List<Person>getAllPersons(){
    	Response response = RestAssured
    						.given().log().all()
    						.contentType(ContentType.JSON)
    						.get(EndPoints.GET_ALL_PERSON)
    						.andReturn();
    	Type type = new TypeReference<List<Person>>() {}.getType();

        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
          List<Person> pList = response.as(type);
       return pList;
    }
    
    public Response createPerson(){
        Person person = new Person();
        person.id("14");
        person.setTitle("json-server14");
        person.setAuthor("Anil");
        

        //need to make a post call
        Response response =  RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .post(EndPoints.CREATE_PERSON)
                .andReturn();   
        assertEquals("Created",HttpStatus.SC_CREATED,"Created");

        return response;

    }
    
    public Response updatePerson(Integer id){
        Person person = new Person();
        person.id("13");
        person.setTitle("json-server13");
        person.setAuthor("Sagar");
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .when().body(person)
                .post(EndPoints.UPDATE_PERSON)
                .andReturn();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }
    	
    public Response deletePerson(Integer id){
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .log().all()
                .when().delete(EndPoints.GET_SINGLE_PERSON)
                .andReturn();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }

}
