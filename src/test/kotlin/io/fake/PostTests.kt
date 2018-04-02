package io.fake

import io.fake.objects.Post
import io.restassured.RestAssured.get
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.greaterThan
import org.testng.annotations.Test

class PostTests {

    @Test
    fun getPosts() {
        val posts = get("/posts").jsonPath().getList("", Post::class.java)

        assertThat(posts.size, greaterThan(99))
    }
}