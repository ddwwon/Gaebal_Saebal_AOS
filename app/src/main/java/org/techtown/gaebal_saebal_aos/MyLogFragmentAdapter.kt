package org.techtown.gaebal_saebal_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.RuntimeException

// private val dataSet: ArrayList<MyLogData>
class MyLogFragmentAdapter(private val dataSet: ArrayList<MyLogData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    // 불러온 데이터 형식
    var datas = mutableListOf<MyLogData>()

    // adapter 생성
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // view에 보여줄 데이터 layout
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item,viewGroup,false)
//        return ViewHolder(view)
        return when (viewType) {
            MyLogData.MY_LOG_ITEM1 -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item, viewGroup, false)
                MyLogItem1ViewHolder(view)
            }
            MyLogData.MY_LOG_ITEM2 -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item2, viewGroup, false)
                MyLogItem2ViewHolder(view)
            }
            MyLogData.MY_LOG_ITEM3 -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item3, viewGroup, false)
                MyLogItem3ViewHolder(view)
            }
            MyLogData.MY_LOG_ITEM4 -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item4, viewGroup, false)
                MyLogItem4ViewHolder(view)
            }
            MyLogData.MY_LOG_ITEM5 -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_my_log_item5, viewGroup, false)
                MyLogItem5ViewHolder(view)
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    // 데이터 사이즈 계산
    override fun getItemCount(): Int = dataSet.size

    // data bind
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        holder.bind(datas[position])
        // 카테고리 클릭 리스너
        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }

        val obj = dataSet[position]
        when(obj.type) {
            MyLogData.MY_LOG_ITEM1 -> {
                (holder as MyLogItem1ViewHolder).txtType.text = obj.category
                holder.content1.text = obj.content1
            }
            MyLogData.MY_LOG_ITEM2 -> {
                (holder as MyLogItem2ViewHolder).txtType.text = obj.category
                holder.content1.text = obj.content1
                holder.content2.text = obj.content2
            }
            MyLogData.MY_LOG_ITEM3 -> {
                (holder as MyLogItem3ViewHolder).txtType.text = obj.category
                holder.content1.text = obj.content1
                holder.content2.text = obj.content2
                holder.content3.text = obj.content3
            }
            MyLogData.MY_LOG_ITEM4 -> {
                (holder as MyLogItem4ViewHolder).txtType.text = obj.category
                holder.content1.text = obj.content1
                holder.content2.text = obj.content2
                holder.content3.text = obj.content3
                holder.content4.text = obj.content4
            }
            MyLogData.MY_LOG_ITEM5 -> {
                (holder as MyLogItem5ViewHolder).txtType.text = obj.category
                holder.content1.text = obj.content1
                holder.content2.text = obj.content2
                holder.content3.text = obj.content3
                holder.content4.text = obj.content4
                holder.content5.text = obj.content5
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return datas[position].type
    }

    inner class MyLogItem1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.my_log_title)
        val content1: TextView = itemView.findViewById(R.id.my_log_content1)
    }

    inner class MyLogItem2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.my_log_title)
        val content1: TextView = itemView.findViewById(R.id.my_log_content1)
        val content2: TextView = itemView.findViewById(R.id.my_log_content2)
    }

    inner class MyLogItem3ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.my_log_title)
        val content1: TextView = itemView.findViewById(R.id.my_log_content1)
        val content2: TextView = itemView.findViewById(R.id.my_log_content2)
        val content3: TextView = itemView.findViewById(R.id.my_log_content3)
    }

    inner class MyLogItem4ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.my_log_title)
        val content1: TextView = itemView.findViewById(R.id.my_log_content1)
        val content2: TextView = itemView.findViewById(R.id.my_log_content2)
        val content3: TextView = itemView.findViewById(R.id.my_log_content3)
        val content4: TextView = itemView.findViewById(R.id.my_log_content4)
    }

    inner class MyLogItem5ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.my_log_title)
        val content1: TextView = itemView.findViewById(R.id.my_log_content1)
        val content2: TextView = itemView.findViewById(R.id.my_log_content2)
        val content3: TextView = itemView.findViewById(R.id.my_log_content3)
        val content4: TextView = itemView.findViewById(R.id.my_log_content4)
        val content5: TextView = itemView.findViewById(R.id.my_log_content5)
    }

    // 카테고리 클릭 리스너
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    // 카테고리 클릭
    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    // data를 MyLogdata에 설정한 대로 데이터 지정(?) 이란 말이 맞나,,,
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//        private val Title: TextView = itemView.findViewById(R.id.my_log_title)
//        private val Content1: TextView = itemView.findViewById(R.id.my_log_content1)
//        private val Content2: TextView = itemView.findViewById(R.id.my_log_content2)
//        private val Content3: TextView = itemView.findViewById(R.id.my_log_content3)
//        private val Content4: TextView = itemView.findViewById(R.id.my_log_content4)
//        private val Content5: TextView = itemView.findViewById(R.id.my_log_content5)
//
//        fun bind(item: MyLogData) {
//            Title.text = item.title
//            Content1.text = item.content1
//
//            Content2.text = item.content2
//            Content3.text = item.content3
//            Content4.text = item.content4
//            Content5.text = item.content5
//        }
//    }
}