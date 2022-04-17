package com.example.businesscontrollv3.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.view.adapter.AccountAdapter
import com.example.businesscontrollv3.viewmodel.AccountsViewModel
import com.example.businesscontrollv3.viewmodel.ResumeViewModel
import kotlinx.android.synthetic.main.fragment_resume.*


class AccountsFragment : Fragment() {

    lateinit var accountsViewModel: AccountsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_accounts, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.accounts_recyclerview)
        recyclerView.adapter = AccountAdapter(emptyList())

        return root
        }

    }


