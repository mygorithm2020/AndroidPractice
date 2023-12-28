package com.mygorithm.myOrderDetails;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OrderDetailDao {

    @Insert
    void insertOrder(OrderDetail orderDetail);

    @Update
    void updateOrder(OrderDetail orderDetail);

    @Delete
    void deleteOrder(OrderDetail orderDetail);

//    @Query("SELECT * FROM `order`")
//    LiveData<List<OrderDetail>> getAllOrderList();

    @Query("SELECT * FROM `order`")
    List<OrderDetail> getAll();

    @Query("SELECT * FROM `order` WHERE platName IN (:platnames)")
    List<OrderDetail> getPart(List<String> platnames);

    @Query("SELECT * FROM `order` WHERE (foodName LIKE '%' || (:str) || '%') AND platName IN (:list1)")
    List<OrderDetail> getPartDetail(List<String> list1, String str);
//    storeName LIKE '%' || :str || '%' OR foodName LIKE '%' || :str || '%'

    @Query("SELECT * FROM `order` WHERE storeName LIKE '%' || :search || '%' OR foodName LIKE '%' || :search || '%'")
    List<OrderDetail> getDetailSEL(String search);



//
//    @Query("SELECT * FROM `order`") //쿼리 : 데이터베이스에 요청하는 명령문
//    LiveData<list<OrderDetail>> getAllOrder();
}
