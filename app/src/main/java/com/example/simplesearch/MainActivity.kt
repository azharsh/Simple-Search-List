package com.example.simplesearch

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter

    var rec: RecyclerView? = null
    var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnSearch)
        val edt = findViewById<EditText>(R.id.edtSearch)

        progress = findViewById(R.id.proGress)
        rec = findViewById(R.id.rec_list)


        btn.setOnClickListener {
            getData(edt.text.toString())
        }

    }

    private fun getData(input: String) {
        progress?.visibility = View.VISIBLE

        val service: ApiService? = ApiClientIntance.getRetrofitInstance()?.create(
            ApiService::class.java
        )


        val call: Call<APIResponse>? = service?.getAllNews(
            input, "2021-01-11", "publishedAt", "8bd5b06635c340568d0d2faaa720c8bb"
        )
        call?.enqueue(object : Callback<APIResponse> {
            override fun onResponse(
                call: Call<APIResponse>,
                response: Response<APIResponse>
            ) {
                setList(response.body())
                progress?.visibility = View.GONE
                showToast("Success")
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                progress?.visibility = View.GONE
                showToast(t.message.toString())
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    private fun setList(body: APIResponse?) {
        mainAdapter = body?.let { MainAdapter(it.articles, this) }!!
        rec?.adapter = mainAdapter
        rec?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }


}