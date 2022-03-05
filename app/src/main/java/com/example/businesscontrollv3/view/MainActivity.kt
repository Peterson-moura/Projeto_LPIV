package com.example.businesscontrollv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.view.adapter.MainSectionsPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = MainSectionsPagerAdapter(lifecycle, supportFragmentManager)
        pager.adapter = sectionsPagerAdapter

        TabLayoutMediator(tabs, pager) {
            tab, position ->
                tab.text = when (position) {
                    0 -> "Resumo"
                    1 -> "Transações"
                    2 -> "Contas"
                    else -> ""
                }
        }.attach()

        bottomNavigationMenu.setOnNavigationItemSelectedListener(this::onOptionsItemSelected)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        Toast.makeText(applicationContext, R.string.toast_text, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.new_responsible -> {
                 val intent = Intent(applicationContext, ResponsibleActivity::class.java)
                    startActivity(intent)

                /*
                    Chamar tela para cadastro de responsavel chamado: ResponsibleActivity
                        - ViewModel
                        - Databinding
                        - Quando Clicar em Salvar deve mostrar o nome em um Toast e retornar para a
                            tela principal
                        - Tipo do Botao para salvar e o FloatActionButton
                        - Link do Material Design para App: https://material.io/components/bottom-navigation/android#bottom-navigation-bar
                 */
                true
            }
            R.id.new_transaction -> true
            R.id.new_account -> true
            R.id.navigation_configurations -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}