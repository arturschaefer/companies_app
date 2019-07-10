package com.schaefer.companiesapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schaefer.companiesapp.R
import com.schaefer.companiesapp.entity.enterprise.Enterprise
import kotlinx.android.synthetic.main.item_search.view.*

class EnterpriseAdapter(
    private val enterprises: List<Enterprise>,
    private val context: Context,
    private val onItemClickListener: ClickListener
) : RecyclerView.Adapter<EnterpriseAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val enterprise = enterprises[position]
        Glide
            .with(context)
            .load(enterprise.photo)
            .centerCrop()
            .error(R.drawable.enterprise_placeholder)
            .into(holder.image)
        holder.titleItem.text = enterprise.enterprise_name
        holder.type.text = enterprise.enterpriseType.name
        holder.location.text = enterprise.country

        holder.itemView.setOnClickListener {
            onItemClickListener.onClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return enterprises.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.imageView_companie_item
        val titleItem: TextView = itemView.textView_title_item
        val type: TextView = itemView.textView_enterprise_type_item
        val location: TextView = itemView.textView_location_item
    }

    interface ClickListener {
        fun onClick(position: Int)
    }

}