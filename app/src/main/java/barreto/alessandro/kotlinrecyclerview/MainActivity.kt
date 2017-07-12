package barreto.alessandro.kotlinrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import barreto.alessandro.kotlinrecyclerview.model.FeedModelList
import barreto.alessandro.kotlinrecyclerview.rest.RestClient
import com.google.gson.Gson
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list.layoutManager = LinearLayoutManager(this) // LayoutManager RecyclerView

        RestClient.get("data.json",null,responseServer) // connect internet

    }

    val responseServer = object : JsonHttpResponseHandler (){
        override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
            val listData: FeedModelList = Gson().fromJson(response.toString(), FeedModelList::class.java) // list data from server
            val adapter = FeedAdapter(listData.data,{itemClick -> Unit
                Log.i("Ale",itemClick.tag)
            }) // create adapter
            rv_list.adapter = adapter // set Adapter
        }
    }

}
