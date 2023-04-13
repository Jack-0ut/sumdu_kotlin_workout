package com.example.sumdu_kotlin_lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Main activity of the application, displaying the list of exercise complexes,
 * selected complex details, and a stopwatch.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var exerciseComplexList: RecyclerView
    private lateinit var complexName: TextView
    private lateinit var exerciseList: RecyclerView
    private lateinit var stopwatchContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exerciseComplexList = findViewById(R.id.exerciseComplexList)
        complexName = findViewById(R.id.complexName)
        exerciseList = findViewById(R.id.exerciseList)
        stopwatchContainer = findViewById(R.id.stopwatchContainer)

        val sampleExerciseComplexes = listOf(
            ExerciseComplex(
                name = "Beginner Workout",
                exercises = listOf(
                    Exercise(name = "Push-Ups", repetitions = 10),
                    Exercise(name = "Squats", repetitions = 15),
                    Exercise(name = "Sit-Ups", repetitions = 20),
                    Exercise(name = "Jumping Jacks", repetitions = 30)
                )
            ),
            ExerciseComplex(
                name = "Intermediate Workout",
                exercises = listOf(
                    Exercise(name = "Pull-Ups", repetitions = 5),
                    Exercise(name = "Lunges", repetitions = 10),
                    Exercise(name = "Plank", repetitions = 1), // You may need to modify the Exercise class to handle duration instead of repetitions for this type of exercise
                    Exercise(name = "Burpees", repetitions = 15)
                )
            ),
            ExerciseComplex(
                name = "Advanced Workout",
                exercises = listOf(
                    Exercise(name = "Handstand Push-Ups", repetitions = 5),
                    Exercise(name = "Pistol Squats", repetitions = 10),
                    Exercise(name = "Hanging Leg Raises", repetitions = 15),
                    Exercise(name = "Box Jumps", repetitions = 20)
                )
            )
        )

        // Set the adapter for the exercise complex list
        exerciseComplexList.adapter = ExerciseComplexAdapter(sampleExerciseComplexes) { complex ->
            // Update the displayed complex details when an item is clicked
            complexName.text = complex.name
            exerciseList.adapter = ExerciseAdapter(complex.exercises)
        }

        // Add the stopwatch fragment to the activity
        supportFragmentManager.beginTransaction()
            .replace(R.id.stopwatchContainer, StopWatchFragment())
            .commit()
    }
}
