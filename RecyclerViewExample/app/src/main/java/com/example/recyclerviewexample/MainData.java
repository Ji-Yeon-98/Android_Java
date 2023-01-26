package com.example.recyclerviewexample;

//custom class 만들기
public class MainData {

    //필요한 변수 모두 입력
    private int iv_profile;
    private String tv_name;
    private String tv_content;


    //Alt+Insert 키 -> Constructor (생성자, 간결하고 직관적으로 인스턴스 초기화)
   public MainData(int iv_profile, String tv_name, String tv_content) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }


    //Alt+Insert 키 -> Getter and Setter (변수 세팅 함수 생성)
    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
