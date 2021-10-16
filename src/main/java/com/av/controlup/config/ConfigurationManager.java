package com.av.controlup.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static Configuration configuration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }

    public static ConversionTestConfiguration conversionTestConfiguration() {
        return ConfigCache.getOrCreate(ConversionTestConfiguration.class); }

    public static TemperatureTestConfiguration temperatureTestConfiguration() {
        return ConfigCache.getOrCreate(TemperatureTestConfiguration.class); }
}
