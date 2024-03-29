package com.example.testott.common

import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("totla_pages") val pages: Int,
    @SerializedName("totla_results") val results: Int
) {}