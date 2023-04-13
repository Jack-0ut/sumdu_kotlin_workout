package com.example.sumdu_kotlin_lab8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Class-Adapter for an Exercise Complex
 **/
class ExerciseComplexAdapter(
    private val exerciseComplexes: List<ExerciseComplex>,
    private val onExerciseComplexClickListener: (ExerciseComplex) -> Unit
) : RecyclerView.Adapter<ExerciseComplexAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseComplexName: TextView = itemView.findViewById(R.id.exerciseComplexName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_exercise_complex, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exerciseComplex = exerciseComplexes[position]
        holder.exerciseComplexName.text = exerciseComplex.name
        holder.itemView.setOnClickListener { onExerciseComplexClickListener(exerciseComplex) }
    }

    override fun getItemCount() = exerciseComplexes.size
}
