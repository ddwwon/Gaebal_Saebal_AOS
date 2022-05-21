package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class LogWriteFragment : Fragment(), View.OnClickListener  {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
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

    private val  logWriteFragmentAdapter = LogWriteFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_log_write, container, false)
        val github_btn: Button = view.findViewById(R.id.log_write_github)
        github_btn.setOnClickListener(this)

        logWriteFragmentAdapter.setItemClickListener(object : LogWriteFragmentAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                activity?.onFragmentChange(2)
                println("work3")
            }
        })

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.log_write_github -> {

            }
        }
    }

}