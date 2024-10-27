package pl.webwizards.akai.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("Typ")
    val typ: String,
    @SerializedName("Wartość za uncję (USD)")
    val wartoscZaUncje: Int,
    @SerializedName("Czystość")
    val czystosc: String
)