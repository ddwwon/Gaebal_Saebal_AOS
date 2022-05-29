package org.techtown.gaebal_saebal_aos

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.EditText
import androidx.annotation.MainThread
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.boj_problem_dialog.*
import kotlinx.android.synthetic.main.category_input.*
import kotlinx.android.synthetic.main.delete_or_not_modal.*

class DeleteDialog (context: Context) {

    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener
    var activity: MainActivity? = null

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.delete_or_not_modal)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        dialog.delete_cancel_btn.setOnClickListener{
            dialog.dismiss()
        }

        dialog.delete_ok_btn.setOnClickListener{
            dialog.dismiss()
//            val categorymodifyfragment: CategoryModifyFragment =
            var name = dialog.findViewById<EditText>(R.id.delete_name)
            var input = name.text.toString()
            for (i in 0 until category_list.size) {
                if (category_list[i] == input) {
                    println(category_list[i])
                    category_list.removeAt(i)
                    println("delete dialog")

                }
            }
            delete = true

//            var delete_item = category_list.lastIndex
//            category_list.removeAt(delete_item)
            CategoryModifyFragment.getInstance()?.setListView()
        }
    }
    interface OnDialogClickListener {
        fun onClicked(num: Int)
    }
}