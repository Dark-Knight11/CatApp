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

        CoroutineScope(Dispatchers.IO).launch {
            val call = APIService.api_instance.getCats()
            if (call.isSuccessful) {
                val cats = call.body()
                withContext(Dispatchers.Main) {
                    binding.recyclerView.adapter = cats?.let { RecyclerAdapter(it) }
                }
            }
        }
    }
}