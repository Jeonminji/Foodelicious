package com.example.fd1.Order;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fd1.Order.OrderFragment;
import com.example.fd1.R;

public class OrderActivity extends AppCompatActivity {
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
