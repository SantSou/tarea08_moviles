package iteso.mx.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parse.ParseObject
import iteso.mx.recycler.R

class AdapterName (private val names: List<ParseObject>): RecyclerView.Adapter<NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int = names.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind({names[position].get(name), names[position].get(lastName)})
    }
}

class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameTitle: TextView = view.findViewById(R.id.item_title_name)
    private val lastNameTitle: TextView = view.findViewById(R.id.item_title_last_name)
    
    fun bind(user: HashMap<String, String>) {
        nameTitle.text = user.get("name")
        lastNameTitle.text = user.get("lastName")
    }
}