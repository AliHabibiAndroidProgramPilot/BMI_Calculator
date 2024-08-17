package com.ir.ali.bmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import com.ir.ali.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.maleCard.setOnClickListener {
            binding.maleCard.setCardBackgroundColor(Color.rgb(51, 50, 68))
            binding.femaleCard.setCardBackgroundColor(Color.rgb(36, 38, 59))
            binding.maleCard.animate().scaleX(1.1f).duration = 300
            binding.maleCard.animate().scaleY(1.1f).duration = 300
            binding.maleCard.animate().translationX(-10f)
            binding.femaleCard.animate().scaleY(1f).duration = 300
            binding.femaleCard.animate().scaleX(1f).duration = 300
        }
        binding.femaleCard.setOnClickListener {
            binding.maleCard.setCardBackgroundColor(Color.rgb(36, 38, 59))
            binding.femaleCard.setCardBackgroundColor(Color.rgb(51, 50, 68))
            binding.femaleCard.animate().scaleX(1.1f).duration = 300
            binding.femaleCard.animate().scaleY(1.1f).duration = 300
            binding.maleCard.animate().scaleY(1f).duration = 300
            binding.maleCard.animate().scaleX(1f).duration = 300
        }
        binding.heightSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.heightNumber.text = "$progress"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }
}