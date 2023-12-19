package com.gutib.junas.nazarito.finalproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gutib.junas.nazarito.finalproject.databinding.ActivityAddReflectionBinding
import org.json.JSONArray
import org.json.JSONObject

class AddReflection : AppCompatActivity() {
    private lateinit var binding: ActivityAddReflectionBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddReflectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        binding.back.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        binding.Submit.setOnClickListener {
            val moodText = binding.moodInput.text.toString()
            val reflectionText = binding.reflectionInput.text.toString()
            saveReflectionToPreferences(moodText,reflectionText)
            binding.reflectionInput.text.clear()
            binding.moodInput.text.clear()
        }
    }

    private fun saveReflectionToPreferences(moodText: String, reflectionText: String) {
        val reflectionsJson = sharedPreferences.getString("reflections", "[]")
        val reflectionsArray = JSONArray(reflectionsJson)

        val newReflection = JSONObject().apply {
            put("mood", moodText)
            put("reflection", reflectionText)
        }

        reflectionsArray.put(newReflection)

        val editor = sharedPreferences.edit()
        editor.putString("reflections", reflectionsArray.toString())
        editor.apply()
    }
}
