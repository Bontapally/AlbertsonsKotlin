package com.example.albertsonsinterview.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    private fun setupRestClient(baseUrl: String) {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        apiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    companion object {
        private var apiService: APIService? = null
        private var restClient: APIClient? = null
        private val instance: APIClient?
            get() {
                if (restClient == null) {
                    synchronized(APIClient::class.java) {
                        if (restClient == null) {
                            restClient = APIClient()
                        }
                    }
                }
                return restClient
            }

        @kotlin.jvm.JvmStatic
        fun getApiService(baseUrl: String): APIService? {
            instance!!.setupRestClient(baseUrl)
            return apiService
        }
    }
}