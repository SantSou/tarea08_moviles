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

private var user_list = List<ParseObject>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_names_rv)

        recyclerView.adapter = AdapterName(user_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class feed {
    fun get_info(){
        var query = ParseQuery<ParseObject>("UserList")
        query.findInBackground(FindCallback { users: List<ParseObject>, e ->
            if(e == null)
                user_list = users
            else
                error{e}
        })
    }
}
