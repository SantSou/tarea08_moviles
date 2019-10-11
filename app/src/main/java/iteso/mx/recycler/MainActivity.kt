package iteso.mx.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import iteso.mx.recycler.adapters.AdapterName
import org.jetbrains.anko.getStackTraceString
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_names_rv)
        val names = arrayListOf<HashMap<String, String>>()
        names.add(HashMap())
        names[0].put("name", "Erick")
        names[0].put("lastName", "De Santiago")
        names.add(HashMap())
        names[1].put("name", "Edmundo")
        names[1].put("lastName", "Vidalvarez")
        names.add(HashMap())
        names[2].put("name", "Rogelio")
        names[2].put("lastName", "Sandoval")
        names.add(HashMap())
        names[3].put("name", "Javier")
        names[3].put("lastName", "Gil")
        names.add(HashMap())
        names[4].put("name", "Alberto")
        names[4].put("lastName", "Miramontes")
        recyclerView.adapter = AdapterName(names)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class feed {
    fun get_info(){
        var query = ParseQuery<ParseObject>("UserList")
        query.findInBackground(FindCallback { user_list: List<ParseObject>, e ->
            if(e == null)
                Log.d("user", "Retrieved " + user_list.size + " users")
            else
                error{e}
        })
    }
}
