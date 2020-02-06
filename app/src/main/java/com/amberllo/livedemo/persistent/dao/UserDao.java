package com.amberllo.livedemo.persistent.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.amberllo.livedemo.persistent.entity.User;

@Dao
public interface UserDao {

    @Query("select * from User where userId = :userId")
    User queryById(String userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

//    @Update(onConflict = 1)
//    void updateUser(User user);

}
