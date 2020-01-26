package com.alaan.test.dagger
import com.alaan.test.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector
    abstract fun getMainActivity(): MainActivity


}
