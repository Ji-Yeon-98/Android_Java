package com.example.roomdatabaseexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//추상클래스
//version : 데이터 베이스 변경사항을 관리하기 위해 사용
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    // 만든 인터페이스 선언
    public abstract UserDao userDao();

}
