package com.alaan.test.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.lifecycle.ViewModelProviders
import com.alaan.test.viewmodel.MainViewModel
import com.alaan.test.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    public lateinit var factory: ViewModelProviderFactory
    public lateinit var viewModel: MainViewModel
    var dpHeight = 0F
    var dpWidth = 0F

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()

        val display = windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = resources.displayMetrics.density
         dpHeight = outMetrics.heightPixels / density
         dpWidth = outMetrics.widthPixels / density

        // dpHeight.toInt(),dpWidth.toInt() calculate screen phone
        MainAvtivityUI(0,dpHeight.toInt(),dpWidth.toInt(),0).setContentView(this)



    }


    fun initViewModel(){
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java!!)
    }

    //This method gets clicked on the button
    // count field for rest activity
    fun viewChangeOrientation(count:Int,orientation: Int){

        MainAvtivityUI(orientation,dpHeight.toInt(),dpWidth.toInt(),count).setContentView(this)

    }

}



