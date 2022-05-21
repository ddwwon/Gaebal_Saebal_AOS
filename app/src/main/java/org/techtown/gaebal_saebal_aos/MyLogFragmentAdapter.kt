package org.techtown.gaebal_saebal_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyLogFragmentAdapter(private val dataSet: ArrayList<MyLogData>) :
    RecyclerView.Adapter<MyLogFragmentAdapter.ViewHolder> () {

    // 불러온 데이터 형식
    var datas = mutableListOf<MyLogData>()

    // adapter 생성
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // view에 보여줄 데이터 layout
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item,viewGroup,false)
        return ViewHolder(view)
    }

    // 데이터 사이즈 계산
    override fun getItemCount(): Int = datas.size

    // data bind
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

        // 카테고리 클릭 리스너
        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }

    // 카테고리 클릭
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    // 카테고리 클릭
    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    // data를 MyLogdata에 설정한 대로 데이터 지정(?) 이란 말이 맞나,,,
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val Title: TextView = itemView.findViewById(R.id.my_log_title)
        private val Content1: TextView = itemView.findViewById(R.id.my_log_content1)
        private val Content2: TextView = itemView.findViewById(R.id.my_log_content2)
        private val Content3: TextView = itemView.findViewById(R.id.my_log_content3)
        private val Content4: TextView = itemView.findViewById(R.id.my_log_content4)
        private val Content5: TextView = itemView.findViewById(R.id.my_log_content5)

        fun bind(item: MyLogData) {
            Title.text = item.title
            Content1.text = item.content1
            Content2.text = item.content2
        }
    }
}