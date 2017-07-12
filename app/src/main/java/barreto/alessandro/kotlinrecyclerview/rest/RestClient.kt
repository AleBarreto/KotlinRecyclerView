package barreto.alessandro.kotlinrecyclerview.rest

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams

/**
 * Created by ocean on 10/07/17.
 */
class RestClient{

    companion object {

        private val BASE_URL : String = "https://teste-alebarreto.c9users.io/"
        private val client: AsyncHttpClient = AsyncHttpClient()

        fun get ( url : String , params: RequestParams?, responseHandler: AsyncHttpResponseHandler ){
            client.get(getAbsoluteUrl(url),params,responseHandler)
        }

        private fun getAbsoluteUrl( relativeUrl: String ) : String {
            return BASE_URL +relativeUrl
        }

    }

}