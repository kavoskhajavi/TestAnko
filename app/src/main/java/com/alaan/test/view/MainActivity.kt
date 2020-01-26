package com.alaan.test.view

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProviders
import com.alaan.test.dagger.MainViewModel
import com.alaan.test.dagger.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.setContentView
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    public lateinit var factory: ViewModelProviderFactory
    public lateinit var viewModel:MainViewModel

    val metrics = DisplayMetrics()


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()

        val display = windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = resources.displayMetrics.density
        val dpHeight = outMetrics.heightPixels / density
        val dpWidth = outMetrics.widthPixels / density

        MainAvtivityUI(0,dpHeight.toInt(),dpWidth.toInt()).setContentView(this)

        moveView()







    }


    fun initViewModel(){
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java!!)
    }

    fun viewChangeOrientation(orientation:Int,button: Button,ln:LinearLayout){

        ln.backgroundColor = Color.YELLOW

       // ln.addView(button)
       // ln.removeAllViews()
       // ln.addView(button)

        moveView()

    }


    @SuppressLint("ClickableViewAccessibility")
    fun moveView(){

//        val button = find<Button>(id.vertical)
//        val listener = View.OnTouchListener(function = {view, motionEvent ->
//
//            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
//
//                view.y = motionEvent.rawY - view.height/2
//                view.x = motionEvent.rawX - view.width/2
//            }
//
//            true
//
//        })
//
//        button.setOnTouchListener(listener)
    }
}



