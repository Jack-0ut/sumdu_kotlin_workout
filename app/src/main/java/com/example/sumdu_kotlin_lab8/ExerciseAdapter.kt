package com.example.sumdu_kotlin_lab8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Class-Adapter for the Single Exercise as a part of the Complex
 * Exercise consists of the exercise name and the number of repetitions
 **/
class ExerciseAdapter(private val exercises: List<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseDescription: TextView = itemView.findViewById(R.id.exerciseDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_exercise, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.exerciseDescription.text = "${exercise.repetitions} ${exercise.name}"
    }

    override fun getItemCount() = exercises.size
}
