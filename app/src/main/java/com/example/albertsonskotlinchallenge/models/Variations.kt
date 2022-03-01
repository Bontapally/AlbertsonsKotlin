package com.example.albertsonsinterview.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Variations {
    @SerializedName("lf")
    @Expose
    var longForm: String? = null

    @SerializedName("freq")
    @Expose
    var freq: Int? = null

    @SerializedName("since")
    @Expose
    var since: Int? = null
}