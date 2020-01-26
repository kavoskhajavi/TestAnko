package com.alaan.test.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.alaan.test.dagger.MainViewModel
import com.alaan.test.dagger.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
     public lateinit var factory: ViewModelProviderFactory
     public lateinit var viewModel:MainViewModel

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        MainAvtivityUI(0).setContentView(this)
        moveView()





        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)

        val a = metrics.heightPixels
        val b = metrics.widthPixels

        print("count "+a +" -----"+b)

        Log.v("DaggerTag",viewModel.name)






    }


    fun initViewModel(){
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java!!)
    }

    fun viewChangeOrientation(orientation:Int){

        MainAvtivityUI(orientation).setContentView(this)
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


