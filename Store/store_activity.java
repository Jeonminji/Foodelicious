package com.example.fd1.Store;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fd1.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;

public class store_activity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        // 뷰페이저 세팅
        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new storeAdapter(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
