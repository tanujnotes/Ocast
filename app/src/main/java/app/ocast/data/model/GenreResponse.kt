package app.ocast.data.model

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    val results: List<Genre>
)