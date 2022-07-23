package com.vedantbhamare.catappgdp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vedantbhamare.catappgdp.databinding.ActivityCatInfoBinding


class CatInfo : AppCompatActivity() {
    private lateinit var binding: ActivityCatInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cat =  intent.getParcelableExtra<CatModel>("catinfo")
        val imgUrl = intent.getStringExtra("imgUrl")

        Glide.with(this).load(imgUrl).into(binding.img)
        binding.name.text = "Name: ${cat?.name}"
        binding.description.text = "Decription: ${cat?.description}"
        binding.origin.text = "Origin: ${cat?.origin}"
        binding.temparament.text = "Temparament: ${cat?.temperament}"
        binding.lifeSpan.text = "Life-Span: ${cat?.lifeSpan}"
    }
}