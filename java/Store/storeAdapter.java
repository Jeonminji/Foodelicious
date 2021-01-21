package com.example.fd1.Store;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class storeAdapter extends FragmentPagerAdapter {
    public storeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { // Fragment 인스턴스 각각 불러옴
        switch (position) {
            case 0:
                return store_info.newInstace();
            case 1:
                return store_menu.newInstace();
            case 2:
                return store_review.newInstace();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { // 상단에 탭 레이아웃 텍스트 선언
        switch (position) {
            case 0:
                return "홈";
            case 1:
                return "메뉴";
            case 2:
                return "리뷰";
            default:
                return null;
        }
    }
}
