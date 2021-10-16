package com.av.controlup.manager.api;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;

public class ApiManager {

    public static Double getDoubleValue(String url, String path){
        String response = get(url).asString();
        return from(response).getDouble(path);
    }
}
