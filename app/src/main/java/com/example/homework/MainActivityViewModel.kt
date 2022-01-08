package com.example.homework

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.homework.di.RetroServiceInterface
import com.example.homework.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var mService: RetroServiceInterface

    private lateinit var liveDataList: MutableLiveData<RecyclerList>

    init {
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

    fun makeApicall(list : String) {
        val call: Call<RecyclerList>? = mService.getDataFromAPI(list)
        call?.enqueue(object : Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    Log.e("TAG", "onResponse: +${response.body()}")
                    liveDataList.postValue(response.body())
                } else {
                    Log.e("TAG", "onFailure: ")
                    liveDataList.postValue(null)
                }
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }

}