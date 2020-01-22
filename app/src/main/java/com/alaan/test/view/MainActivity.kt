package com.alaan.test.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import com.alaan.test.R.id
import com.alaan.test.viewmodel.MainViewModel
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    var mainViewModel:MainViewModel? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainAvtivityUI(0).setContentView(this)

        moveView()
        initViewModel()

    }


    fun initViewModel(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    fun viewChangeOrientation(orientation:Int){

        MainAvtivityUI(orientation).setContentView(this)
        moveView()
    }


    @SuppressLint("ClickableViewAccessibility")
    fun moveView(){

        val button = find<Button>(id.vertical)
        val listener = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {

                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }

            true

        })

        button.setOnTouchListener(listener)
    }
}