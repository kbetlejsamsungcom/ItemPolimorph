package com.bitage.hotelitem

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bitage.hotelitem.model.MyRequestList
import com.bitage.hotelitem.model.RequestItemList

class RequestAdapter(val items: MyRequestList) : RecyclerView.Adapter<RequestAdapter.RequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.request_item_layout, parent, false)
        return RequestViewHolder(root)
    }

    override fun getItemCount(): Int {
        return items.size()
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {

    }

    class RequestViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView)
}