package com.example.ruchika_apptask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.telecom.Call
import android.util.Log
import com.example.ruchika_apptask2.databinding.ActivityMainBinding
import retrofit2.Response

import retrofit2.Call
//import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("agents")
    fun getValorant(): retrofit2.Call<Valomodel>

    @GET("player cards")
    fun getValo(): retrofit2.Call<Valomodel>
}

object APIService {
    val api_Instance: ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dash.valorant-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api_Instance = retrofit.create(ApiInterface::class.java)
    }
}

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = APIService.api_Instance.getValorant()
        call.enqueue(object :Call<Valomodel>{
            fun onResponse(
                call: Call<Valomodel>,
                response: Response<Valomodel>)
            {
                if(response.isSuccessful) {
                    val res = response.body()
                    binding.recyclerView.adapter = res?.let { RecyclerAdapter(it) }
                }
            }
            fun onFailure(call: Call<Valomodel>, t:Throwable){
                Log.d("API Fetch", "Error while Fetching", t)
            }

            override fun enqueue(callback: retrofit2.Callback<Valomodel>) {
                TODO("Not yet implemented")
            }
        })
    }
}

private fun <T> Call<T>.enqueue(call: Call<T>) {

}
