package pojo.request.Map;
import java.util.List;

public class AddPlaceRequest {

    private Location location;
    private Integer accuracy;
    private String name;
    private String address;
    private String website;
    private String language;
    private List<String> types;
    private String phone_number;
    
    public void setLocation(Location location){
        this.location = location;
    }

    public void setAccuracy(Integer accuracy){
        this.accuracy = accuracy;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTypes(List<String> types){
        this.types = types;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phone_number){
        this.phone_number = phone_number;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public void setLanguage(String language){
        this.language = language;
    }
}
