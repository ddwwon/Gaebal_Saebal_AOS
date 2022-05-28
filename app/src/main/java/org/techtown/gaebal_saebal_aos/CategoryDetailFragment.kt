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
            activity?.onFragmentChange(2)
        }

        val back_btn = view.findViewById<ImageButton>(R.id.back_btn)
        back_btn.setOnClickListener {
            activity?.onFragmentChange(6)
        }

        categoryadapter.setItemClickListener(object: CategoryDetailFragmentAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                activity?.onFragmentChange(13)
            }
        })

        return view
    }

    private fun setListView() {
        datas.apply {
            add(CategoryData(date = "2022/01/01 11PM", title = "스택구조1", hashtag = "#c#stack1"))
            add(CategoryData(date = "2022/01/02 11PM", title = "스택구조2", hashtag = "#c#stack2"))
            add(CategoryData(date = "2022/01/03 11PM", title = "스택구조3", hashtag = "#c#stack3"))
            add(CategoryData(date = "2022/01/04 11PM", title = "스택구조4", hashtag = "#c#stack4"))
            add(CategoryData(date = "2022/01/05 11PM", title = "스택구조5", hashtag = "#c#stack5"))
            add(CategoryData(date = "2022/01/06 11PM", title = "스택구조6", hashtag = "#c#stack6"))
            add(CategoryData(date = "2022/01/07 11PM", title = "스택구조7", hashtag = "#c#stack7"))
            add(CategoryData(date = "2022/01/08 11PM", title = "스택구조8", hashtag = "#c#stack8"))
            add(CategoryData(date = "2022/01/09 11PM", title = "스택구조9", hashtag = "#c#stack9"))
            add(CategoryData(date = "2022/01/10 11PM", title = "스택구조10", hashtag = "#c#stack10"))


            categoryadapter.datas = datas
        }
        recycler.adapter = categoryadapter
    }

}