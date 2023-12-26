package com.example.lovecalculator

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter {

    val api = RetrofitClass().api

    lateinit var view: LoveView

    fun attachView(view: LoveView){
        this.view = view
    }

    fun getData(firstName: String, secondName: String) {
        api.getLovePerc(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            view.showResult(it)

                        }
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                }

            })
    }


}