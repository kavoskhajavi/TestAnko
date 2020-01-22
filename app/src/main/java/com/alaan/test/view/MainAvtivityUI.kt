package com.alaan.test.view


import android.graphics.Color
import android.widget.LinearLayout
import com.alaan.test.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAvtivityUI(orientation1:Int) :AnkoComponent<MainActivity> {

    var orientation1:Int?
    init {
        this.orientation1 = orientation1
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui)  {


        verticalLayout{

            id = R.id.idParent
            backgroundColor = Color.WHITE
            if (orientation1 == 1){
                orientation = LinearLayout.HORIZONTAL
            }else {
                orientation = LinearLayout.VERTICAL
            }



            button{
                id = R.id.vertical
                setText(R.string.MOVE)
                backgroundColor = Color.RED
                textColor = Color.WHITE

            }.lparams(width  = wrapContent , height = wrapContent) {

                margin = 20

            }



            button{
                setText(R.string.VERTICAL)
                backgroundColor = Color.BLUE
                textColor = Color.WHITE
                onClick {
                    ui.owner.viewChangeOrientation(LinearLayout.VERTICAL)
                }
            }.lparams(width  = wrapContent , height = wrapContent) {
                margin = 20

            }

            button{

                setText(R.string.HORIZONTAL)
                backgroundColor = Color.CYAN
                onClick {
                    ui.owner.viewChangeOrientation(LinearLayout.HORIZONTAL)

                }

            }.lparams(width  = wrapContent , height = wrapContent) {
                margin = 20
            }
        }


    }

}