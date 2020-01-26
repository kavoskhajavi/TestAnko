package com.alaan.test.view


import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.ColorLong
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.forEach
import androidx.core.view.marginLeft
import androidx.core.view.marginTop
import com.alaan.test.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAvtivityUI(orientation1: Int,heigh: Int, with: Int) : AnkoComponent<MainActivity> {

    var orientation1: Int?
    var count = 1
    var previousWith = 0
    var previousHeigh = 0


    var withInput: Int
    var heigh: Int

    init {

        this.orientation1 = orientation1
        this.withInput = with/120
        this.heigh = heigh/50
    }


    @SuppressLint("ResourceType")
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {


        constraintLayout {

            id = 0

            buttonCustomView(this,"bouttn"+count,Color.YELLOW)

                .lparams(width = dip(120),height = dip(100)){

                 topToTop = 0
                 startToStart = 0
                 this.topMargin = 5
                 this.leftMargin = 2


            }.onClick {

                button{
                    text = "button"
                }.lparams(width = dip(120),height = wrapContent){

                    if (orientation1 == 1){

                        startToStart = 0
                        topToTop = 0

                         this.topMargin = if (previousHeigh==0) if (previousWith == 0) 135 else 0 else previousHeigh*130
                         this.leftMargin = if (previousWith == 0 ) 0 else (dip(previousWith*130)+10)

                         previousHeigh = previousHeigh+1

                        if (previousHeigh > heigh){
                            previousWith = previousWith +1
                            previousHeigh = 0
                        }



                    }else {

                        startToStart = 0
                        topToTop = 0

                        this.topMargin = if (previousHeigh == 0) 0 else previousHeigh*125
                        this.leftMargin =  if (previousWith == 0) if (previousHeigh == 0) dip(125) else 0 else dip((previousWith*120)+10)

                        previousWith = previousWith+1

                        if (previousWith > withInput){
                            previousWith = 0
                            previousHeigh = previousHeigh +1
                        }


                    }
                }
            }

        }

    }

    @SuppressLint("ResourceType")
    fun buttonCustomView(
        ui: @AnkoViewDslMarker ConstraintLayout,
        title: String,
        color: Int
    ): Button {

        return ui.button {
            text = title
            id = 100
            textColor = Color.WHITE
            backgroundColor = color
        }
    }


}

