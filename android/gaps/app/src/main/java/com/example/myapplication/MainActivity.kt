package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.Adapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ContainerItemListBinding
import com.example.myapplication.model.RadioItems

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = Adapter()

    companion object {
        var lista = listOf(
            RadioItems("Murillo", false, 1),
            RadioItems("Alopa", true, 2)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        adapter.updateList(
            lista
        )
    }

    override fun onResume() {
        adapter.updateList(
            lista
        )
        super.onResume()
    }
}