package com.example.materialdesignexample.ui.materials.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.materialdesignexample.R


class CardsAdapter(mData: ArrayList<Data>) : RecyclerView.Adapter<CardsAdapter.CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardHolder(v)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(data.get(position))
    }

    private var data: List<Data> = ArrayList()

    init {
        this.data = mData
    }


    override fun getItemCount(): Int {
        return data.size
    }

    inner class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.img)
        var expandBtn : ImageView = itemView.findViewById(R.id.expand_btn)
        var callUs : View = itemView.findViewById(R.id.call_usview)
        var name: TextView = itemView.findViewById(R.id.main_txt)
        var rateBar: RatingBar = itemView.findViewById(R.id.rating_br)
        var rateTxt: TextView = itemView.findViewById(R.id.rate_txt)
        var isExpand = false

        fun bind(d: Data) {
            Glide.with(img.context)
                .load(d.uri)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(img)
            name.text = d.name
            rateBar.rating = d.rate.toFloat()
            rateTxt.text = "(${d.rate})"


            expandBtn.setOnClickListener {
                if(!isExpand) {
                    isExpand = true
                    callUs.visibility = View.VISIBLE
                    expandBtn.setImageDrawable(ContextCompat.getDrawable(expandBtn.context, R.drawable.ic_keyboard_arrow_up_black_24dp))
                }else{
                    isExpand = false
                    callUs.visibility = View.GONE
                    expandBtn.setImageDrawable(ContextCompat.getDrawable(expandBtn.context, R.drawable.ic_keyboard_arrow_down_black_24dp))
                }
            }
        }
    }
}