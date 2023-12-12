package com.gutib.junas.nazarito.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gutib.junas.nazarito.finalproject.databinding.ActivityProgressTrackBinding

class ProgressTrack : AppCompatActivity() {
    private lateinit var binding: ActivityProgressTrackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProgressTrackBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}