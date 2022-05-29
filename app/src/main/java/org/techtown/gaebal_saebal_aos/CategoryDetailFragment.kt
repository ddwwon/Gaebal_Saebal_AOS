package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryDetailFragment : Fragment() {

    private val datas = arrayListOf<CategoryData>()
    private val categoryadapter = CategoryDetailFragmentAdapter(datas)
    lateinit var recycler: RecyclerView
    lateinit var mLayoutManager: LinearLayoutManager

    var activity: MainActivity? = null

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

        val view = inflater.inflate(R.layout.fragment_category_detail, container, false)
        recycler = view.findViewById(R.id.category_list_frame)
        mLayoutManager = LinearLayoutManager(view.context)

        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = mLayoutManager

        setListView()

        val category_detail_write_btn = view.findViewById<ImageButton>(R.id.category_detail_write_btn)
        category_detail_write_btn.setOnClickListener {
            activity?.onFragmentChange("LogWriteFragment")
        }

        val back_btn = view.findViewById<ImageButton>(R.id.back_btn)
        back_btn.setOnClickListener {
            activity?.onFragmentChange("MyLogFragment")
        }

        // 원하는 카테고리 선택시 해당 프레그먼트로 전환
        categoryadapter.setItemClickListener(object : CategoryDetailFragmentAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                activity?.onFragmentChange("LogDetailFragment")
            }
        })

        return view
    }

    private fun setListView() {
        datas.apply {
            add(CategoryData(date = "2022/01/22 17:19", title = "BOJ의 1번째 기록", hashtag = "#JAVA #stack #10828"))
            add(CategoryData(date = "2022/01/22 17:25", title = "BOJ의 2번째 기록", hashtag = "#JAVA #단어뒤집기 #9093"))

            categoryadapter.datas = datas
        }
        recycler.adapter = categoryadapter
    }

}