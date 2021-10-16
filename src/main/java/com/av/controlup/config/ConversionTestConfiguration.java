package com.av.controlup.config;

import com.av.controlup.pages.ConversionHomePage;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "classpath:conversion.test.data.properties"})
public interface ConversionTestConfiguration extends Config {

    @Key("conversion.url")
    String conversionUrl();

    String weightValue();
    String weightExpectedValue();
    ConversionHomePage.CONVERSION_TYPE weightType();

    String lengthValue();
    String lengthExpectedValue();
    ConversionHomePage.CONVERSION_TYPE lengthType();

    String tempValue();
    String tempExpectedValue();
    ConversionHomePage.CONVERSION_TYPE tempType();

}
