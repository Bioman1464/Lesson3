package bd.school.lesson3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ShareCompat
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private val message = "Привет, давай дружить!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("hello", message)
            intent.putExtra("ivan", User("Ivan", 23))

            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, 22)
            }
        }

        button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Выберите приложение:"))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 22) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    Log.d("TEST", "RESULT OK")
                }
                Activity.RESULT_CANCELED -> {
                    Log.d("TEST", "RESULT CANCEL")
                }
            }
            data.let {
                Log.d("TEST", "${it?.getStringExtra("message")}")
            }
        }
        if (requestCode == 23) {
            Log.d("TEST", "ImagePicked")
        }
    }


}

@Parcelize
data class User (val name: String?, val age: Int): Parcelable {}