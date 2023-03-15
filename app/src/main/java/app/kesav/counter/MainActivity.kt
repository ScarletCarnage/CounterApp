package app.kesav.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.kesav.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var number: Int = 0
    private var minimumLimit: Int = 0
    private var maximumLimit: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNegative.setOnClickListener {
            if (number > minimumLimit) {
                number--
                binding.tvLabel.text = "$number"
        }
            if (number == minimumLimit) {
                labelColor("#FF0000")
            } else {
                labelColor("#000000")
            }
        }

        binding.btnPositive.setOnClickListener {
            if (number < maximumLimit) {
                number++
                binding.tvLabel.text = "$number"
            }
            if (number == maximumLimit) {
                labelColor("#00FF00")
            } else {
                labelColor("#000000")
            }
        }

        binding.btnReset.setOnClickListener {
            number = 0
            binding.tvLabel.text = "0"
            labelColor("#000000")
        }
    }

    private fun labelColor(colorCode: String) {
        binding.tvLabel.setTextColor(Color.parseColor(colorCode))
    }
}