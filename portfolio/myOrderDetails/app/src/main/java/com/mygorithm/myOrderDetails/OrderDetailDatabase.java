package com.mygorithm.myOrderDetails;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {OrderDetail.class}, version=1)
public abstract class OrderDetailDatabase extends RoomDatabase {
    public abstract OrderDetailDao orderDetailDao();

    private static OrderDetailDatabase mAppDatabase;

    // 싱글튼 패턴을 유지해야 데이터의 일치성을 보장할 수 있다
    public static OrderDetailDatabase getInstance(Context context) {
        if(mAppDatabase==null){
            mAppDatabase = Room.databaseBuilder(context.getApplicationContext()
                    ,OrderDetailDatabase.class
                    ,"my_db")
                    .build();
        }
        return mAppDatabase;
    }


}
