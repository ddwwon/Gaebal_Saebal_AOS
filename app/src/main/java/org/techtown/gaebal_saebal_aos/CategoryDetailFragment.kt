package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

//        categoryadapter.setItemClickListener(object: CategoryDetailFragmentAdapter.ItemClickListener) {
//            override fun onClick(view: View, position: Int) {
//                activity?.onFragmentChange(1)
//            }
//        }
        return view
    }

    private fun setListView() {
        datas.apply {
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조", hashtag = "#c#stack"))


            categoryadapter.datas = datas
        }
        recycler.adapter = categoryadapter
    }

}