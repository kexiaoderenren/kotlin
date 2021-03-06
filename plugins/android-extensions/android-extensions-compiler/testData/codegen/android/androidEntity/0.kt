package test

import android.app.Activity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.layout.*
import kotlinx.android.extensions.*

class R {
    class id {
        companion object {
            const val login = 5
        }
    }
}

class MyEntity(override val containerView: View) : LayoutContainer

class MyActivity(): Activity() {
    val loginItem = Button(this)

    val entity = MyEntity(object : FrameLayout(this) {
        override fun findViewById(id: Int) : View? = when(id) {
            R.id.login -> loginItem
            else -> null
        }
    })

    val entity2: LayoutContainer = entity

    public fun box(): String {
        val o = if (entity.login.toString() == "Button") "O" else ""
        val k = if (entity2.login.toString() == "Button") "K" else ""
        return o + k // "OK"
    }
}

fun box(): String {
    return MyActivity().box()
}
