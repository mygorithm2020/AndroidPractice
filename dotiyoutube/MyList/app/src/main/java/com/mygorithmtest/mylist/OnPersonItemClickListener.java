package com.mygorithmtest.mylist;

import android.view.View;

//클릭했을 떄 동작하게 만들기 아이템 하나를
public interface OnPersonItemClickListener {

    public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position);
}
