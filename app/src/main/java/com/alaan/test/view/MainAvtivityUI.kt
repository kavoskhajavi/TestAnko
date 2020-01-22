package com.alaan.test.view


import android.graphics.Color
import android.widget.LinearLayout
import com.alaan.test.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.button
import org.jetbrains.anko.margin
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

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
                setText("Move")
                backgroundColor = Color.RED

            }.lparams(width  = wrapContent , height = wrapContent) {

                margin = 20

            }



            button{
                setText("VERTICAL")
                backgroundColor = Color.BLUE
                onClick {
                    ui.owner.viewChangeOrientation(LinearLayout.VERTICAL)
                }
            }.lparams(width  = wrapContent , height = wrapContent) {
                margin = 20

            }

            button{

                setText("HORIZONTAL")
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