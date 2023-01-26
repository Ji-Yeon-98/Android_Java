package com.example.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//adapter란 데이터 테이블을 목록으로 보여주기 위해 사용
//데이터를 다양한 형식의 리스트로 보여주기 위해 데이터와 리스트 뷰 사이에 존재하는 객체 (MainData와 MainActivity 사이)
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    //MainData 형태의 배열 리스트 선언
    private ArrayList<MainData> arrayList;

    //Alt + Insert => Constructor 생성자 선언
    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    //처음으로 생성될 때 생성주기
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //xml에 정의된 내용을 view객체로 반환
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        //holder에 view 넣어주기
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    //실제 추가될 때
    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int i) {
        //arraylist로부터 그 위치에서 이미지 뷰를 가져와라
        holder.iv_profile.setImageResource(arrayList.get(i).getIv_profile());
        //arraylist로부터 그 위치에서 이름 텍스트를 가져와라
        holder.tv_name.setText(arrayList.get(i).getTv_name());
        //arraylist로부터 그 위치에서 내용 텍스트를 가져와라
        holder.tv_content.setText(arrayList.get(i).getTv_content());

        //리스트뷰 클릭
        holder.itemView.setTag(i); //포지션 값 가져오기
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 클릭한 아이템 이름 가져옴
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        //리스트뷰 롱클릭
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //holder 위치값 받아와서 지우기
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    //arraylist가 비어있지 않으면 arraylist.size 반환 비어있으면 0 반환
    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try{
            arrayList.remove(position); //위치에 있는 arraylist 지우기
            notifyItemRemoved(position); //새로고침 => 실제 반영
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace(); //예외처리
        }
    }

    //viewholder : 각 뷰들을 보관하는 holder 객체 (개별 아이템에 대한 view)
    //반복적으로 호출되는 메서드를 뷰 홀더에 보관해서 효과적으로 사용
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        //protected : 같은 패키지 or 자식 클래스에서 사용
        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            //???
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);

        }
    }
}
