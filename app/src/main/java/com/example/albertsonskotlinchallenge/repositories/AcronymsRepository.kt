package com.example.albertsonskotlinchallenge.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.albertsonsinterview.models.AcronymResponse
import com.example.albertsonsinterview.network.APIClient.Companion.getApiService
import com.example.albertsonsinterview.network.APIConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AcronymsRepository {
    private val acronymResponseLiveData: MutableLiveData<List<AcronymResponse?>?> = MutableLiveData()
    fun searchVolumes(keyword: String?) {
        getApiService(APIConstants.BOOK_SEARCH_SERVICE_BASE_URL)
            ?.getAcronyms(keyword)
            ?.enqueue(object : Callback<List<AcronymResponse?>?> {
                override fun onResponse(
                    call: Call<List<AcronymResponse?>?>,
                    response: Response<List<AcronymResponse?>?>
                ) {
                    if (response.code() == 404) {
                        acronymResponseLiveData.postValue(null)
                    }
                    if (response.body() != null) {
                        acronymResponseLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<AcronymResponse?>?>, t: Throwable) {
                    acronymResponseLiveData.postValue(null)
                }
            })
    }

    fun getAcronymResponseLiveData(): LiveData<List<AcronymResponse?>?> {
        return acronymResponseLiveData
    }

}