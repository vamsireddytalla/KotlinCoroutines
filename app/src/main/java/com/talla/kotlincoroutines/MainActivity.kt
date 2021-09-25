package com.talla.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.talla.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.math.log
import kotlin.system.measureTimeMillis

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Out Side Coroutine ${Thread.currentThread().name}")
        var jon: Job =GlobalScope.launch {
            var time=measureTimeMillis {
                val val1=doNetworkCall()
                Log.d(TAG, "Out Side Coroutine ${Thread.currentThread().name}")
                Log.d(TAG, "onCreate: $val1")
            }
            Log.d(TAG, "Time in Milli $time")
        }
        Log.d(TAG, "Outsite Coroutine")

    }

    suspend fun doNetworkCall(): String {
        delay(5000L)
        return "Vamsi Network"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "Vamsi2 Network2"
    }

}