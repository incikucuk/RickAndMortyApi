package com.incikucuk.testapi.network.response

import com.incikucuk.testapi.Location
import com.incikucuk.testapi.Origin

data class GetCharacterByIdResponse(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)