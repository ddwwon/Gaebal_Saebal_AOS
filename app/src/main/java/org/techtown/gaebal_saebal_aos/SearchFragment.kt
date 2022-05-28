package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

class SearchFragment : Fragment() {

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val search_result = view.findViewById<ConstraintLayout>(R.id.search_result)
        val search_btn = view.findViewById<ImageButton>(R.id.search_btn)
        search_result.visibility = GONE

        search_btn.setOnClickListener {
            search_result.visibility = View.VISIBLE
        }

        return view
    }


}