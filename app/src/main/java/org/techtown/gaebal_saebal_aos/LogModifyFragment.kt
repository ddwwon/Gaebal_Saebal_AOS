package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.*

class LogModifyFragment : Fragment() {

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
        val log_modify_main_text = view.findViewById<EditText>(R.id.log_modify_main_text)
        val tag_input = view.findViewById<EditText>(R.id.tag_input)
        val log_moodify_code_text = view.findViewById<EditText>(R.id.log_moodify_code_text)
        val log_modify_register_btn = view.findViewById<AppCompatButton>(R.id.log_modify_register_btn)
        val back_btn = view.findViewById<ImageButton>(R.id.modify_back_btn)

        picture_framelayout.visibility = View.GONE
        baekjoon_view.visibility = View.VISIBLE
        baekjoon_btn.visibility = View.GONE

        back_btn.setOnClickListener{
            MainActivity.getInstance()?.onFragmentChange("LogDetailFragment")
        }

        log_modify_register_btn.setOnClickListener {
            MainActivity.getInstance()?.onFragmentChange("CategoryDetailFragment")
        }

        log_modify_main_text.setOnClickListener {
            hideKeyBoard()
        }

        tag_input.setOnClickListener {
            hideKeyBoard()
        }

        log_moodify_code_text.setOnClickListener {
            hideKeyBoard()
        }

        return view
    }

    private fun hideKeyBoard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }

}