package com.gutib.junas.nazarito.finalproject

import Adapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.gutib.junas.nazarito.finalproject.databinding.ActivityCategorizeReflectionBinding
import org.json.JSONArray

class CategorizeReflection : AppCompatActivity() {
    private lateinit var binding: ActivityCategorizeReflectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorizeReflectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchReflections("")


        binding.searchMoodInput.addTextChangedListener { text ->
            searchReflections(text.toString())
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }

    private fun searchReflections(searchMoodInput: String) {
        val reflectionsList = loadReflections(searchMoodInput)
        setupRecyclerView(reflectionsList)
    }

    private fun loadReflections(searchMoodInput: String): List<String> {
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val reflectionsJson = sharedPreferences.getString("reflections", "[]")
        val reflectionsArray = JSONArray(reflectionsJson)
        var reflectionsList = mutableListOf<String>()

        for (i in 0 until reflectionsArray.length()) {
            val reflection = reflectionsArray.getJSONObject(i)
            val mood = reflection.getString("mood")
            val text = reflection.getString("reflection")
            reflectionsList.add("$mood: $text")
        }

        if (searchMoodInput.isNotBlank()) {
            reflectionsList = reflectionsList.filter {
                it.startsWith("$searchMoodInput: ", ignoreCase = true)
            }.toMutableList()
        }

        return reflectionsList
    }
    private fun setupRecyclerView(reflections: List<String>) {
        val adapter = Adapter(reflections)
        binding.reflectionOutput.layoutManager = LinearLayoutManager(this)
        binding.reflectionOutput.adapter = adapter
    }


}
