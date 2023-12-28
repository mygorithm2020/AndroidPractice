package com.mygorithmtest.mylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                showToast("아이템 선택됨 : "+ item.getName());
            }
        });

        adapter.addItem(new Person("김민수", "010-1546-4598"));
        adapter.addItem(new Person("김하늘", "010-1478-5852"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        adapter.addItem(new Person("홍길동", "010-1244-5155"));
        recyclerView.setAdapter(adapter);

    }

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}