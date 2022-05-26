package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryModifyFragment: Fragment(){
    private val datas = arrayListOf<CategoryTitleData>()
    private val githubadapter = CategoryModifyFragmentAdapter(datas)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_category_modify, container, false)
        recycler = view.findViewById(R.id.category_modify_frame)
        mLayoutManager = LinearLayoutManager(view.context)

        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = mLayoutManager

        val back_btn = view.findViewById<ImageButton>(R.id.cate_modify_back_btn)
        back_btn.setOnClickListener{
            activity?.onFragmentChange(12)
            println("카테고리 수정 ")
        }

        setListView()
        return view
    }

    private fun setListView() {
        datas.apply {
            add(CategoryTitleData("자료구조"))
            add(CategoryTitleData("백준"))
            add(CategoryTitleData("AOS"))
            githubadapter.datas = datas
        }
        recycler.adapter = githubadapter
    }

}