package com.example.fd1.Page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.example.fd1.R;

public class home_mypage extends Fragment {
    TextView id, pw, name, phone;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v =inflater.inflate(R.layout.home_mypage, container, false);

        id = (TextView)v.findViewById(R.id.c_id);
        pw= (TextView)v.findViewById(R.id.c_pass);
        name = (TextView)v.findViewById(R.id.c_name);
        phone = (TextView)v.findViewById(R.id.c_phone);
        Bundle bundle = getArguments();
        if(bundle!= null){
            String c_id = bundle.getString("c_id");
            String c_pw = bundle.getString("c_pw");
            String c_name = bundle.getString("c_name");
            String c_phone = bundle.getString("c_phone");
            id.setText(c_id);
           pw.setText(c_pw);
            name.setText(c_name);
            phone.setText(c_phone);
        }

        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
