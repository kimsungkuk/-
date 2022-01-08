package com.example.homework

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.homework.model.RecyclerData
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setUpdatedData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageView = view.imageView
        val classification = view.classification
        val restaurantName = view.restaurantName
        val rating = view.rating
        val reviewCount = view.reviewCount
        val isRemoteWaiting = view.isRemoteWaiting
        val isQuickBooking = view.isQuickBooking
        val wating = view.wating

        fun bind(data: RecyclerData) {
            classification.text = data.classification
            restaurantName.text = data.restaurantName
            rating.text = data.rating.toString()
            reviewCount.text = "(${data.reviewCount})"

            if (data.waitingCount == 0) {
                wating.visibility = View.VISIBLE
            } else {
                wating.visibility = View.GONE
            }

            if (data.isQuickBooking) {
                isQuickBooking.visibility = View.VISIBLE
            } else {
                isQuickBooking.visibility = View.GONE
            }

            if (data.isRemoteWaiting) {
                isRemoteWaiting.visibility = View.VISIBLE
            } else {
                isRemoteWaiting.visibility = View.GONE
            }

            Glide.with(imageView)
                .load(data.thumbnail)
                .transform(CenterCrop(), RoundedCorners(10))
                .into(imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listData == null) 0
        else listData?.size!!
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

}