package org.techtown.gaebal_saebal_aos

import android.Manifest
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CameraAndGalleryFragment : BottomSheetDialogFragment() {

    private val datas = arrayListOf<GitHubData>()
    private val githubadapter = GitHubFragmentAdapter(datas)
    lateinit var recycler: RecyclerView
    lateinit var mLayoutManager: LinearLayoutManager

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_camera_and_gallery, container, false)

        val camera_btn = view.findViewById<AppCompatImageButton>(R.id.camera_btn)
        camera_btn.setOnClickListener{
            activity?.onFragmentChange(6)
            println("camera_btn")
        }

        val gallery_btn = view.findViewById<AppCompatImageButton>(R.id.gallery_btn)
        gallery_btn.setOnClickListener{
            activity?.onFragmentChange(7)
            println("gallery_btn")
        }

        return view
    }


    companion object {
        const val TAG = "CameraAndGalleryFragment"
    }
}

