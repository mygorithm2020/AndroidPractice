package com.mygorithm.myOrderDetails;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class FragOrderDetail extends Fragment {
    private View view;

    public OrderDetailDao orderDetailDao;

    RecyclerView recyclerView;

    // 라이브데이터라는거 써보려했는데.. 일단 보류
    LiveData<List<OrderDetail>> livelist;
    List<OrderDetail> arrayList;

    EditText delete_number_edit;

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    RadioButton radioButton1, radioButton2, radioButton3;
    RadioGroup radioGroup;

    List<String> platnamelist;

    //프레그먼트가 교체가 되는거에 있어서 상태 저장
    public static FragOrderDetail newInstance(){
        FragOrderDetail fragOrderDetail = new FragOrderDetail();
        return fragOrderDetail;
    }


    @SuppressLint("WrongThread")
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {


        //2. 비동기로 백그라운드 실행디비용_처음 조회(BackGroundTask)
        BackGroundTask task = new BackGroundTask();
        task.execute();

        view = inflater.inflate(R.layout.frag_orderdetail, container, false);

        List<String> search_li = new ArrayList<>();
        search_li.add("");



        EditText search_name = view.findViewById(R.id.editText_search);
        search_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                println("끝났다는걸 어케 알지?");


            }

            @Override
            public void afterTextChanged(Editable s) {

                //조회 기능 실행
                search_li.set(0, valueOf(search_name.getText()));

                BackGroundTask search_task = new BackGroundTask();
                search_task.execute(platnamelist, search_li);
//                println("텍스트 변화 : "+ start+" "+before+ " " + count);
//                println(search_text_str);
//                BackGroundSpecificSearch search_task = new BackGroundSpecificSearch();
//                search_task.execute(search_text_str);

            }
        });


        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        recyclerView = view.findViewById(R.id.recyclerView_orderdetail);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;

        // checkbox 객체 할당
        checkBox2 = view.findViewById(R.id.checkBox2);
        String checkname2 = checkBox2.getText().toString();
        checkBox3 = view.findViewById(R.id.checkBox3);
        String checkname3 = checkBox3.getText().toString();
        checkBox4 = view.findViewById(R.id.checkBox4);
        String checkname4 = checkBox4.getText().toString();

        platnamelist = new ArrayList<>();

        platnamelist.add(checkname2);
        platnamelist.add(checkname3);
        platnamelist.add(checkname4);

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("배민 클릭");
                if (platnamelist.isEmpty()) {

                }
                if (platnamelist.contains(checkname2)) {
                    platnamelist.remove(checkname2);
                }else {
                    platnamelist.add(checkname2);
                }
                BackGroundTask task_2 = new BackGroundTask();
                if (platnamelist.isEmpty()) {
                    task_2.execute();
                }else {
                    task_2.execute(platnamelist);
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("요기요");
                if (platnamelist.contains(checkname3)) {
                    platnamelist.remove(checkname3);
                }else {
                    platnamelist.add(checkname3);
                }
                BackGroundTask task_2 = new BackGroundTask();
                if (platnamelist.isEmpty()) {
                    task_2.execute();
                }else {
                    task_2.execute(platnamelist);
                }
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("쿠팡이츠 클릭");
                if (platnamelist.contains(checkname4)) {
                    platnamelist.remove(checkname4);
                }else {
                    platnamelist.add(checkname4);
                }
                BackGroundTask task_2 = new BackGroundTask();
                Log.d("empty", platnamelist.toString());
                if (platnamelist.isEmpty()) {
                    task_2.execute();
                }else {
                    task_2.execute(platnamelist);
                }
            }
        });

        


        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        //4. 어댑터에 조회된 결과 전달 (SimpleTextAdapter)
//        SimpleTextAdapter adapter = new SimpleTextAdapter((ArrayList<OrderDetail>) arrayList) ;
//        recyclerView.setAdapter(adapter) ;

//        //삭제 기능 구현된거
//        delete_number_edit = view.findViewById(R.id.order_delete_edit);
//
//        Button delete_button = view.findViewById(R.id.order_delete_button);
//        delete_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BackGroundDelete backGroundDelete = new BackGroundDelete();
//                backGroundDelete.execute();
//                SimpleTextAdapter adapter = new SimpleTextAdapter((ArrayList<OrderDetail>) arrayList) ;
//                recyclerView.setAdapter(adapter) ;
//            }
//        });

        return view;
    }

    class BackGroundSpecificSearch extends AsyncTask<String, Integer, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            if (strings[0].length() != 0) {
                orderDetailDao = OrderDetailDatabase.getInstance(getContext()).orderDetailDao();
                arrayList = orderDetailDao.getDetailSEL(strings[0]);
                Log.d("search", strings[0]);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("search", "여기로 넘어 온거야?");
            SimpleTextAdapter adapter = new SimpleTextAdapter((ArrayList<OrderDetail>) arrayList);
            recyclerView.setAdapter(adapter) ;
        }
    }








    //메인 스레드에서 디비 연결과 관련된게 안되서 백그라운드로 실행
    //3. 비동기로 백그라운드 실행디비용(BackGroundTask)
    // 조회쿼리용
    class BackGroundTask extends AsyncTask<List<String>, Integer, Integer> {



        protected void insertex(){
            //데이터 삽입 코드
            OrderDetail orderDetail = new OrderDetail();

            //예시용 데이터 생성
            orderDetail.setPlatName("배달의 민족");
            orderDetail.setStoreName("팡팡치킨");
            orderDetail.setFoodName("오늘의 치킨");
            orderDetail.setScore(5);
            orderDetail.setDate("2021-12-08");

            //예시용 데이터 삽입 메인스레드에서 불가능... ㅇㅋ?


            for (int i=0; i<10; i++) {
                orderDetailDao.insertOrder(orderDetail);
            }

            //예시용 데이터 생성
            orderDetail.setPlatName("요기요");
            orderDetail.setStoreName("북경반점");
            orderDetail.setFoodName("짜장면");
            orderDetail.setScore(4);
            orderDetail.setDate("2021-12-05");

            //예시용 데이터 삽입 메인스레드에서 불가능... ㅇㅋ?


            for (int i=0; i<10; i++) {
                orderDetailDao.insertOrder(orderDetail);
            }
            //예시용 데이터 생성
            orderDetail.setPlatName("쿠팡이츠");
            orderDetail.setStoreName("피자마루");
            orderDetail.setFoodName("불고기피자");
            orderDetail.setScore(3);
            orderDetail.setDate("2021-12-02");

            //예시용 데이터 삽입 메인스레드에서 불가능... ㅇㅋ?


            for (int i=0; i<10; i++) {
                orderDetailDao.insertOrder(orderDetail);
            }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            SimpleTextAdapter adapter = new SimpleTextAdapter((ArrayList<OrderDetail>) arrayList) ;
            recyclerView.setAdapter(adapter) ;
        }

        @Override
        protected Integer doInBackground(List<String>... lists) {

            orderDetailDao = OrderDetailDatabase.getInstance(getContext()).orderDetailDao();

            //insertex();

            try {
                if (lists[0] != null) {
                    Log.d("select", valueOf(lists[0]));
                    try {
                        Log.d("select", String.valueOf(lists[1]));
                        if (lists[1] != null) {
                            arrayList = orderDetailDao.getPartDetail(lists[0], lists[1].toString());
                            Log.d("select", valueOf(lists[1]));
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                        Log.d("select", String.valueOf(e));
                        arrayList = orderDetailDao.getPart(lists[0]);
                        Log.d("select", valueOf(lists[0]));
                    }
                }
            }catch (Exception e) {
                Log.d("select", "에러난건가?");
                Log.d("select", String.valueOf(e));
                arrayList = orderDetailDao.getAll();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    class BackGroundDelete extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            //삭제 기능
            OrderDetail orderDetail = new OrderDetail();

            for (int k=1; k<22; k++) {
                orderDetail.setIdx_order(k);
                orderDetailDao.deleteOrder(orderDetail);
            }

            arrayList = orderDetailDao.getAll();

            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            SimpleTextAdapter adapter = new SimpleTextAdapter((ArrayList<OrderDetail>) arrayList) ;
            recyclerView.setAdapter(adapter) ;
        }
    }



    public void println(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
