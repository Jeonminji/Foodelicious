package com.example.fd1.Store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fd1.R;

public class store_info extends Fragment {
    private View view;

    public static store_info newInstace() {
        store_info store_info = new store_info();
        return store_info; // 어댑터와 같이 맞물려서 통신하는 부분, 어댑터에 맞춰서 주기적으로 인스턴스 생성
    }

    @Nullable
    @Override // 연동이 완료된 상황 onCreateView만 하면
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.store_info, container, false);

        return view;
    }
}
