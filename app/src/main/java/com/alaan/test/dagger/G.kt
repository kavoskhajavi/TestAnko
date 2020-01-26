package com.alaan.test.dagger
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class G : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

       return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}