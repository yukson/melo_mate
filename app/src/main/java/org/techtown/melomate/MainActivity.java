package org.techtown.melomate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PageAdapter pageAdapter;

    ViewPager2 viewPager2;

    ArrayList<Fragment> fragList = new ArrayList<Fragment>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Base_Theme_MeloMate); // 기본 테마 설정

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);

        // 프래그먼트 선언
        FirstFragment fragment1 = new FirstFragment();
        SecondFragment fragment2 = new SecondFragment();
        ThirdFragment fragment3 = new ThirdFragment();

        // 프래그먼트 리스트에 등록
        fragList.add(fragment1);
        fragList.add(fragment2);
        fragList.add(fragment3);

        // 어댑터에 리스트 등록
        pageAdapter = new PageAdapter(this, fragList);

        // 어댑터 뷰페이저에 적용
        viewPager2.setAdapter(pageAdapter);

        // 화면 표시 적용
        DotsIndicator indicator = findViewById(R.id.dots_indicator);

        indicator.setViewPager2(viewPager2);
    }
}