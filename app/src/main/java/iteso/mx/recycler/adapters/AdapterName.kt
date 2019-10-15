package iteso.mx.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parse.ParseFile
import com.parse.ParseObject
import iteso.mx.recycler.R

class AdapterName (private val users: List<ParseObject>): RecyclerView.Adapter<NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(users[position])
    }
}

class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val userName: TextView = view.findViewById(R.id.item_title_name)
    private val image: ImageView = view.findViewById(R.id.item_title_last_name)
    
    fun bind(user: ParseObject) {
        val parseFile: ParseFile = user.get("photo") as ParseFile
        Glide.with(view).load(parseFile.url).into(image)
        userName.text = user.get("username") as String
    }
}