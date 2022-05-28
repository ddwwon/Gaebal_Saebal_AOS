package org.techtown.gaebal_saebal_aos

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Spannable
import android.text.Spanned
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
//import kotlinx.android.synthetic.main.my_log_fragment.*
import kotlinx.android.synthetic.main.fragment_my_log.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.boj_problem_dialog.view.*
import kotlinx.android.synthetic.main.fragment_log_write.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         GitHub Api: public인 repository의 pull, issue의 title, created_date, user_name 불러와용갈갈갈
//        GithubClient.getApi().getRepos("13wjdgk")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({items ->
//                items.forEach {println(it)}
//            }, {e ->
//                println(e.toString())
//            })
//
//        BOJClient.getApi().getNum(25216)
//            .enqueue(object : Callback<BOJ>{
//                override fun onResponse(call: Call<BOJ>, response: Response<BOJ>) {
//                    println("성공: ${response}")
//                }
//
//                override fun onFailure(call: Call<BOJ>, t: Throwable) {
//                    println("not work,,bb")
//                }
//            })
    }

    override fun onResume() {
        super.onResume()
        // 초기 fragment 셋팅: 하단바 fragment(bottom_navigation_frame) 셋팅, id값 주의하자,, 진짜 소름끼쳤었네
        supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MyLogFragment()).commit()
        // navigationBottomView 등록: 하단바 fragment id(bottom_navigation) 등록
        transitionNavigationBottomView(bottom_navigation, supportFragmentManager)
    }

    // NavigationBottomView 화면 전환하는 함수.
    private fun transitionNavigationBottomView(bottomView: BottomNavigationView, fragmentManager: FragmentManager){
        bottomView.setOnItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.my_log -> {
                    fragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MyLogFragment()).commit()
                }
                R.id.search -> {
                    fragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, SearchFragment()).commit()
                }
                R.id.my_information -> {
                    fragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MySettingFragment()).commit()
                }
                else -> Log.d("test", "error") == 0
            }
            Log.d("test", "final") == 0
        }
    }

    fun onFragmentChange(index: Int) {
        if(index == 1) {
            // myLog에서 카테고리를 선택하면 해당 카테고리 프레그먼트로 전환
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, CategoryDetailFragment()).commit()
        }
        else if(index == 2) {
            // 기록 프레그먼트에서 기록 작성 버튼 누르면 기록 작성 프레그먼트로 전환
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, LogWriteFragment()).commit()
        }
        else if(index == 3) {
            // 기록 작성 뷰에서 깃허브 버튼 클릭 시, persistenet bottom sheet로 창을 띄움
            val githubfragment = GithubFragment()
            githubfragment.show(supportFragmentManager, githubfragment.tag)
        }
        else if(index == 4) {
            // 백준 문제 번호를 입력하는 창을 띄우게
            val dialog = BojDialog(this)
            dialog.showDialog()
            dialog.setOnClickListener(object: BojDialog.OnDialogClickListener {
                override fun onClicked(num: Int) {
                }
            })
        }
        else if(index == 5) {
            // 갤러리에서 이미지 선택하는 칭긔칭긔
            val image_cancel_btn = findViewById<AppCompatButton>(R.id.image_cancle_btn)
            image_cancel_btn.visibility = View.VISIBLE
//            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, LogWriteFragment()).commit()
//            loadImage()
//            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//            startActivityForResult(gallery, pickImage)
        }
        else if(index == 6) {
            // 기록 프레그먼트로 전환
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MyLogFragment()).commit()
        }
        else if(index == 7)  {
            // 내 설정 프레그먼트에서 카테고리 추가/삭제 버튼 누르면 해당 프레그먼트로 이동한다.
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, CategoryModifyFragment()).commit()
        }
        else if(index == 8) {
            // 기록 작성 프레그먼트의 본문에서 500자가 넘으면 글자 수를 줄이라는 다이얼로그 출력
            val dialog = TextOverDialog(this)
            dialog.showDialog()
            dialog.setOnClickListener(object: TextOverDialog.OnDialogClickListener {
                override fun onClicked(num: Int) {
                }
            })
        }
        else if(index == 9) {
            // 기록 작성 프레그먼트의 본문에서 500자가 넘으면 글자 수를 줄이라는 다이얼로그 출력
            val dialog = TextZeroDialog(this)
            dialog.showDialog()
            dialog.setOnClickListener(object: TextZeroDialog.OnDialogClickListener {
                override fun onClicked(num: Int) {
                }
            })
        }
        else if(index == 10) {
            // 내 설정 프래그먼트에서 깃허브 사용자 설정을 누르면 해당 프래그먼트로 전환
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, GoGitSetFragment()).commit()
        }
        else if(index == 11) {
            // 카테고리 추가/삭제 프래그먼트로 전환
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, CategoryModifyFragment()).commit()
        }
        else if(index == 12) {
            // 내 설정 프래그먼트로 전환
            println("esjdskfjd")
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MySettingFragment()).commit()
        }
        else if(index == 13){
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, LogDetailFragment()).commit()
        }
    }

    // 갤러리에서 이미지 선택하기
//    val Gallery = 0
//    private fun loadImage() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(Intent.createChooser(intent, "Load Pic"), Gallery)
//    }
//
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageview = findViewById<ImageView>(R.id.picture_view)
        if(resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageview.setImageURI(imageUri)
        }
//        val picture_view = findViewById<ImageView>(R.id.picture_view)
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(requestCode == Gallery) {
//            if(resultCode == RESULT_OK) {
//                var dataUri = data?.data
//                try {
//                    println("workfsdjkflsjdklf")
//                    var bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, dataUri)
//                    picture_view.setImageBitmap(bitmap)
//                } catch (e:Exception) {
//                    Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
//                }
//            }
//            else {
//                println("wrong")
//            }
//        }
    }
}