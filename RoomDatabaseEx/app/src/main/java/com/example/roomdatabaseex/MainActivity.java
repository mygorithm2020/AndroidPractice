package com.example.roomdatabaseex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;
    public Button button, button2;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "smileman_db")
                .fallbackToDestructiveMigration()   //스키마 버전 변경 가능
                .allowMainThreadQueries()       //  Main Thread에서 DB에 IO 가능하게함
                .build();

        mUserDao = database.userDao();
        textView = findViewById(R.id.text01);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Toast.makeText(this, "이거 되는건가요?", Toast.LENGTH_SHORT).show();

            textView.setText(null);


            //데이터 삽입

            User user = new User();
            user.setName("스마일 맨");
            user.setAge("28");
            user.setPhoneNumber("01055554444");

            mUserDao.setInserUser(user);

            List<User> userList = mUserDao.getUserAll();
            // 데이터 조회
            for (int i = 0; i < userList.size(); i++) {
                Log.d("test", userList.get(i).getName() + "\t"
                        + userList.get(i).getAge() + "\t"
                        + userList.get(i).getPhoneNumber() + "\t"
                        + userList.get(i).getId() + "\n");

                textView.append(userList.get(i).getName() + "\t"
                        + userList.get(i).getAge() + "\t"
                        + userList.get(i).getPhoneNumber() + "\t"
                        + userList.get(i).getId() + "\n");
            }

        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            //데이터 삭제
            User user3 = new User();
            user3.setId(3);

            mUserDao.setDeleteUser(user3);
        });



//        //  데이터 수정
//        User user2 = new User();
//        user2.setId(1);
//        user2.setName("스마일 맨_수정");
//        user2.setAge("22");
//        user2.setPhoneNumber("01012345678");
//
//        mUserDao.setUpdateUser(user2);
//
//

    }
}