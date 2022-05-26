package org.techtown.gaebal_saebal_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class LogWriteFragmentAdapter{

//    fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.Adapter<MyLogFragmentAdapter.ViewHolder> {
//        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_log_write, viewGroup, false)
//        return ViewHolder(view)
//    }

    // data bind
    fun onBindViewHolder(holder: ViewHolder, position: Int) {
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
}

