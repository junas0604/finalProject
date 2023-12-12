package com.gutib.junas.nazarito.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gutib.junas.nazarito.finalproject.databinding.ActivityCategorizeReflectionBinding

class CategorizeReflection : AppCompatActivity() {
    private lateinit var binding: ActivityCategorizeReflectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategorizeReflectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)






    }
}