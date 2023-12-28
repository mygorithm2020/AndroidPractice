package com.mygorithm.myOrderDetails;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order")
public class OrderDetail {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int idx_order = 0; //인덱스
    public String platName = ""; // 플랫폼 이름
    public String storeName = ""; // 가게 이름
    public String foodName = "";
    public float score;  //평점
    public String date;  // 날짜
    public String explanation;  //부연 설명

    public int getIdx_order() {
        return idx_order;
    }

    public void setIdx_order(int idx_order) {
        this.idx_order = idx_order;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
