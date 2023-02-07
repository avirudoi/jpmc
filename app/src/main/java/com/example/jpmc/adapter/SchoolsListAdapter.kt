package com.example.jpmc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jpmc.R
import com.example.jpmc.data.School

class SchoolsListAdapter(
    private val onItemClicked: (School) -> Unit,
    var items: List<School> = arrayListOf()
): RecyclerView.Adapter<SchoolsListAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.listitem_school, parent, false)
        return ViewHolder(view).also {viewHolder ->
            viewHolder.itemView.setOnClickListener{
                val school = viewHolder.school?: return@setOnClickListener
                onItemClicked(school)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val school = items[position]
       holder.bind(school)
    }

    fun updateItems(newItems: List<School>) {
        val thisNewItems = newItems
        if (items != thisNewItems) {
            items = thisNewItems
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        var school: School? = null
        private val name: TextView = itemView.findViewById(R.id.text_name)
        private val address: TextView = itemView.findViewById(R.id.text_address)
        private val email: TextView = itemView.findViewById(R.id.text_email)
        private val phoneNumber: TextView = itemView.findViewById(R.id.text_phone_number)


        fun bind(school: School) {
            this.school = school
            name.text = school.schoolName
            address.text = school.location
            email.text = school.schoolEmail
            phoneNumber.text = school.phoneNumber
        }
    }
}