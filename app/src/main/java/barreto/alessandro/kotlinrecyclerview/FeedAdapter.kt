package barreto.alessandro.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import barreto.alessandro.kotlinrecyclerview.model.FeedModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by ocean on 07/07/17.
 */
class FeedAdapter(val feedModelItems: List<FeedModel>, val itemClick: (FeedModel) -> Unit)
    : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view, itemClick)
    }//ViewHolder

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindFeedModel( feedModelItems[position] )
    }//BindViewHolder

    override fun getItemCount() = feedModelItems.size // Size


    inner class ViewHolder(itemView: View, val itemClick: (FeedModel) -> Unit) : RecyclerView.ViewHolder(itemView){
        fun bindFeedModel(feedModel: FeedModel){
            with(feedModel){
                itemView.setOnClickListener { itemClick(this) }
                itemView.tv_tag.text = tag
                itemView.tv_city.text = city
                itemView.tv_content.text = textContent
                Picasso.with( itemView.iv_list.context ).load( imageUrl ).into( itemView.iv_list )
            }
        } // ViewHolder


    }// FeedAdapter

}