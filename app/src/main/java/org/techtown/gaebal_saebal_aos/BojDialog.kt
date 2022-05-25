package org.techtown.gaebal_saebal_aos

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.EditText
import kotlinx.android.synthetic.main.boj_problem_dialog.*

class BojDialog (context: Context) {

    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.boj_problem_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

//        val boj_num = dialog.findViewById<EditText>(R.id.boj_dialog)

        dialog.boj_cancel_btn.setOnClickListener{
            dialog.dismiss()
        }

        dialog.boj_ok_btn.setOnClickListener{
//            onClickListener.onClicked(boj_num.text)
            dialog.dismiss()
        }
    }
    interface OnDialogClickListener {
        fun onClicked(num: Int)
    }
}