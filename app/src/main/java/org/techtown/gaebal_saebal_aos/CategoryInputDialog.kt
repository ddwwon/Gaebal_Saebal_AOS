package org.techtown.gaebal_saebal_aos

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.EditText
import kotlinx.android.synthetic.main.boj_problem_dialog.*
import kotlinx.android.synthetic.main.category_input.*

class CategoryInputDialog (context: Context) {

    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener
    var activity: MainActivity? = null
//    var list = arrayListOf<String>()

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.category_input)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        dialog.category_cancel_btn.setOnClickListener{
            dialog.dismiss()
        }

        dialog.category_ok_btn.setOnClickListener{
            dialog.dismiss()
//            val categorymodifyfragment: CategoryModifyFragment =
            var name = dialog.findViewById<EditText>(R.id.category_name)
            var input = name.text.toString()
            category_list.add(input)
            CategoryModifyFragment.getInstance()?.setListView()
        }
    }
    interface OnDialogClickListener {
        fun onClicked(num: Int)
    }
}