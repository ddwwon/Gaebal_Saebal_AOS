package org.techtown.gaebal_saebal_aos

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout


class LogWriteFragment : Fragment()  {

    var activity: MainActivity? = null

    private val pickImage = 100
    private var imageUri: Uri? = null

    // onAttach, onDetach: clicklistener를 사용하기 위해서 필요요요요
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity() as MainActivity
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_log_write, container, false)
        val image_cancel_btn = view.findViewById<AppCompatButton>(R.id.image_cancle_btn)
        val baekjoon_view = view.findViewById<ConstraintLayout>(R.id.baekjoon_view)
        val github_view = view.findViewById<ConstraintLayout>(R.id.github_view)
        val baekjoon_btn = view.findViewById<AppCompatButton>(R.id.baekjoon_btn)
        val github_btn = view.findViewById<AppCompatButton>(R.id.github_btn)
        val picture_framelayout = view.findViewById<FrameLayout>(R.id.picture_framelayout)
        val picture_btn = view.findViewById<AppCompatButton>(R.id.image_btn)

        image_cancel_btn.visibility = View.GONE
        baekjoon_view.visibility = View.GONE
        github_view.visibility = View.GONE
        picture_framelayout.visibility = View.GONE

        // 깃허브에 + 버튼 클릭시 하단에서 bottom sheet이 나오면서 최근 이슈, 풀, 커밋 리스트가 나온다
        github_btn.setOnClickListener {
            activity?.onFragmentChange("GitHubFragment")
        }

        // 백준에 + 버튼 클릭시 백준 번호를 입력하는 modal 창이 나온다.
        baekjoon_btn.setOnClickListener{
            activity?.onFragmentChange("BojDialog")
        }

        // 사진 추가하기 버튼을 누르면 갤러리, 사진 찍기를 선택하는 bottom sheet이 나온다.
        picture_btn.setOnClickListener {
//            activity?.onFragmentChange(5)
            picture_btn.visibility = View.GONE
            picture_framelayout.visibility = View.VISIBLE
//            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//            startActivityForResult(gallery, pickImage)

        }

        // 취소하기 옆의 뒤로가기 버튼을 누르면 내 기록 프레그먼트로 이동한다.
        val back_btn = view.findViewById<ImageButton>(R.id.back_btn)
        back_btn.setOnClickListener {
            activity?.onFragmentChange("MyLogFragment")
        }

        // 등록 버튼을 누르면 내 기록 프레그먼트로 이동한다.
        val log_write_register_btn = view.findViewById<Button>(R.id.log_write_register_btn)
        log_write_register_btn.setOnClickListener{
            activity?.onFragmentChange("MyLogFragment")
        }

        // 본문 글자수 카운트
        val log_write_main_text = view.findViewById<EditText>(R.id.log_write_main_text)
        val char_cnt = view.findViewById<TextView>(R.id.char_cnt)
        log_write_main_text.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                char_cnt.text = "0/1000"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var userinput = log_write_main_text.text.toString()
                char_cnt.text = userinput.length.toString() + " /1000"
            }

            override fun afterTextChanged(p0: Editable?) {
                var userinput = log_write_main_text.text.toString()
                char_cnt.text = userinput.length.toString() + " /1000"
                if (userinput.length >= 1000) {
                    activity?.onFragmentChange("TextOverDialog")
                }
                if (userinput.length == 0) {
                    activity?.onFragmentChange("TextZeroDialog")
                }
            }
        })

        // 코드 글자수 카운트
        val log_write_code_text = view.findViewById<EditText>(R.id.log_write_code_text)
        val code_char_cnt = view.findViewById<TextView>(R.id.code_char_cnt)
        log_write_code_text.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                code_char_cnt.text = "0/1000"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var userinput = log_write_code_text.text.toString()
                code_char_cnt.text = userinput.length.toString() + " /1000"
            }

            override fun afterTextChanged(p0: Editable?) {
                var userinput = log_write_code_text.text.toString()
                code_char_cnt.text = userinput.length.toString() + " /1000"
                if (userinput.length >= 1000) {
                    activity?.onFragmentChange("TextOverDialog")
                }
                if (userinput.length == 0) {
                    activity?.onFragmentChange("TextZeroDialog")
                }
            }
        })

        return view
    }

    // 사진 추가하기 누르면 갤러리에서 이미지 선택함
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageview = view?.findViewById<ImageView>(R.id.picture_view)
        if(resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageview?.setImageURI(imageUri)
        }
    }

}