package com.example.businesscontrollv3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityLoginBinding
import com.example.businesscontrollv3.databinding.ActivityResponsibleBinding
import com.example.businesscontrollv3.viewmodel.ResponsibleActivityViewModel
import com.example.businesscontrollv3.viewmodel.ResponsibleViewModelFactory

class ResponsibleActivity : AppCompatActivity() {

    private val responsibleActivityViewModel: ResponsibleActivityViewModel by lazy {
        ViewModelProvider(this, ResponsibleViewModelFactory).get(ResponsibleActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityResponsibleBinding = DataBindingUtil.setContentView(this, R.layout.activity_responsible)
    binding.viewmodel = responsibleActivityViewModel



    }

    fun salvarResponsavel(view: View){
        Toast.makeText(this,"${responsibleActivityViewModel.responsavel} Adicionado com Sucesso ",Toast.LENGTH_LONG).show()
        finish()
    }

}