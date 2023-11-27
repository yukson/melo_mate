package org.techtown.melomate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> fragments = new ArrayList<Fragment>();


    public PageAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;

    }

    private static final int NUM_PAGES = 3;

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        int centeredPosition = position - 1;
        if (centeredPosition < 0) {
            centeredPosition += NUM_PAGES;
        }



        switch (centeredPosition) {
            case 0:
                return new FirstFragment();
            case 1:
                return new ThirdFragment();
            case 2:
                return new SecondFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
