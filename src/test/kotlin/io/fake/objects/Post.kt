package io.fake.objects

import com.fasterxml.jackson.annotation.JsonProperty

data class Post(@JsonProperty("userId") val userId: Int,
                @JsonProperty("id") val id: Int,
                @JsonProperty("title") val title: String,
                @JsonProperty("body") val body: String) {
}