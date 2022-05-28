package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.internal.Internal
import okhttp3.internal.Internal.instance
import org.techtown.gaebal_saebal_aos.databinding.FragmentCategoryModifyBinding

var delete = false

class CategoryModifyFragment: Fragment(){
    private val datas = arrayListOf<CategoryTitleData>()
    val categorymodifyfragmentadapter = CategoryModifyFragmentAdapter(datas)
    lateinit var recycler: RecyclerView
    lateinit var mLayoutManager: LinearLayoutManager

    var activity: MainActivity? = null

    private var binding: FragmentCategoryModifyBinding?=null
    private val binding2 get() = binding!!

    init {
        instance = this
    }

    companion object {
        private var instance: CategoryModifyFragment?=null
        fun getInstance():CategoryModifyFragment? {
            return instance
        }
    }

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
            activity?.onFragmentChange("MySettingFragment")
            println("카테고리 수정 ")
        }

        val category_add_btn = view.findViewById<AppCompatButton>(R.id.category_add)
        category_add_btn.setOnClickListener {
            activity?.onFragmentChange("CategoryInputDialog")
        }

        val category_delete_btn = view.findViewById<AppCompatButton>(R.id.category_delete)
        category_delete_btn.setOnClickListener {
            activity?.onFragmentChange("DeleteCategory")
        }

        setListView()
        return view
    }

    var first = true

    fun setListView() {

        datas.apply {
            if (first == true && delete == false) {
                for (i in 0 until category_list.size){
                    add(CategoryTitleData(category_list[i]))
                    categorymodifyfragmentadapter.datas = datas
                    first = false
                    println("1")
                }
            }
            else if (delete == false && first == false) {
                add(CategoryTitleData(category_list[category_list.size-1]))
                categorymodifyfragmentadapter.datas = datas
                println("2")
            }
            else if (delete == true) {
//                categorymodifyfragmentadapter.datas = datas
                println("noidjftifsd")
//                categorymodifyfragmentadapter.notifyDataSetChanged()
                MainActivity.getInstance()?.onFragmentChange("MySettingFragment")
                MainActivity.getInstance()?.onFragmentChange("CategoryModifyFragment")
                delete = false

            }
        }
        recycler.adapter = categorymodifyfragmentadapter
    }

}