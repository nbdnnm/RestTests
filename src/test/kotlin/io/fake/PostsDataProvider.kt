package io.fake

import org.testng.annotations.DataProvider

class PostsDataProvider {

    @DataProvider(name = "posts")
    fun postsDataProvider() = arrayOf(1, 2, 3, 4)

}

