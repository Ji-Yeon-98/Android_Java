package com.example.roomdatabaseexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//User라는 데이터 모델로 만들기 위해 id, name, age등등의 데이터들이 필요하기 때문에 데이터베이스에 대한 모델
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id = 0; //하나의 사용자에 대한 고유 ID 값값

    private String name;

    private String age;

    private String phoneNumber;

    //getter & setter : 가져오거나 .. 세팅을 하기위한 준비단계

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}