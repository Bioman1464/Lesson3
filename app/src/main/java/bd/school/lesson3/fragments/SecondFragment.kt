package bd.school.lesson3.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bd.school.lesson3.R
import kotlin.random.Random

class SecondFragment : Fragment() {

    val TAG = "SecondFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Attached")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "View Created")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Resume")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = view.findViewById<TextView>(R.id.title)
        title.text = Random.nextInt(100).toString()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Paused")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "View Destroyed")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "Detached")
    }
}