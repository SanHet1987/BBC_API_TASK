package com.utilies;

import org.aeonbits.owner.Config;

import org.aeonbits.owner.Config.Sources;

@Sources({
        "file:src/test/resources/config.Properties"
})

public interface ConfigProperties extends Config {

    @Config.Key("baseURI")

    public String getBaseURI();

    @Config.Key("basePath")

    public String getBasePath();

}
