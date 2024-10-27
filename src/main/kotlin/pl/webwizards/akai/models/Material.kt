package pl.webwizards.akai.models

import com.google.gson.annotations.SerializedName

data class Material(
    @SerializedName("Typ")
    val typ: String,
    @SerializedName("Masa")
    val masa: String,
    @SerializedName("Czystość")
    val czystosc: String,
    @SerializedName("Barwa")
    val barwa: String,
    @SerializedName("Pochodzenie")
    val pochodzenie: String,
    @SerializedName("Właściciel")
    val wlasciciel: String
)