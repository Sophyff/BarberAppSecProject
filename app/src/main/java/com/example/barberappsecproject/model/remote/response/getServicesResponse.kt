package com.example.barberappsecproject.model.remote.response

import com.google.gson.annotations.SerializedName

data class getServicesResponse(
    val services: Services,
    val status: Int
)

data class Services(
    @SerializedName("Beard styles")
    val Beardstyles: List<Beardstyle>,
    @SerializedName("Combo Offers")
    val ComboOffers: List<ComboOffer>,
    @SerializedName("Hair colors")
    val Haircolors: List<Haircolor>,
    @SerializedName("Haircuts")
    val Haircuts: List<Haircut>,
    @SerializedName("Head Massage")
    val HeadMassage: List<HeadMassage>,
    @SerializedName("Massages & Spa")
    val MassagesSpa: List<MassagesSpa>,
    @SerializedName("Official looks")
    val Official_looks: List<Officiallook>,

    @SerializedName("Shaves")
    val Shaves: List<Shave>,

    @SerializedName("facial")
    val facial: List<Facial>
)

data class Beardstyle(
    @SerializedName("cost")
    val cost: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("serviceId")
    val serviceId: String,
    @SerializedName("serviceName")
    val serviceName: String,
    @SerializedName("servicePic")
    val servicePic: String
)

data class ComboOffer(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)

data class Haircolor(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)

data class Haircut(
    @SerializedName("cost")
    val cost: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("serviceId")
    val serviceId: String,
    @SerializedName("serviceName")
    val serviceName: String,
    @SerializedName("servicePic")
    val servicePic: String
)

data class HeadMassage(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)

data class MassagesSpa(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)

data class Officiallook(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)

data class Shave(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)

data class Facial(
    val cost: String,
    val duration: String,
    val serviceId: String,
    val serviceName: String,
    val servicePic: String
)