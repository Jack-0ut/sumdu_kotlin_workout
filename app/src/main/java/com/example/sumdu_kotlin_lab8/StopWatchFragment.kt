package com.example.sumdu_kotlin_lab8

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

/**
 * A simple [Fragment] subclass that represents a stopwatch with start, stop, and reset buttons.
 */
class StopWatchFragment : Fragment() {

    private lateinit var stopwatchDisplay: TextView
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button

    private var startTime = 0L
    private var elapsedTime = 0L
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())

    /**
     * Runnable to update the stopwatch display every second while the stopwatch is running.
     */
    private val updateStopwatch = object : Runnable {
        override fun run() {
            if (isRunning) {
                elapsedTime = SystemClock.elapsedRealtime() - startTime
                val seconds = (elapsedTime / 1000) % 60
                val minutes = (elapsedTime / (1000 * 60)) % 60
                val hours = (elapsedTime / (1000 * 60 * 60)) % 24

                stopwatchDisplay.text = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)

                handler.postDelayed(this, 1000)
            }
        }
    }

    /**
     * Inflates the layout, initializes views and sets up click listeners for buttons.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_stop_watch, container, false)

        stopwatchDisplay = view.findViewById(R.id.stopwatchDisplay)
        startButton = view.findViewById(R.id.startButton)
        stopButton = view.findViewById(R.id.stopButton)
        resetButton = view.findViewById(R.id.resetButton)

        // Start the stopwatch when the start button is clicked
        startButton.setOnClickListener {
            if (!isRunning) {
                startTime = SystemClock.elapsedRealtime() - elapsedTime
                handler.post(updateStopwatch)
                isRunning = true
            }
        }

        // Stop the stopwatch when the stop button is clicked
        stopButton.setOnClickListener {
            if (isRunning) {
                handler.removeCallbacks(updateStopwatch)
                isRunning = false
            }
        }

        // Reset the stopwatch when the reset button is clicked
        resetButton.setOnClickListener {
            elapsedTime = 0
            stopwatchDisplay.text = "00:00:00"
            if (!isRunning) {
                startTime = SystemClock.elapsedRealtime()
            }
        }

        return view
    }

    /**
     * Ensures that the stopwatch stops updating when the fragment is destroyed.
     */
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(updateStopwatch)
    }
}
