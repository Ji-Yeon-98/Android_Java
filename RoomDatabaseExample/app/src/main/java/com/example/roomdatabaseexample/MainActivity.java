package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "jiyeon_db")
                .fallbackToDestructiveMigration()   //스키마(Database) 버전 변경
                .allowMainThreadQueries()           // Main Thread에서 DB에 IO(입축력)을 가능하게 함
                .build();

        mUserDao = database.userDao(); //인터페이스 객체 할당 (인터페이스 사용할 준비 완료)

        // 데이터 삽입
//        User user = new User(); // 객체 인스턴스 생성
//        user.setName("추지연");
//        user.setAge("26");
//        user.setPhoneNumber("01012345678");
//
//        mUserDao.setInsertUser(user);

        // 데이터 조회
        List<User> userList = mUserDao.getUserAll();

        for (int i = 0; i < userList.size(); i++) {
            Log.d("TEST", userList.get(i).getName() + "\n"
                    + userList.get(i).getAge() + "\n"
                    + userList.get(i).getPhoneNumber() + "\n");
        }


        // 데이터 수정
//        User user2 = new User(); // 객체 인스턴스 생성
//        user2.setId(1);
//        user2.setName("추지연_수정");
//        user2.setAge("20");
//        user2.setPhoneNumber("01012341234");
//        mUserDao.setUpdateUser(user2);


        // 데이터 삭제
        User user3 = new User();
        user3.setId(2);
        mUserDao.setDeleteUser(user3);


    }
}