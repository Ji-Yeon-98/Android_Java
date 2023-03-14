package com.example.roomdatabaseexample;

//Data Access Object

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert //삽입
    void setInsertUser(User user);

    @Update //수정
    void setUpdateUser(User user);

    @Delete //삭제
    void setDeleteUser(User user);

    //조회 쿼리
    //쿼리 : 데이터베이스에 요청하는 명령문
    @Query("SELECT * FROM User")
    List<User> getUserAll();
}
