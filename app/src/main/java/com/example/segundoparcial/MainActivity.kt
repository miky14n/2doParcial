package com.example.segundoparcial

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var book_list_rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val restApiAdapter = RestApiAdapter()
        val endPoint = restApiAdapter.connectionApi()
        val bookResponseCall = endPoint.getAllPost()
        bookResponseCall.enqueue( object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response?.body()
                Log.d("RESP POST", Gson().toJson(posts))
                posts?.forEach {
                    Log.d("RESP POST", it.body)
                }

                setContentView(R.layout.activity_main)
                val linearLayoutManager = LinearLayoutManager(applicationContext)
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                book_list_rv = findViewById(R.id.book_list_rv)
                book_list_rv.layoutManager = linearLayoutManager

                book_list_rv.adapter = UserListAdapter(posts as ArrayList<Post>, applicationContext)
            }
        })




    }



}