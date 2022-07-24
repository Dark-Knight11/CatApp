package com.vedantbhamare.catappgdp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vedantbhamare.catappgdp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = APIService.api_instance.getCats()
        call.enqueue(object : Callback<List<CatModel>> {
            override fun onResponse(
                call: Call<List<CatModel>>,
                response: Response<List<CatModel>>
            ) {
                if(response.isSuccessful) {
                    val res = response.body()
                    binding.recyclerView.adapter = res?.let { RecyclerAdapter(it) }
                }
            }

            override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {
                Log.d("API Fetch", "Error while fetching", t)
            }
        })
    }
}