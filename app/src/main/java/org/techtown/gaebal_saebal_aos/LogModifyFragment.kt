package org.techtown.gaebal_saebal_aos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout

class LogModifyFragment : Fragment() {

    val activity : MainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_modify, container, false)

        val baekjoon_btn = view.findViewById<AppCompatButton>(R.id.baekjoon_btn)
        val baekjoon_view = view.findViewById<ConstraintLayout>(R.id.baekjoon_view)
        val picture_framelayout = view.findViewById<FrameLayout>(R.id.picture_framelayout)
        picture_framelayout.visibility = View.GONE

        baekjoon_view.visibility = View.VISIBLE
        baekjoon_btn.visibility = View.GONE

        val log_modify_register_btn = view.findViewById<Button>(R.id.log_modify_register_btn)
        log_modify_register_btn.setOnClickListener {
            activity?.onFragmentChange("MyLogFragment")
        }

        return view
    }

}