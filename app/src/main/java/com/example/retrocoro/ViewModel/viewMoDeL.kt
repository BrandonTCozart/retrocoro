package com.example.retrocoro.ViewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrocoro.Classes.primary
import com.example.retrocoro.Classes.result
import com.example.retrocoro.Interface.RetrofitEndpoints
import com.example.retrocoro.RetrofitObject
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import retrofit2.create

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewMoDeL:ViewModel() {


    val primary: MutableLiveData<List<result>> by lazy {
        MutableLiveData<List<result>>()
    }



    fun doTheWork(context:Context?){
        //var quotesCall = RetrofitObject.getInstance().create(RetrofitEndpoints::class.java)

        viewModelScope.launch(Dispatchers.IO) {
            var quotesCall = RetrofitObject.getInstance().create(RetrofitEndpoints::class.java)
            //var call = quotesCall.getQuotes().body()?.results
            Log.d("working","Working")
            primary.postValue(quotesCall.getQuotes().body()?.results)
            //Log.d("working",quotesCall.getQuotes().body()?.results.toString())
        }
    }








}