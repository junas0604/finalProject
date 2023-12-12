package com.gutib.junas.nazarito.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gutib.junas.nazarito.finalproject.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AddReflection.setOnClickListener {
            val intent = Intent(this, AddReflection::class.java)
            startActivity(intent)
        }
        binding.SetReminder.setOnClickListener {
            val intent = Intent(this, SetReminderForDailyMind::class.java)
            startActivity(intent)
        }
        binding.TrackProgress.setOnClickListener {
            val intent = Intent(this, ProgressTrack::class.java)
            startActivity(intent)
        }
        binding.Categorize.setOnClickListener {
            val intent = Intent(this, CategorizeReflection::class.java)
            startActivity(intent)
        }

        binding.Exit.setOnClickListener {
            finish()
        }
    }
}
