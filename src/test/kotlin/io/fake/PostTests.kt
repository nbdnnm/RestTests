package io.fake

import io.fake.objects.Post
import io.restassured.RestAssured.get
import io.restassured.RestAssured.given
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.greaterThan
import org.testng.annotations.Test

class PostTests {

    @Test
    fun `get posts`() {
        val posts = get("/posts").jsonPath().getList("", Post::class.java)

        assertThat(posts.size, greaterThan(99))
    }

    @Test
    fun `add post`() {
        val post = mapOf("userId" to 200, "title" to "some title", "body" to "some body")

        val createdPost = given().body(post)
                .`when`().post("/posts")
                .then().extract().body().`as`(Post::class.java)

        assertThat(createdPost.body, equalTo("some body"))
    }

    @Test(dataProvider = "posts", dataProviderClass = PostsDataProvider::class)
    fun `get post from data provider`(post: Int) {
        val actualPost = get("/posts/" + post).then().extract().body().`as`(Post::class.java)

        assertThat(actualPost.id, equalTo(post))
    }

}