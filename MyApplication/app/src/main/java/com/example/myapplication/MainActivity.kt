package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigDecimal
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()

    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()
    lateinit var rvPro : RecyclerView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "hello, formicae", Toast.LENGTH_LONG).show()
        main()
        val a :BigDecimal = BigDecimal(200)
        if (a.compareTo(BigDecimal.ZERO) > 0){
            Toast.makeText(this, "0보다 크다 맞나?", Toast.LENGTH_LONG).show()
        }
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            Toast.makeText(this, "버튼이 눌렸어요", Toast.LENGTH_SHORT).show()
            converJsonToObj()
            Handler(Looper.getMainLooper()).postDelayed({}, 1000)
            rvPro = findViewById<RecyclerView>(R.id.rv_profile)

            initRecycler()
        }
    }
    private fun initRecycler(){
        profileAdapter = ProfileAdapter(this)
        rvPro.adapter = profileAdapter

        datas.apply {
            add(ProfileData(name = "asdasd", age = 20, img = R.drawable.ic_launcher_background))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()
        }

    }

    fun converJsonToObj(){
        var jsonString = """{
            "PaymentId": "faf1c3cd01da45478dfffbe12d99eedf",
            "TransactionId": "dbb576f312c64d1985bb09ffbdce8f2f",
            "MemberId": null,
            "Price": 120000.0000,
            "PriceCurrency": "KRW",
            "SaleDateInLocal": "20220318",
            "PaymentDateInLocal": "20220319",
            "PaymentMethod": 1,
            "OpId": "mobile                          ",
            "TransactionDetail": "ResultCode = -1Res_cd = 0000Res_msg = 단독승인 정상Res_msg = 단독승인 정상R_cno = 22031823181110566802R_auth_no = 30141733R_tran_date = 20220318231811R_card_no = 5229710000009095R_issuer_cd = 016R_issuer_nm = KB 다이아몬드R_acquirer_cd = 016R_acquirer_nm = KB국민카드R_install_period = 00R_noint = 00R_canc_acq_date = R_canc_date = ",
            "HashData": "",
            "TransactionKey": "22031823181110566802",
            "StripeId": "AG000004",
            "StripeCustomer": "",
            "PaymentCode": "202",
            "Status": 3,
            "CardNumber": "522971",
            "PaymentName": "KB 다이아몬드",
            "FieldId": "AKG004",
            "ShopId": "                                ",
            "SamePaymentId": "                                ",
            "CheckinMemberId": "e0ac97ac7e2a481a8e316cd431f67bbd",
            "CheckinMemberName": "서복코",
            "CheckinShopId": "                                ",
            "PaymentLocation": 1,
            "CheckinId": "6f2cda6a2f104d5da896337a3b595410",
            "CardPurchaseNo": 2,
            "LastUpdate": "2022-03-19T03:26:40.76",
            "OriginalShopId": "                                ",
            "CreatedDateStr": null,
            "PartnerLink": null
        }"""
        val gson = Gson()
        var testModel = gson.fromJson(jsonString, Payment::class.java)
        println("여기는")
        print("lastUpdate")
        println(testModel.lastUpdate)
        println(testModel.transactionDetail)
        //println(testModel.lastUpdate.toString())
//        paymentList.forEach { payment ->
//            print("lastUpdate")
//            println(payment.lastUpdate.toString())
//        }


    }

    fun retro(){
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:44388")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(API::class.java)
        val request = TeetimeRequestData
        api.getPaymentList(request.setRequestData(arg01 = "qqqq"))
            .enqueue(object : Callback<ApiResult>{
                override fun onFailure(call: Call<ApiResult>, t: Throwable){

                    print("실패함;;")
                    println(t.toString())
                    //todo 실패처리
                    //Log.d(TAG,t.toString())
                }

                override fun onResponse(call: Call<ApiResult>, response: Response<ApiResult>) {
                    TODO("Not yet implemented")
                    if(response.isSuccessful.not()){
                        return
                    }
//                    response.body()?.let{
//                        Log.d(TAG,it.toString())
//
//                        it.data!!.forEach { payment ->
//                            print("lastUpdate")
//                            println(payment.lastUpdate.toString())
//                            Log.d(TAG, payment.lastUpdate.toString())
//                        }
//                    }
                }
            })
    }

    object RetrofitBuilder {
        var api: API

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl("YOUR_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            api = retrofit.create(API::class.java)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun main(){
        var now = LocalDateTime.now()
        println(now)

        println("hello world")
        var name = "John"
        val birthyear = 1975
        var name2 : String = "John"
        val birthyear2 : Int = 1975

        val myNum = 5             // Int
        val myDoubleNum = 5.99    // Double
        val myLetter = 'D'        // Char
        val myBoolean = true      // Boolean
        val myText = "Hello"      // String

        println(name)
        println(birthyear)

        val day = 4

        val result = when (day){
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "Wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            6 -> "Saturday"
            7 -> "Sunday"
            else -> "Invalid day."
        }

        val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
        println(cars[0])
        cars[0] = "Opel"
        println(cars[0])
        println(cars.size)
        if ("Volvo" in cars){
            println("It exists!")
        }else{
            println("It does not exists.")
        }
        for (x in cars){
            println(x)
        }

        val nums = arrayOf(1, 5, 10, 15, "sss")
        for (x in nums){
            println(x)
        }

        for (chars in 'a'..'x'){
            println(chars)
        }

        for (num in 5..15){
            println(nums)
        }

    }
}