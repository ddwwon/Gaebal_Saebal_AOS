package org.techtown.gaebal_saebal_aos

import org.techtown.gaebal_saebal_aos.bottom_navigation_fragment.SearchFragment


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.gaebal_saebal_aos.bottom_navigation_fragment.MyInformationFragment
import org.techtown.gaebal_saebal_aos.bottom_navigation_fragment.MyLogFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onResume() {
        super.onResume()
        // 초기 fragment 셋팅: 하단바 fragment(bottom_navigation_frame) 셋팅
        supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation_frame, MyLogFragment()).commit()
        // navigationBottomView 등록: 하단바 fragment id(bottom_navigation) 등록
        transitonNavigationBottomView(bottom_navigation, supportFragmentManager)
    }
    // NavigationBottomView 화면 전환하는 함수.
    fun transitonNavigationBottomView(bottomView: BottomNavigationView, fragmentManager: FragmentManager){
        bottomView.setOnNavigationItemSelectedListener {
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
}