package app.ocast.data.model

import com.google.gson.annotations.SerializedName

data class PodcastResponse(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent_id")
    val parent_id: Int,
    @SerializedName("podcasts")
    val podcasts: List<Podcast>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("has_next")
    val has_next: Boolean,
    @SerializedName("has_previous")
    val has_previous: Boolean,
    @SerializedName("page_number")
    val page_number: Int,
    @SerializedName("previous_page_number")
    val previous_page_number: Int,
    @SerializedName("next_page_number")
    val next_page_number: Int,
    @SerializedName("listennotes_url")
    val listennotes_url: String
)