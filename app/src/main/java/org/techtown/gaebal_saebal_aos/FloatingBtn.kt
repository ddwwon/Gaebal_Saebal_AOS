package org.techtown.gaebal_saebal_aos

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import kotlinx.android.synthetic.main.boj_problem_dialog.*
import kotlinx.android.synthetic.main.floating_btn_dialog.*

class FloatingBtn (context: Context){

    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener
    var activity: MainActivity? = null

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.floating_btn_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setGravity(Gravity.BOTTOM)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()
//        activity?.onFragmentChange(14)

        dialog.log_detail_modify.setOnClickListener{
            dialog.dismiss()
            MainActivity.getInstance()?.onFragmentChange("LogModifyFragment")
        }

        dialog.log_detail_delete.setOnClickListener{
            dialog.dismiss()
            MainActivity.getInstance()?.onFragmentChange("MyLogFragment")
        }
    }
    interface OnDialogClickListener {
        fun onClicked(num: Int)
    }
}