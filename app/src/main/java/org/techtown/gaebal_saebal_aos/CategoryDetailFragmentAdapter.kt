package org.techtown.gaebal_saebal_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryDetailFragmentAdapter(private val dataSet: ArrayList<CategoryData>) :
    RecyclerView.Adapter<CategoryDetailFragmentAdapter.ViewHolder> (){

    var datas = mutableListOf<CategoryData>()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_category_detail_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val Date: TextView = itemView.findViewById(R.id.category_detail_date)
        private val Title: TextView = itemView.findViewById(R.id.category_detail_title)
        private val Hashtag: TextView = itemView.findViewById(R.id.category_detail_tag)

        fun bind(item: CategoryData) {
            Date.text = item.date
            Title.text = item.title
            Hashtag.text = item.hashtag
        }
    }
}