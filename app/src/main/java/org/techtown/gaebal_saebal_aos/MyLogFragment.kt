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
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MyLogFragment : Fragment(){

    // datas: 데이터의 형식?
    private val datas = arrayListOf<MyLogData>()
    // MyLogFragment에 RecyclerView를 이어주는 Adapter
    private val  myLogadapter = MyLogFragmentAdapter(datas)
    // recycler 뷰 변수
    lateinit var recycler: RecyclerView
    // recycler layout
    lateinit var mLayoutManager: StaggeredGridLayoutManager

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

        // 원하는 카테고리 선택시 해당 프레그먼트로 전환
        myLogadapter.setItemClickListener(object : MyLogFragmentAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                activity?.onFragmentChange(1)
            }
        })

        // 기록 작성 버튼 클릭시, 기록 작성 프레그먼트로 전환
        val btn_log_write = view.findViewById<ImageButton>(R.id.log_write_btn)
        btn_log_write.setOnClickListener {
            activity?.onFragmentChange(2)
        }
        return view
    }

    // MyLogData의 형태에 맞게 데이터 입력
    private fun setListView() {
        datas.apply {
//            add(MyLogData(title = "BOJ", content1 = "흠냐륑", content2 = "", content3 = "", content4 = "", content5 = "") )
            add(MyLogData(title = "BOJ", content1 = "흠냐륑", content2 = "", content3 = "", content4 = "", content5 = "") )
            add(MyLogData(title = "BOJ1", content1 = "흠냐륑1", content2 = "버블버블1", content3 = "", content4 = "", content5 = ""))
            add(MyLogData(title = "BOJ2", content1 = "흠냐륑2", content2 = "버블버블2", content3 = "니나노", content4 = "", content5 = ""))
            add(MyLogData(title = "BOJ3", content1 = "흠냐륑3",  content2 = "버블버블3", content3 = "니나노1", content4 = "ㅇ아아", content5 = ""))
            add(MyLogData(title = "BOJ4", content1 = "흠냐륑4", content2 = "버블버블4", content3 = "ㄴ나노2", content4 = "아아아", content5 = "nulㅇㄹ알"))

            myLogadapter.datas = datas
            myLogadapter.notifyDataSetChanged()
        }
        recycler.adapter = myLogadapter
    }
}
