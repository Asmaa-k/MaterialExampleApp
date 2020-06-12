package com.example.materialdesignexample.ui.materials.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesignexample.R
import java.util.ArrayList

class CardsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cards, container, false)
        val arrayList =ArrayList<Data>()
        arrayList.add(Data("https://images.unsplash.com/photo-1462275646964-a0e3386b89fa?ixlib=rb-1.2.1", "yellow sunflower",5))
        arrayList.add(Data("https://images.unsplash.com/photo-1523308458373-c6f61ae1fd21?ixlib=rb-1.2.1", "flowers colorful plants bloom",4))
        arrayList.add(Data("https://images.unsplash.com/photo-1522332570948-51e557f21aa0?ixlib=rb-1.2.1", "blooming",3))
        arrayList.add(Data("https://images.unsplash.com/photo-1590317304607-20b8f5652383?ixlib=rb-1.2.1", "white ball dahlia",5))
        arrayList.add(Data("https://images.unsplash.com/photo-1590037671207-5d0cfd7085ed?ixlib=rb-1.2.1", "blooming",4))
        arrayList.add(Data("https://images.unsplash.com/photo-1589623906780-b7cfcd89823a?ixlib=rb-1.2.1", "pink clustered", 4))
        val rvCard = view.findViewById<RecyclerView>(R.id.rv_cards)
        val adapter= CardsAdapter(arrayList)
        rvCard.adapter = adapter
        return view
    }
}