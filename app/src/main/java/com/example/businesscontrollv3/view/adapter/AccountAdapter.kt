package com.example.businesscontrollv3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.model.Account

class AccountAdapter(private val accountList: List<Account>) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_account, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountAdapter.ViewHolder, position: Int) {
        holder.textView.text = accountList[position].name
    }

    override fun getItemCount(): Int = accountList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.account_name)
    }


}