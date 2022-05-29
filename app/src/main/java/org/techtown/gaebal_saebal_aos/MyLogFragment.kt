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
                activity?.onFragmentChange("CategoryDetailFragment")
            }
        })


        // 기록 작성 버튼 클릭시, 기록 작성 프레그먼트로 전환
        val btn_log_write = view.findViewById<ImageButton>(R.id.log_write_btn)
        btn_log_write.setOnClickListener {
            activity?.onFragmentChange("LogWriteFragment")
        }
        return view
    }

    // MyLogData의 형태에 맞게 데이터 입력
    private fun setListView() {
        datas.apply {
            add(MyLogData(title_default.size, category_list[0], title_default[0], title_default[1], title_default[2], title_default[3], null))
            add(MyLogData(title_aos.size, category_list[1], title_aos[0], title_aos[1], null, null, null))
            add(MyLogData(title_boj.size, category_list[2], title_boj[0], title_boj[1], null, null, null))
            add(MyLogData(title_data.size, category_list[3], title_data[0], title_data[1], title_data[2], title_data[3], null))
            add(MyLogData(title_ai.size, category_list[4], title_ai[0], title_ai[1], title_ai[2], title_ai[3], title_ai[4]))

            myLogadapter.datas = datas
            myLogadapter.notifyDataSetChanged()
        }
        recycler.adapter = myLogadapter
    }
}
