package app.ocast.data.model

import com.google.gson.annotations.SerializedName

data class Podcast(

    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("listennotes_url")
    val listennotes_url: String,
    @SerializedName("total_episodes")
    val total_episodes: Int,
    @SerializedName("explicit_content")
    val explicit_content: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("itunes_id")
    val itunes_id: Int,
    @SerializedName("rss")
    val rss: String,
    @SerializedName("latest_pub_date_ms")
    val latest_pub_date_ms: Long,
    @SerializedName("earliest_pub_date_ms")
    val earliest_pub_date_ms: Long,
    @SerializedName("language")
    val language: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("is_claimed")
    val is_claimed: Boolean,
    @SerializedName("email")
    val email: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>

//    @SerializedName("extra")
//    val extra: Extra,
//    @SerializedName("looking_for")
//    val looking_for: Looking_for,
)