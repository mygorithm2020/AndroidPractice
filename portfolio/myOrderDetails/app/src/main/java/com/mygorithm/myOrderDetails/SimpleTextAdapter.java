package com.mygorithm.myOrderDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {

    //private LiveData<List<OrderDetail>> mData = null ;
    private ArrayList<OrderDetail> mData = null ;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6 ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView1 = itemView.findViewById(R.id.text01);
            textView2 = itemView.findViewById(R.id.text02);
            textView3 = itemView.findViewById(R.id.text03);
            textView4 = itemView.findViewById(R.id.text04);
            textView5 = itemView.findViewById(R.id.text05);
            textView6 = itemView.findViewById(R.id.text06);
        }
    }

    //5. 전달 받은 데이터 할당 (SimpleTextAdapter)
    SimpleTextAdapter(ArrayList<OrderDetail> list) {
        mData = list ;
    }

    @NonNull

    @Override
    public SimpleTextAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recyclerview_item_orderdetail, parent, false) ;
        SimpleTextAdapter.ViewHolder vh = new SimpleTextAdapter.ViewHolder(view) ;

        return vh ;
    }

    //6. 데이터 뷰에 할당 (setText)
    @Override
    public void onBindViewHolder(@NonNull  SimpleTextAdapter.ViewHolder holder, int position) {
        OrderDetail od = mData.get(position);
        holder.textView1.setText(Integer.toString(od.getIdx_order()));
        holder.textView2.setText(od.getPlatName());
        holder.textView3.setText(od.getStoreName());
        holder.textView4.setText(od.getFoodName());
        holder.textView5.setText(Float.toString(od.getScore()));
        holder.textView6.setText(od.getDate());
//        OrderDetail od = tt.get(position);
//        int id = od.getIdx_order();
//        String plat = od.getPlatName();
//        holder.textView1.setText(Integer.toString(id));
//        holder.textView2.setText(plat);

//        OrderDetail od = (OrderDetail) mData.getValue()
//        int text = mData.get(position).getIdx_order() ;
//        holder.textView1.setText(Integer.toString(text)) ;

    }

    //전체 데이터 수
    @Override
    public int getItemCount() {
        //  return mData.getValue().size();
//        Log.d("count", String.valueOf(mData.size()));
        return mData.size();
    }
}
