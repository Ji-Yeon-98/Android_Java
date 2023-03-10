package com.example.viewbindingexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewbindingexample.databinding.FragTestBinding;

public class TestFragment extends Fragment {

    //xml 파일을 파스칼표기법으로 자동 변환해 바인딩 객체명 자동 세팅
    private FragTestBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = FragTestBinding.inflate(inflater, container, false);
        mBinding.btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.tvFragment.setText("추지연 프래그먼트 클릭!");
            }
        });

        return mBinding.getRoot();

    }
}
