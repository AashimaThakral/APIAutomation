package manager.Maps;

import java.util.List;
import io.restassured.response.Response;
import pojo.request.Map.AddPlaceRequest;
import pojo.request.Map.Location;
import utilities.CommonApi;
import constants.EndPoints;
import com.google.gson.Gson;

public class AddPlaceManager extends EndPoints{

    AddPlaceRequest addPlaceReq = new AddPlaceRequest();
    CommonApi apiRequest = new CommonApi();
    Location location = new Location();

    public String requestBody(Double lat, Double lng, Integer accuracy, String name, String phoneNumber, String address, List<String> types, String website, String language) {
        location.setLat(lat);
        location.setLng(lng);
        addPlaceReq.setLocation(location);
        addPlaceReq.setAccuracy(accuracy);
        addPlaceReq.setName(name);
        addPlaceReq.setPhoneNumber(phoneNumber);
        addPlaceReq.setAddress(address);
        addPlaceReq.setTypes(types);
        addPlaceReq.setWebsite(website);
        addPlaceReq.setLanguage(language);
        String body = new Gson().toJson(addPlaceReq);
        return body;
    }

    public Response addPlaceRequest(String serverIp, String body) {
        Response result = apiRequest.requestMethod(serverIp +  addPlace, body, "POST");
        return result;
    }
    
}
