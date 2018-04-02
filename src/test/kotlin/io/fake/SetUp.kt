package io.fake

import io.restassured.RestAssured
import org.testng.annotations.BeforeSuite

class SetUp {

    @BeforeSuite
    fun setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"
    }
}