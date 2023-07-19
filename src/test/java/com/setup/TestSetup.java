package com.setup;

import com.utilies.ConfigProperties;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;

public class TestSetup {

    public static ConfigProperties configProperties;


    @Before
    public void setUp() {

        configProperties = ConfigFactory.create(ConfigProperties.class);

        RestAssured.baseURI = configProperties.getBaseURI();
        RestAssured.basePath = configProperties.getBasePath();
    }

    @After
    public void tearDown() {

    }

}
