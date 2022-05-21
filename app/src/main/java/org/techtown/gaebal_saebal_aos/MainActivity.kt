package org.techtown.gaebal_saebal_aos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
//import kotlinx.android.synthetic.main.my_log_fragment.*
import kotlinx.android.synthetic.main.fragment_my_log.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // GitHub Api: public인 repository의 pull, issue의 title, created_date, user_name 불러와용갈갈갈
        GithubClient.getApi().getRepos("13wjdgk")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({items ->
                items.forEach {println(it)}
            }, {e ->
                println(e.toString())
            })
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
                    fragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MyInformationFragment()).commit()
                }
                else -> Log.d("test", "error") == 0
            }
            Log.d("test", "final") == 0
        }
    }

    // myLog에서 카테고리를 선택하면 해당 카테고리 프레그먼트로 전환하는 함수
    fun onFragmentChange(index: Int) {
        if(index == 1) {
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, CategoryDetailFragment()).commit()
        }
        // 기록작성 버튼 누르면 기록 작성 페이지로 이동하기 위한 노오력,,중
        if(index == 2) {
            supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, LogWriteFragment()).commit()
            println("wwww")
        }
    }
}