package io.fake

import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import org.testng.annotations.BeforeSuite

class SetUpFramework {

    @BeforeSuite
    fun setUp() {
        val reqSpec = RequestSpecBuilder()
                .addFilter(AllureRestAssured())
                .setContentType("application/json")
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build()
        RestAssured.requestSpecification = reqSpec

    }
}