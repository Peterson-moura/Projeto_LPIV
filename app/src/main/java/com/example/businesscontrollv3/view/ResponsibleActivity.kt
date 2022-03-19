package com.example.businesscontrollv3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.businesscontrollv3.BusinessControlApplication
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityResponsibleBinding
import com.example.businesscontrollv3.viewmodel.ResponsibleActivityViewModel
import com.example.businesscontrollv3.viewmodel.ResponsibleViewModelFactory

class ResponsibleActivity : AppCompatActivity() {

    private val responsibleActivityViewModel: ResponsibleActivityViewModel by viewModels() {
       ResponsibleViewModelFactory(application as BusinessControlApplication)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityResponsibleBinding = DataBindingUtil.setContentView(this, R.layout.activity_responsible)
    binding.viewmodel = responsibleActivityViewModel
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun salvarResponsavel(view: View){
        responsibleActivityViewModel.saveResponsible()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}