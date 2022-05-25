package org.techtown.gaebal_saebal_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GitHubFragmentAdapter(private val dataSet: ArrayList<GitHubData>):
    RecyclerView.Adapter<GitHubFragmentAdapter.ViewHolder> () {

    var datas = mutableListOf<GitHubData>()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_github_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val Type: TextView = itemView.findViewById(R.id.github_type)
        private val Date: TextView = itemView.findViewById(R.id.github_date)
        private val Title: TextView = itemView.findViewById(R.id.github_title)
        private val Repo: TextView = itemView.findViewById(R.id.github_repo)

        fun bind(item: GitHubData) {
            Type.text = item.type
            Date.text= item.date
            Title.text = item.title
            Repo.text = item.repo
        }

    }

}