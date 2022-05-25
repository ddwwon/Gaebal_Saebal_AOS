package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton


class LogWriteFragment : Fragment()  {

    var activity: MainActivity? = null

    // onAttach, onDetach: clicklistener를 사용하기 위해서 필요요요요
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity() as MainActivity
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_log_write, container, false)

        val github_btn = view.findViewById<AppCompatButton>(R.id.github)
        github_btn.setOnClickListener {
            activity?.onFragmentChange(3)
        }

        val boj_btn = view.findViewById<AppCompatButton>(R.id.baekjoon)
        boj_btn.setOnClickListener{
            activity?.onFragmentChange(4)
        }

        val pic_btn = view.findViewById<AppCompatButton>(R.id.picture_btn)
        pic_btn.setOnClickListener {
            activity?.onFragmentChange(5)
        }

        val back_btn = view.findViewById<ImageButton>(R.id.back_btn)
        back_btn.setOnClickListener {
            activity?.onFragmentChange(6)
        }
        return view
    }
}