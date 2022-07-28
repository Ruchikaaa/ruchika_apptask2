package com.example.ruchika_apptask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ruchika_apptask2.databinding.ActivityMainBinding

class ValoInfo : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valomodel= intent.getParcelableExtra<Valomodel>("ValoInfo")
        val imgUrl = intent.getStringExtra("img")

        binding.name.text = Valorant?.name
        binding.description.text = Valorant?.description

        Glide.with(this).load(imgUrl).into(binding.img)
    }
}