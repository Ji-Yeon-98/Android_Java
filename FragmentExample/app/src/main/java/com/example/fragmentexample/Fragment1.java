package com.example.fragmentexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    //클래스의 메소드와 필드를 사용하기 위해서 객체 생성
    public Fragment1(){

    }

    @Nullable
    @Override
    //ctr + o => 생명주기, Fragment에서 실행될 때
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //xml로 정의된 view를 실제 객체화
        return inflater.inflate(R.layout.fragment1, container, false);
    }
}
