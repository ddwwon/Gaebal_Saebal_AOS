package org.techtown.gaebal_saebal_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryModifyFragmentAdapter(private val dataSet: ArrayList<CategoryTitleData>) :
    RecyclerView.Adapter<CategoryModifyFragmentAdapter.ViewHolder> () {

    // 불러온 데이터 형식
    var datas = mutableListOf<CategoryTitleData>()

    // adapter 생성
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // view에 보여줄 데이터 layout
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_category_modify_item,viewGroup,false)
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
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val Title: TextView = itemView.findViewById(R.id.category_modify_title)

        fun bind(item: CategoryTitleData) {
            Title.text = item.title
        }
    }
}