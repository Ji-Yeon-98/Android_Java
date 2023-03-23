package com.example.firebaseemailaccount;

/**
 * 사용자 계정 정보 모델 클래스
 */

public class UserAccount {

    private String idToken;     //Firebase Uid (고유 토큰 정보, 사용자 하나의 계정만 고유하게 가지고 있는 키값)
    private String emailId;     //이메일 아이디
    private String password;    //비밀번호

    //클래스에서 생성될 때 빈생성자 만들기
    public UserAccount() {
    }

    //이메일과 비밀번호를 가져오고 모델 클래스에 set을 하기 위한 getter and setter
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
