package com.example.fd1.Page;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fd1.Consumer.c_location;
import com.example.fd1.R;

import static android.content.Context.MODE_PRIVATE;

public class home_page extends Fragment {



    private TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.home_page, container, false);
        textView = (TextView)v.findViewById(R.id.location_text);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), c_location.class);
                startActivity(intent);

            }
        });


        return v;

    }


    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();

        if(bundle!= null){
            String address = bundle.getString("address");
            textView.setText(String.format("%s",address));
            if(address == null){
                textView.setText("위치");
            }
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}