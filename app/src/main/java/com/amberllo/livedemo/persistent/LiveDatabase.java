package com.amberllo.livedemo.persistent;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.amberllo.livedemo.persistent.dao.UserDao;
import com.amberllo.livedemo.persistent.entity.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class LiveDatabase extends RoomDatabase {


    private static LiveDatabase INSTANCE;
    private static final Object sLock = new Object();

    public static LiveDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), LiveDatabase.class, "test.db")
                                .allowMainThreadQueries()
                                .build();
            }
            return INSTANCE;
        }
    }

    public abstract UserDao userDao();
}
