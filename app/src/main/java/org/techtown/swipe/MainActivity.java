package org.techtown.swipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Base_Theme_Swipe); //splash 추가 코드 theme_MeloMate랑 BASE_theme_Melomate랑 뭔 차이인거지?

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setCurrentItem(1);
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {

        private static final int NUM_PAGES = 3;

        MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            // 첫 번째 페이지를 중심으로 페이지 이동 순환
            int centeredPosition = position - 1;
            if (centeredPosition < 0) {
                centeredPosition += NUM_PAGES;
            }
            switch (centeredPosition) {
                case 0:
                    return FirstFragment.newInstance();
                case 1:
                    return ThridFragment.newInstance();
                case 2:
                    return SecondFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}