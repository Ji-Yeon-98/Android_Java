package com.example.fragmentbundleexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {

    private View view;
    private TextView tv_frag1;
    private Button btn_move;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_1, container, false);

        tv_frag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() != null){ //fragment1에서 받아온 값이 빈 값이 아니면

            result = getArguments().getString("fromFrag2"); //프래그먼트1로부터 setArguments된 데이터를 받아옴 (추지연 프래그먼트1)
            tv_frag1.setText(result);

        }

        btn_move.setOnClickListener(new View.OnClickListener() { //프래그먼트 1으로 이동
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); // 무언가를 담을 준비를 할 수 있는 보따리 or 꾸러미
                bundle.putString("fromFrag1", "추지연 프래그먼트1"); //아이디, 값
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction(); //transaction : 프래그먼트 관리하는 것 (교체, 가져오기, 현재 값들 검사)

                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle); //번들에 담았던 꾸러미 fragment에 넣어서 넘겨줌
                transaction.replace(R.id.framelayout, fragment2); //교체할 화면의 영역, 교체할 화면
                transaction.commit(); // fragment 상태 저장
            }
        });

        return view;
    }
}
