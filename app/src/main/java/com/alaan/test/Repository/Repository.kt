package com.alaan.outn.api


import com.alaan.outn.api.interfaces.CallBack
import com.alaan.outn.api.remote.RemoteRepository
import com.alaan.test.model.Api


class Repository : RepositoryMethod {

    private var INSTANCE: Repository? = null
    var remoteRepository: RemoteRepository? = RemoteRepository().getInstance()

  public  fun getInstance(): Repository? {
        if (INSTANCE == null) {
            synchronized(Repository::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Repository()
                }
            }
        }
        return INSTANCE
    }

    override fun getLogin(mobile: String?, callBack: CallBack<Api<Void>>) {


    }


}