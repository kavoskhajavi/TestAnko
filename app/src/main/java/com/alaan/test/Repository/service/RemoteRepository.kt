package com.alaan.outn.api.remote


import com.alaan.outn.api.interfaces.CallBack
import com.alaan.outn.api.interfaces.CallBacks
import com.alaan.test.Repository.service.ApiConnection
import com.alaan.test.model.Api
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class RemoteRepository:RemoteSource {

    private var INSTANCE: RemoteRepository? = null
    private var apiConnection: ApiConnection = ApiConnection.instance!!

    fun getInstance(): RemoteRepository? {
        if (INSTANCE == null) {
            synchronized(RemoteRepository::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = RemoteRepository()
                }
            }
        }
        return INSTANCE
    }

    protected fun <T> makeCallback(cb: CallBacks<T>): Callback<T>? {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                  cb.onSuccess(response.body()!!)

                } else {

                    val message: String?
                    message = try {
                        response.errorBody()!!.string()
                    } catch (ex: java.lang.Exception) {
                        response.message()
                    }
                    cb.onFail(java.lang.Exception(message),response.code())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {

                val exception = Exception(t.message, t)
                cb.onFail(exception,100)
            }
        }
    }




    override
    fun getLogin(mobile: String?, callBack: CallBack<Api<Void>>) {

       apiConnection.service!!.login(mobile).enqueue(makeCallback(callBack))

    }


}


