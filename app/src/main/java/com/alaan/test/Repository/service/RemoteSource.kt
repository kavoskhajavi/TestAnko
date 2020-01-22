package com.alaan.outn.api.remote

import com.alaan.outn.api.interfaces.CallBack
import com.alaan.test.model.Api


interface RemoteSource {

    fun getLogin(mobile: String?,callBack: CallBack<Api<Void>>)



}

