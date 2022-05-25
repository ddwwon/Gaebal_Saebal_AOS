package org.techtown.gaebal_saebal_aos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class GithubFragment : BottomSheetDialogFragment() {

    private val datas = arrayListOf<GitHubData>()
    private val githubadapter = GitHubFragmentAdapter(datas)
    lateinit var recycler: RecyclerView
    lateinit var mLayoutManager: LinearLayoutManager

    var activity: MainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_github, container, false)
        recycler = view.findViewById(R.id.github_list_frame)
        mLayoutManager = LinearLayoutManager(view.context)

        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = mLayoutManager

        setListView()
        return view
    }

    private fun setListView() {
        datas.apply {
            add(GitHubData(date = "2022/01/01 11PM", title = "그냥 다 조졌어1", type = "issue", repo = "ddwwon/jojo1"))
            add(GitHubData(date = "2022/01/02 11PM", title = "그냥 다 조졌어2", type = "issue", repo = "ddwwon/jojo2"))
            add(GitHubData(date = "2022/01/03 11PM", title = "그냥 다 조졌어3", type = "issue", repo = "ddwwon/jojo3"))
            add(GitHubData(date = "2022/01/04 11PM", title = "그냥 다 조졌어4", type = "issue", repo = "ddwwon/jojo4"))
            add(GitHubData(date = "2022/01/05 11PM", title = "그냥 다 조졌어5", type = "issue", repo = "ddwwon/jojo5"))

            githubadapter.datas = datas
        }
        recycler.adapter = githubadapter
    }

    companion object {
        const val TAG = "GithubFragment"
    }
}