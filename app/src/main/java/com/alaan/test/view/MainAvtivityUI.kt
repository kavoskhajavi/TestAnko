package com.alaan.test.view


import android.annotation.SuppressLint
import android.graphics.Color
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.forEach
import com.alaan.test.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAvtivityUI(orientation1: Int) : AnkoComponent<MainActivity> {

    var orientation1: Int?
    var arrButton = mutableListOf<Button>()

    init {
        this.orientation1 = orientation1

    }


    @SuppressLint("ResourceType")
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {




        verticalLayout {

            id = R.id.idParent
            backgroundColor = Color.WHITE

            orientation = if (orientation1 == 1) LinearLayout.HORIZONTAL else LinearLayout.VERTICAL



            buttonCustomView(this, resources.getString(R.string.MOVE), Color.RED)
                .lparams(width = wrapContent, height = wrapContent) {
                    margin = 20

                }.onClick {

                    arrButton.add( buttonCustomView(this@verticalLayout, "button : "+arrButton.size, Color.BLUE).lparams(
                        wrapContent,
                        wrapContent
                    ) {
                        margin = 10
                    })

                }


            buttonCustomView(this, resources.getString(R.string.VERTICAL), Color.BLUE)
                .lparams(width = wrapContent, height = wrapContent) {
                    margin = 20

                }.onClick {
                    ui.owner.viewChangeOrientation(0)
                }


            buttonCustomView(this, resources.getString(R.string.HORIZONTAL), Color.CYAN)
                .lparams(width = wrapContent, height = wrapContent) {
                    margin = 20

                }.onClick {
                    ui.owner.viewChangeOrientation(1)
                }

        }

    }

    fun buttonCustomView(
        ui: @AnkoViewDslMarker _LinearLayout,
        title: String,
        color: Int
    ): Button {

        return ui.button {
            text = title
            textColor = Color.WHITE
            backgroundColor = color
        }
    }


    fun linearCustomer(ui: @AnkoViewDslMarker _LinearLayout, array: List<Button>):LinearLayout{

        return ui.verticalLayout{
            orientation = LinearLayout.HORIZONTAL
            lparams(width = wrapContent,height = wrapContent)
        }

    }

}

