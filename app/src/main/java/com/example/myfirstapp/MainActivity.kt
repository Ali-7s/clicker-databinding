package com.example.myfirstapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val count = ObservableInt(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.counter = count
        binding.lifecycleOwner = this

        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, "", duration)

        val firstButton = binding.button1
        val secondButton = binding.button2
        val resetButton = binding.button3
        firstButton.text = getString(R.string.increment)
        secondButton.text = getString(R.string.decrement)
        resetButton.text = getString(R.string.reset)


        firstButton.setOnClickListener {
            val prevCount = count.get()
            count.set(count.get() + 1)
            toast.setText("Incremented! " + prevCount + " -> " + count.get())
            toast.show()
        }

        secondButton.setOnClickListener {
            val prevCount = count.get()
            count.set(count.get() - 1)
            toast.setText("Decremented! " + prevCount + " -> " + count.get())
            toast.show()
        }

        resetButton.setOnClickListener {
            val prevCount = count.get()
            count.set(0)
            toast.setText("Reset! " + prevCount + " -> " + count.get())
            toast.show()
        }
    }
}
