package com.mygorithmtest.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    TextView textView;

    SQLiteDatabase database;
    String tableName;

    int age = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView);

        // 만약 기존에 데이터베이스가 있는지 혹은 칼럼을 추가하고 싶거나 할때는 sqlite helper 사용
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = editText.getText().toString();
                createDatabase(databaseName);

            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = editText2.getText().toString();
                createTable(tableName);

            }
        });
        
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insetRecord();
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeQuery();
            }
        });
    }
    public void println(String data) {
        textView.append(data + "\n");
    }
    public void createDatabase(String databaseName) {
        println("createDatabase 호출됨");
//       MODE_PRIVATE: 접근 권한을 어디까지 결정
        try {
            database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
            println("데이터 베이스 생성됨 : "+ databaseName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void createTable(String tableName) {
        println("createTable 호출됨");
        try {
            if (database==null) {
                println("데이터 베이스를 먼저 열어주세요.");
                return;
            }
            String sql = "create table if not exists " + tableName + "(" +
                    "_id integer PRIMARY KEY autoincrement," +
                    "name text," +
                    "age integer," +
                    "mobile text)";
            database.execSQL(sql);
            println("테이블 생성됨: " +tableName);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void insetRecord() {
        println("insertRecord 호출됨");

        try {
            if (database == null) {
                println("데이터베이스를 먼저 열어주세요.");
                return;
            }
            if (tableName == null) {
                println("테이블 이름을 입력하세요");
                return;
            }
            String sql = "insert into " + tableName + "(name, age, mobile) " +
                    "values ('john', "+age+", '010-1111-2222')";
            age ++;
            database.execSQL(sql);
            println("레코드 추가함");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(){
        println("executeQuery 호출됨");

        try {
            if (database == null) {
                println("데이터베이스를 먼저 열어주세요.");
                return;
            }
            if (tableName == null) {
                println("테이블 이름을 입력하세요");
                return;
            }

            String sql = "select * from "+tableName;
            Cursor cursor = database.rawQuery(sql, null);
            int recordCount = cursor.getCount();
            println("레코드 수: "+ recordCount);
            for (int i=0; i<recordCount; i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                String mobile = cursor.getString(3);
                println("레코드 # " +i + ": "+ id + ","+ name + ", "+ age + ", "+ name);
            }
            cursor.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}