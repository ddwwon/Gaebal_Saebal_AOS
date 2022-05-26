package org.techtown.gaebal_saebal_aos

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import kotlinx.android.synthetic.main.text_over_dialog.*

class TextZeroDialog(context: Context) {

    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.text_zero_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        dialog.text_over_dialog_ok_btn.setOnClickListener{
            dialog.dismiss()
        }
    }
    interface OnDialogClickListener {
        fun onClicked(num: Int)
    }
}