package com.example.albertsonsinterview.models

import com.example.albertsonsinterview.models.Variations
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class LongForm(
    @field:Expose @field:SerializedName("lf") var longForm: String,
    @field:Expose @field:SerializedName(
        "freq"
    ) var freq: Int,
    @field:Expose @field:SerializedName("since") var since: Int,
    variations: List<Variations>?
) {

    @SerializedName("vars")
    @Expose
    var vars: List<Variations>? = null

    init {
        vars = variations
    }
}