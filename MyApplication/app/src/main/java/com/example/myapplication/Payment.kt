package com.example.myapplication

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.LocalDateTime

data class Payment (
    @field:SerializedName("PaymentId")
    val paymentId: String? = null,
    @field:SerializedName("TransactionId")
    val transactionId: String? = null,
    @field:SerializedName("MemberId")
    val memberId: String? = null,
    @field:SerializedName("Price")
    var price: BigDecimal? = BigDecimal.ZERO,
    @field:SerializedName("PriceCurrency")
    val priceCurrency: String? = null,
    @field:SerializedName("SaleDateInLocal")
    val saleDateInLocal: String? = null,
    @field:SerializedName("PaymentDateInLocal")
    val paymentDateInLocal: String? = null,
    @field:SerializedName("PaymentMethod")
    val paymentMethod: Int? = 0,
    @field:SerializedName("OpId")
    val opId: String? = null,
    @field:SerializedName("TransactionDetail")
    val transactionDetail: String? = null,
    @field:SerializedName("HashData")
    val hashData: String? = null,
    @field:SerializedName("TransactionKey")
    val transactionKey: String? = null,
    @field:SerializedName("StripeId")
    val stripeId: String? = null,
    @field:SerializedName("StripeCustomer")
    val stripeCustomer: String? = null,
    @field:SerializedName("PaymentCode")
    val paymentCode: String? = null,
    @field:SerializedName("Status")
    val status: Int? = 0,
    @field:SerializedName("CardNumber")
    val cardNumber: String? = null,
    @field:SerializedName("PaymentName")
    val paymentName: String? = null,
    @field:SerializedName("ShopId")
    val shopId: String? = null,
    @field:SerializedName("SamePaymentId")
    val samePaymentId: String? = null,
    @field:SerializedName("CheckinMemberId")
    val checkInMemberId: String? = null,
    @field:SerializedName("CheckinMemberName")
    val checkInMemberName: String? = null,
    @field:SerializedName("CheckinShopId")
    val checkInShopId: String? = null,
    @field:SerializedName("MemberName")
    val memberName: String? = null,
    @field:SerializedName("PaymentLocation")
    val paymentLocation: String? = null,
    @field:SerializedName("CheckinId")
    val checkInId: String? = null,
    @field:SerializedName("LastUpdate")
    val lastUpdate: String? = null,
    var checked: Boolean = false,
    var color: String = "#ffffff"
)