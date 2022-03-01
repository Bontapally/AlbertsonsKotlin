package com.example.albertsonskotlinchallenge.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.albertsonsinterview.models.AcronymResponse
import com.example.albertsonskotlinchallenge.repositories.AcronymsRepository

class AcronymsViewModel(application: Application) : AndroidViewModel(application) {
    private val acronymsRepository: AcronymsRepository = AcronymsRepository()
    private var volumesResponseLiveData: LiveData<List<AcronymResponse?>?>? = null

    fun getAcronymsResponseLiveData(keyword: String?): LiveData<List<AcronymResponse?>?> {
        acronymsRepository.searchVolumes(keyword)
        volumesResponseLiveData = acronymsRepository.getAcronymResponseLiveData()
        return volumesResponseLiveData as LiveData<List<AcronymResponse?>?>
    }

}