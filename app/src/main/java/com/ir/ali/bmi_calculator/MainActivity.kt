package com.ir.ali.bmi_calculator

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ir.ali.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
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
        binding.weightDecrease.setOnClickListener {
            binding.weightNumber.text =
                (binding.weightNumber.text.toString().toInt() - 1).toString()
        }
        binding.weightDecrease.setOnLongClickListener {
            consistDecrease(binding.weightNumber, binding.weightDecrease)
            true
        }
        binding.weightAdd.setOnClickListener {
            binding.weightNumber.text =
                (binding.weightNumber.text.toString().toInt() + 1).toString()
        }
        binding.weightAdd.setOnLongClickListener {
            consistIncrease(binding.weightNumber, binding.weightAdd)
            true
        }
        binding.ageDecrease.setOnClickListener {
            binding.ageNumber.text = binding.ageNumber.text.toString().toInt().minus(1).toString()
        }
        binding.ageDecrease.setOnLongClickListener {
            consistDecrease(binding.ageNumber, binding.ageDecrease)
            true
        }
        binding.ageAdd.setOnClickListener {
            binding.ageNumber.text = (binding.ageNumber.text.toString().toInt() + 1).toString()
        }
        binding.ageAdd.setOnLongClickListener {
            consistIncrease(binding.ageNumber, binding.ageAdd)
            true
        }
        binding.calculateBottom.setOnClickListener {
            binding.fragment.visibility = View.VISIBLE
        }
    }

    private val handler = Handler()
    private val delayMillis: Long = 100

    private fun consistIncrease(textView: TextView, button: FloatingActionButton) {
        var runnable: Runnable? = null
        runnable = Runnable {
            if(button.isPressed) {
                val tempNumber = textView.text.toString().toInt()
                val tempText = tempNumber.plus(1).toString()
                handler.postDelayed(runnable!!, delayMillis)
                textView.text = tempText
            }
        }
        handler.post(runnable)
    }

    private fun consistDecrease(textView: TextView, button: FloatingActionButton) {
        var runnable: Runnable? = null
        runnable = Runnable {
            if(button.isPressed) {
                val tempNumber = textView.text.toString().toInt()
                val tempText = tempNumber.minus(1).toString()
                handler.postDelayed(runnable!!, delayMillis)
                textView.text = tempText
            }
        }
        handler.post(runnable)
    }
}