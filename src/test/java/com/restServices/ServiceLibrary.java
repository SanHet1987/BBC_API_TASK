package com.restServices;

import com.setup.TestSetup;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ServiceLibrary extends TestSetup {
    private Response response;
    private String path = "/RMSTest/media";

    public Response doGetRequest() {

        RestAssured.defaultParser = Parser.JSON;

        Response response = given().
                when().
                get(configProperties.getBaseURI() + configProperties.getBasePath())
                .then().extract().response();

        return response;
    }

    public void responseTime(long responseTime) {
        response = given().when().get(path).then().extract().response();
        long requestResponseTime = response.getTime();
        if (requestResponseTime < responseTime) {
            System.out.println("The response time is below 1000 milliseconds.");
        } else {
            System.out.println("The response time is not below 1000 milliseconds.");
        }
    }

    public void setIdResponse() {
        response = RestAssured.get(path);
        JsonPath jsonPath = response.jsonPath();
        String jsonArrayId = jsonPath.getString("data.id");
        if (jsonArrayId != null && jsonArrayId != " ") {
            System.out.println("The Json array id is not null or not empty String.");
        } else {
            System.out.println("The Json array id is either null or empty String ");
        }
    }

    public void setSegmentResponse() {
        response = RestAssured.get(path);
        JsonPath jsonPath = response.jsonPath();
        String jsonArraySegmentType = jsonPath.getString("data.segment_type");
        if (jsonArraySegmentType.contains("music") && jsonArraySegmentType != null) {
            System.out.println("Each Json array Segment type must contain music , not null or empty String");
        } else {
            System.out.println("Each Json array Segment type either contain music, null or empty String");
        }
    }

    public void setPrimaryTitleResponse() {
        response = RestAssured.get(path);
        JsonPath jsonPath = response.jsonPath();
        String jsonArrayPrimaryTitle = jsonPath.getString("data.title_list.primary");
        if (jsonArrayPrimaryTitle != null && jsonArrayPrimaryTitle != " ") {
            System.out.println("The Json array primary title must not null or empty");
        } else {
            System.out.println("TThe Json array primary title either contain null or empty ");
        }
    }

    public void setNowPlayingResponse() {
        response = RestAssured.get(path);
        JsonPath jsonPath = response.jsonPath();
        String jsonArrayNowPlaying = jsonPath.getString("data.offset.now_playing");
        if (jsonArrayNowPlaying.length() >= 97) {
            System.out.println("The second value is 'true'");
        } else {
            System.out.println("The second value is not 'true'");
        }
    }

    public void verifyDateHeader() {
        response = RestAssured.get(path);
        String dateHeaderValue = response.getHeader("Date");
        Assert.assertThat(dateHeaderValue, Matchers.containsString(" Jul 2023"));
    }
}
