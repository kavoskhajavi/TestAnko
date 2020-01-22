package com.alaan.test.Repository.service

import com.alaan.test.model.Api
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ServiceApi {


    @FormUrlEncoded
    @POST("login")
    fun login(@Field("mobile") mobile: String?): Call<Api<Void>>

}