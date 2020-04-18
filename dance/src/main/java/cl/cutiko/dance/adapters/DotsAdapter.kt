package cl.cutiko.dance.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cutiko.dance.R

class DotsAdapter : RecyclerView.Adapter<DotsAdapter.DotHolder>() {

    companion object {
        private const val SELECTED = 1
        private const val DEFAULT = 0
    }

    private val dots: Array<Int> = Array(INTRO_SLIDES) { DEFAULT }
    private var previous = 0

    init {
        dots[0] = SELECTED
    }

    override fun onCreateViewHolder(container: ViewGroup, type: Int): DotHolder {
        val view = LayoutInflater.from(container.context).inflate(
            R.layout.holder_dot, container, false
        )
        return DotHolder(view)
    }

    override fun onBindViewHolder(holder: DotHolder, position: Int) {
        holder.itemView.setBackgroundResource(
            if (SELECTED == dots[position]) R.drawable.bg_dot_selected else R.drawable.bg_dot_default
        )
    }

    override fun getItemCount(): Int {
        return INTRO_SLIDES
    }

    fun update(position: Int) {
        if (position == previous) return
        dots[position] = SELECTED
        dots[previous] = DEFAULT
        notifyDataSetChanged()
        previous = position
    }

    class DotHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}