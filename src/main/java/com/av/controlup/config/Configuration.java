package com.av.controlup.config;

import com.av.controlup.pages.ConversionHomePage;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "classpath:general.test.properties"})
public interface Configuration extends Config {

    @DefaultValue("false")
    Boolean headless();
}
