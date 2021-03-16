package bd.school.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import bd.school.lesson3.fragments.FirstFragment
import bd.school.lesson3.fragments.SecondFragment
import bd.school.lesson3.fragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_fourth.*

class FourthActivity : AppCompatActivity() {

    val TAG = "TEST"
    var clicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, firstFragment)
            commit()
        }

        actionButton.setOnClickListener {
            when (clicks) {
                0 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        add(R.id.container, secondFragment, "second")
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Added")
                }
                1 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        detach(secondFragment)
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Detached")
                }
                2 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        attach(secondFragment)
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Attached")
                }
                3 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        supportFragmentManager.findFragmentByTag("second").let {
                            hide(supportFragmentManager.findFragmentByTag("second")!!)
                        }
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Hided")
                }
                4 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        supportFragmentManager.findFragmentByTag("second").let {
                            show(supportFragmentManager.findFragmentByTag("second")!!)
                        }
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Showed")
                }
                5 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        remove(secondFragment)
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Removed")
                }
                7 -> {
                    supportFragmentManager.beginTransaction().apply {
                        setReorderingAllowed(true)
                        replace(R.id.container, thirdFragment)
                        addToBackStack(null)
                        commit()
                    }
                    Log.d(TAG, "Replace")
                }
                else -> {
                    supportFragmentManager.popBackStack()
                    Log.d(TAG, "Backstack popped")
                }
            }
            clicks++
        }
    }


}