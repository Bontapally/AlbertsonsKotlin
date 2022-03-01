package com.example.albertsonsinterview.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.albertsonsinterview.models.LongForm

class AcronymResponse {
    @SerializedName("sf")
    @Expose
    var shortForm: String? = null

    @SerializedName("lfs")
    @Expose
    var longForms: List<LongForm>? = null
        private set

    fun setLfs(longForms: List<LongForm>?) {
        this.longForms = longForms
    }
}