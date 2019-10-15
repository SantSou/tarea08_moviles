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
import java.io.File
import java.util.*

private var names = arrayListOf<String>()
private var lastNames = arrayListOf<String>()
private var birthDate = arrayListOf<Date>()
private var photos = arrayListOf<File>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_names_rv)

        recyclerView.adapter = AdapterName(names)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class feed {
    fun get_info(){
        var query = ParseQuery<ParseObject>("UserList")
        query.findInBackground(FindCallback { user_list: List<ParseObject>, e ->
            if(e == null)
                for (user in user_list) {
                    names.add(user.name)
                    lastNames.add(user.lastName)
                    birthDate.add(user.birthDate)
                    photos.add(user.photo)
                }
            else
                error{e}
        })
    }
}
