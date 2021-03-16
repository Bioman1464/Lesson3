package bd.school.lesson3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        titleTv.setOnClickListener(this)
        cancelButton.setOnClickListener(this)

        val intent = intent
        val extra = intent.extras

        extra?.getString("hello", "Hello").let {
            titleTv.text = it
        }

        val user = extra?.getParcelable<User>("ivan")
        user.let {
            cancelButton.text = it?.name.toString()
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when(v?.id) {
            R.id.titleTv -> {
                intent.putExtra("message", "Hello")
                setResult(Activity.RESULT_OK, intent)
            }
            R.id.cancelButton -> {
                intent.putExtra("message", "Canceled")
                setResult(Activity.RESULT_CANCELED, intent)
            }
        }
        finish()
    }
}