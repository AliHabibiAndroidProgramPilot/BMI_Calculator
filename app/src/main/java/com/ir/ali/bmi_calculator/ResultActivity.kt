package com.ir.ali.bmi_calculator

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ir.ali.bmi_calculator.databinding.ActivityResultBinding
import java.text.DecimalFormat
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val bmiCheck = bmi(intent.getIntExtra("height", 150), intent.getIntExtra("weight", 75))
        when {
            bmiCheck < 18.5 -> {
                binding.bmiStatus.text = "UnderWeight"
                binding.bmiIndex.text = bmiCheck.toString()
                binding.bmiExplanation.text = "Your weight is below the recommended range, Consider healthy ways to gain weight"
                binding.bmiStatus.setTextColor(Color.parseColor("#FF9B2423"))
                binding.bmiStatus.setBackgroundResource(R.drawable.red_statment)
            }
            bmiCheck < 24.9 -> {
                binding.bmiStatus.text = "Healthy Weight"
                binding.bmiIndex.text = bmiCheck.toString()
            }
            bmiCheck < 30.0 -> {
                binding.bmiStatus.text = "Over Weight"
                binding.bmiIndex.text = bmiCheck.toString()
                binding.bmiExplanation.text = "You're overweight. Consider healthy weight loss strategies"
                binding.bmiStatus.setTextColor(Color.parseColor("#FFF9A900"))
                binding.bmiStatus.setBackgroundResource(R.drawable.yellow_statment)
            }
            else -> {
                binding.bmiStatus.text = "Obesity"
                binding.bmiIndex.text = bmiCheck.toString()
                binding.bmiExplanation.text = "Your weight is in the Obese range, Obesity can impact your health condition!"
                binding.bmiStatus.setTextColor(Color.parseColor("#FF9B2423"))
                binding.bmiStatus.setBackgroundResource(R.drawable.red_statment)
            }
        }
        binding.reCalculate.setOnClickListener { finish() }
        setContentView(binding.root)
    }

    private fun bmi(height: Int, weight: Int): Double {
        val heightMeters = height / 100.0
        val bmi: Double = weight / (heightMeters.pow(2))
        return DecimalFormat("#.##").format(bmi).toDouble()
    }
}