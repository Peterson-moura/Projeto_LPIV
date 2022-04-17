package com.example.businesscontrollv3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.businesscontrollv3.BusinessControlApplication
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityAccountBinding
import com.example.businesscontrollv3.viewmodel.AccountViewModelFactory
import com.example.businesscontrollv3.viewmodel.AccountsViewModel

class AccountActivity : AppCompatActivity() {

    private val  accountsViewModel: AccountsViewModel by viewModels {
        AccountViewModelFactory(application as BusinessControlApplication)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val binding: ActivityAccountBinding = DataBindingUtil.setContentView(this, R.layout.activity_account)

        binding.accoutViewModel = accountsViewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun saveAccount(view: View){
        this.accountsViewModel.save()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}