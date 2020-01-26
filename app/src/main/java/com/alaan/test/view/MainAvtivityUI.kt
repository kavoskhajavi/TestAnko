package com.alaan.test.view


import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.alaan.test.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAvtivityUI(orientation1: Int, heigh: Int, with: Int,countInput:Int) : AnkoComponent<MainActivity> {

    var orientation1: Int?
    var previousWith = 0
    var previousHeigh = 0
    var countInput = 0


    var withInput: Int
    var heigh: Int

    init {

        this.orientation1 = orientation1
        this.withInput = with / 120
        this.heigh = heigh / 50
        this.countInput = countInput
    }


    @SuppressLint("ResourceType")
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {


        constraintLayout {

            id = 0
            buttonCustomView(this, "Add", Color.BLUE)

                .lparams(width = dip(112), height = dip(40)) {

                    topToTop = 0
                    startToStart = 0
                    this.topMargin = 12
                    this.leftMargin = 10

                }.onClick {

                    button {
                        text = "button"
                    }.lparams(width = dip(120), height = wrapContent) {

                        countInput = countInput+1
                        if (orientation1 == 1) {

                            startToStart = 0
                            topToTop = 0

                            this.topMargin =
                                if (previousHeigh == 0) if (previousWith == 0) dip(150) else 0 else if (previousWith == 0)
                                    dip((previousHeigh * 50) + 150) else dip(previousHeigh * 50)

                            this.leftMargin =
                                if (previousWith == 0) 0 else (dip(previousWith * 130) + 10)

                            previousHeigh = previousHeigh + 1

                            if (previousHeigh >= if (previousHeigh == 0) heigh - 3 else heigh) {
                                previousWith = previousWith + 1
                                previousHeigh = 0
                            }


                        } else {

                            startToStart = 0
                            topToTop = 0

                            this.topMargin =
                                if (previousHeigh == 0) dip(50) else dip(previousHeigh * 50)+120

                            this.leftMargin = dip(previousWith * 120)
                            previousWith = previousWith + 1

                            if (previousWith >= withInput) {
                                previousWith = 0
                                previousHeigh = previousHeigh + 1
                            }


                        }
                    }
                }



            buttonCustomView(this, resources.getString(R.string.VERTICAL), Color.RED)
                .lparams(width = dip(112), height = dip(40)) {
                    topToTop = 0
                    startToStart = 0

                    if (orientation1 == 1) {
                        this.topMargin = dip(50)
                        this.leftMargin = 10
                    }else {
                        this.topMargin = 9
                        this.leftMargin = dip(112+5)
                    }
                }.onClick {

                    ui.owner.viewChangeOrientation(countInput, 1)

                }


            buttonCustomView(this, resources.getString(R.string.HORIZONTAL), Color.DKGRAY)
                .lparams(width = dip(112), height = dip(40)) {
                    topToTop = 0
                    startToStart = 0
                    if (orientation1 == 1) {
                        this.topMargin = dip(100)
                        this.leftMargin = 10
                    }else {
                        this.topMargin = 9
                        this.leftMargin = dip(112*2+10)
                    }
                }.onClick {
                    ui.owner.viewChangeOrientation(countInput, 0)
                }

            if (countInput > 0) {

                for (x in 1..countInput) {


                    button {
                        text = "button"
                    }.lparams(width = dip(120), height = wrapContent) {

                        if (orientation1 == 1) {

                            startToStart = 0
                            topToTop = 0

                            this.topMargin =
                                if (previousHeigh == 0) if (previousWith == 0) dip(150) else 0 else if (previousWith == 0)
                                    dip((previousHeigh * 50) + 150) else dip(previousHeigh * 50)

                            this.leftMargin =
                                if (previousWith == 0) 0 else (dip(previousWith * 130) + 10)

                            previousHeigh = previousHeigh + 1

                            if (previousHeigh > if (previousHeigh == 0) heigh - 3 else heigh) {
                                previousWith = previousWith + 1
                                previousHeigh = 0
                            }


                        } else {

                            startToStart = 0
                            topToTop = 0

                            this.topMargin =
                                if (previousHeigh == 0) dip(50) else dip(previousHeigh * 50)+120

                            this.leftMargin = dip(previousWith * 120)
                            previousWith = previousWith + 1

                            if (previousWith > withInput) {
                                previousWith = 0
                                previousHeigh = previousHeigh + 1
                            }


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

