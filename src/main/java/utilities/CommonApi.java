package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonApi {
    public Response requestMethod(String uri, String body, String requestMethod) {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri(uri).setContentType(ContentType.JSON).build();
        ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
       RequestSpecification request = given().spec(req).body(body);
        Response apiResponse = null;
       if (requestMethod == "GET"){
        apiResponse = request.when().get();
       }
       else if (requestMethod == "POST") {
        apiResponse = request.when().post();
       }
       else if (requestMethod == "PUT") {
        apiResponse = request.when().put();
       }
       else if (requestMethod == "DELETE"){
        apiResponse = request.when().delete();
       }  
       Response response = apiResponse.then().spec(res).extract().response();
       return response;
    }

    public String getResponseValue(Response response,String key)
    {
        String resp =response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public String getPropFileValue(String key, String filePath)
    {
        try {
            Properties propertyFile =new Properties();
            FileInputStream stream = null;
            stream = new FileInputStream(System.getProperty("user.dir") + filePath);
            propertyFile.load(stream);
            return propertyFile.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
