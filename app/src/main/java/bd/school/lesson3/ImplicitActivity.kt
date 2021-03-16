package bd.school.lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_implicit.*

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val intent = intent
        val type = intent.type
        val action = intent.action

        if (action == Intent.ACTION_SEND && type != null) {
            tv1.text = type.toString()
            tv2.text = action.toString()
            if (type == "text/plain") {
                val message = intent.getStringExtra(Intent.EXTRA_TEXT)
                message.let {
                    tv3.text = it.toString()
                }
            }
        }
    }
}