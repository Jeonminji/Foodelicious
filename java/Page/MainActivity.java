package com.example.fd1.Page;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fd1.Page.home_mypage;
import com.example.fd1.Page.home_page;
import com.example.fd1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());


                return true;
            }
        });
        mBottomNV.setSelectedItemId(R.id.home);




    }

    private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.home) {
                fragment = new home_page();
                String ad1 = getIntent().getStringExtra("address1");
                Bundle bundle = new Bundle();
                bundle.putString("address", ad1);

                fragment.setArguments(bundle);


            } else if (id == R.id.order) {

               // fragment = new home_order_page();
            } else {
                fragment = new home_mypage();
                String c_id = getIntent().getStringExtra("c_id");
                String c_pw = getIntent().getStringExtra("c_pw");
                String c_name = getIntent().getStringExtra("c_name");
                String c_phone = getIntent().getStringExtra("c_phone");
                Bundle bundle = new Bundle();
                bundle.putString("c_id",c_id);
                bundle.putString("c_pw",c_pw);
                bundle.putString("c_name",c_name);
                bundle.putString("c_phone",c_phone);
                fragment.setArguments(bundle);

            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();


    }
}
