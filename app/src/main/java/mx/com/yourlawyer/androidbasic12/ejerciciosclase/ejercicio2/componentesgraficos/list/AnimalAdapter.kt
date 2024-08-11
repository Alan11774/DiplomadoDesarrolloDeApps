package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import mx.com.yourlawyer.androidbasic12.R

class AnimalAdapter(val list: List<AnimalEntity>): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    var onItemSelected:((AnimalEntity) -> Unit)? = null
    class AnimalViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
        val tvAnimalName =  view.findViewById<TextView>(R.id.tvAnimalName)
        val tvColor = view.findViewById<TextView>(R.id.tvColor)
        val animalCard = view.findViewById<CardView>(R.id.animalCard)

        fun render(animalEntity: AnimalEntity, onItemSelected : ((AnimalEntity) -> Unit)?){
            tvAnimalName.text = animalEntity.name
            tvColor.text = animalEntity.color

//            tvColor.typeface = ResourcesCompat.getFont(tvColor.context, R.font.roboto_regular)

            animalCard.setOnClickListener {
                onItemSelected?.invoke(animalEntity)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        // view is the layout item for the list
        // parent is the parent view group
        // context is the context of the parent view group
        // inflater is used to inflate the layout item for the list into the parent view group
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false )
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }
}