package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new MainRecyclerViewAdapter());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
    private static class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewViewHolder>{
        @Override
        public MainRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
            return new MainRecyclerViewViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MainRecyclerViewViewHolder holder, int position){
            holder.setTitle((position+1)+"번째 아이템입니다.");

        }
        @Override
        public int getItemCount(){
            return 10;
        }
    }
    private static class MainRecyclerViewViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;

        public MainRecyclerViewViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
        public void setTitle(String title){
            this.title.setText(title);
        }

    }

    private static class DivideDecoration extends RecyclerView.ItemDecoration{
        private final Paint paint = null;
        paint.setStrokeWidth(context.getResources().getDisplayMetrics().density*5);
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent,RecyclerView.State state){
        for(int i=0; i <parent.getChildCount(); i++){
            final View view = parent.getChildAt(i);
            c.drawLine(view.getLeft(), view.getBottom(), view.getRight(), view.getBottom(), paint);
        }
    }
}