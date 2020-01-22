package com.alaan.test.Repository.service


import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS

class ApiConnection private constructor() {
    private var serviceApi: ServiceApi? = null
    private var retrofit: Retrofit?
    /*service*/
    val service: ServiceApi?
        get() {
            if (serviceApi == null) {
                val behavior = NetworkBehavior.create()
                val mockRetrofit = MockRetrofit.Builder(retrofit)
                    .networkBehavior(behavior)
                    .build()
                val delegate = mockRetrofit.create(ServiceApi::class.java)
                behavior.setDelay(1000, MILLISECONDS)
                serviceApi = retrofit!!.create(ServiceApi::class.java) /*service*/
            }
            return serviceApi
        }

    private fun create(): Retrofit? {


        val oktHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.MINUTES)
            .writeTimeout(30, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.MINUTES)


          retrofit = Retrofit.Builder()
            .client(oktHttpClient.build())
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun clear() {
        INSTANCE = null
        retrofit = null
        serviceApi = null
    }

    companion object {
        @Volatile
        private var INSTANCE: ApiConnection? = null

        val instance: ApiConnection?
            get() {
                if (INSTANCE == null) {
                    synchronized(ApiConnection::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = ApiConnection()
                        }
                    }
                }
                return INSTANCE
            }
    }

    init {
        retrofit = create()
    }
}
