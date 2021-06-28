package com.febrian.latihanretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.febrian.latihanretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDataActivity : AppCompatActivity() {

    val list : ArrayList<DataResponse> = ArrayList<DataResponse>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RetrofitBuilder.api.getData().enqueue(object : Callback<ArrayList<DataResponse>>{
            override fun onResponse(call: Call<ArrayList<DataResponse>>, response: Response<ArrayList<DataResponse>>) {
                if(response.isSuccessful){
                    for(i in 0..response.body()?.size!!) {
                        val responseBody = response.body()?.get(0)
                        val data = DataResponse(responseBody?.id, responseBody?.title, responseBody?.body)
                        list.add(data)

                        binding.recycleView.setHasFixedSize(true)
                        binding.recycleView.layoutManager = LinearLayoutManager(this@GetDataActivity)
                        binding.recycleView.adapter = DataAdapter(list)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<DataResponse>>, t: Throwable) {
                println("Error ${t.message}")
            }

        })

        binding.btnSwicth.setOnClickListener {
            val intent = Intent(this@GetDataActivity, CreateActivity::class.java)
            startActivity(intent)
        }
    }
}