package com.av.controlup.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.openqa.selenium.By;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "classpath:temperature.test.data.properties"})
public interface TemperatureTestConfiguration extends Config {

    @Key("weather.url")
    String weatherUrl();

    @Key("api.url")
    String apiUrl();

    @Key("zip.code")
    String zipCode();

    @Key("area.name")
    String areaName();

    @Key("grade.type")
    String gradeType();
}
