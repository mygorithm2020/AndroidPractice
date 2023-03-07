package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class ApiResult(

	@field:SerializedName("Data")
	var data: Any? = null,

	@field:SerializedName("ResultValue")
	val resultValue: String? = null,

	@field:SerializedName("ResultMessage")
	val resultMessage: String? = null,

	@field:SerializedName("ResultCode")
	val resultCode: Int? = null
)