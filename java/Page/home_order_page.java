package com.example.fd1.Page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fd1.Order.OrderFragment;
import com.example.fd1.R;

public class home_order_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_order_page);
        if(findViewById(R.id.activity_order) != null) {
            OrderFragment orderFragment = new OrderFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_order, orderFragment).commit();
        }
    }
}