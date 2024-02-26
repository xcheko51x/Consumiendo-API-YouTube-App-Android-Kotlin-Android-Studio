package com.xcheko51x.youtubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xcheko51x.youtubeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerView()

        viewModel.obtenerVideos()

        viewModel.listaVideos.observe(this) {
            adapter.listaVideos = it
            adapter.notifyDataSetChanged()
        }
    }

    fun setupRecyclerView() {
        binding.rvVideos.layoutManager = LinearLayoutManager(this)
        adapter = VideoAdapter(this, arrayListOf())
        binding.rvVideos.adapter = adapter
    }
}