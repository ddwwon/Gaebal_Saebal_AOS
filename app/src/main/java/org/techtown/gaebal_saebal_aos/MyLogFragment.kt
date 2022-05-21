package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import org.techtown.gaebal_saebal_aos.databinding.FragmentMyLogBinding
import kotlin.collections.forEach as forEach1

class MyLogFragment : Fragment(), View.OnClickListener {

    // datas: 데이터의 형식?
    private val datas = arrayListOf<MyLogData>()
    // MyLogFragment에 RecyclerView를 이어주는 Adapter
    private val  myLogadapter = MyLogFragmentAdapter(datas)
    // recycler 뷰 변수
    lateinit var recycler: RecyclerView
    // recycler layout
    lateinit var mLayoutManager: StaggeredGridLayoutManager

    var activity: MainActivity? = null

    private lateinit var binding: FragmentMyLogBinding

    // onAttach, onDetach: clicklistener를 사용하기 위해서 필요요요요
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity() as MainActivity
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }

    // MyLogFragment 화면 호출
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // recycler view가 틀어있는 xml
        val view = inflater.inflate(R.layout.fragment_my_log, container, false)
        // recycler view의 id
        recycler = view.findViewById(R.id.my_log_list_frame)
        mLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        // recyclerView orientation (가로 방향 스크롤 설정)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = mLayoutManager

        // 보여줄 데이터 넣는 함수
        setListView()

        myLogadapter.setItemClickListener(object : MyLogFragmentAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                activity?.onFragmentChange(1)
            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setOnClickListener()
    }

//    private fun setOnClickListener() {
//        val btn = binding.container.children
//        btn.forEach1 {
//            btn -> btn.setOnclickListener(this)
//        }
//    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.log_write_btn -> {
                activity?.onFragmentChange(2)
                println("work3")
            }
        }
    }

    // MyLogData의 형태에 맞게 데이터 입력
    private fun setListView() {
        datas.apply {
            add(MyLogData(title = "BOJ", content1 = "흠냐륑", content2 = "버블버블", content3 = "null", content4 = "null", content5 = "null"))
            add(MyLogData(title = "BOJ1", content1 = "흠냐륑1", content2 = "버블버블", content3 = "null", content4 = "null", content5 = "null"))
            add(MyLogData(title = "BOJ2", content1 = "흠냐륑2", content2 = "버블버블", content3 = "null", content4 = "null", content5 = "null"))
            add(MyLogData(title = "BOJ3", content1 = "흠냐륑3",  content2 = "버블버블", content3 = "null", content4 = "null", content5 = "null"))
            add(MyLogData(title = "BOJ4", content1 = "흠냐륑4", content2 = "버블버블", content3 = "null", content4 = "null", content5 = "null"))
            add(MyLogData(title = "BOJ5", content1 = "흠냐륑5", content2 = "버블버블", content3 = "null", content4 = "null", content5 = "null"))

            myLogadapter.datas = datas
            myLogadapter.notifyDataSetChanged()
        }
        recycler.adapter = myLogadapter
    }

}