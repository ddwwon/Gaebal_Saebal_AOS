package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MySettingFragment : Fragment() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_setting, container, false)

        // 깃허브 사용자 클릭시, GoGitSetFragment로 전환
        val git_setting_btn = view.findViewById<AppCompatButton>(R.id.git_setting_btn)
        git_setting_btn.setOnClickListener {
            activity?.onFragmentChange("GoGitSetFragment")
        }

        val setting_category_btn = view.findViewById<AppCompatButton>(R.id.setting_category_btn)
        setting_category_btn.setOnClickListener {
            activity?.onFragmentChange("CategoryModifyFragment")
        }

        return view
    }
}