package com.example.sumdu_kotlin_lab8

/**
 * A data class representing an exercise complex.
 *
 * @property name The name of the exercise complex.
 * @property exercises A list of [Exercise] objects in the exercise complex.
 */
data class ExerciseComplex(val name: String, val exercises: List<Exercise>)

/**
 * A data class representing an individual exercise.
 *
 * @property name The name of the exercise.
 * @property repetitions The number of repetitions for the exercise.
 */
data class Exercise(val name: String, val repetitions: Int)
