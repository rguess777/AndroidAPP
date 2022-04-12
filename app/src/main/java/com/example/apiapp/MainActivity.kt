package com.example.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.apiapp.databinding.ActivityMainBinding
import com.example.apiapp.modele.InfoCovidViewModele


class MainActivity : AppCompatActivity(), View.OnClickListener {
    //IHM
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Data
    val model by lazy { ViewModelProvider(this).get(InfoCovidViewModele::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        model.loadData()


        model.data.observe(this) {
            //La nouvelle donnée s'appelle it
            binding.tvDate.text = it?.date ?: "-"
            binding.tvHosp.text = it?.hosp?.toString() ?: "-"
            binding.tvConf.text = it?.conf_j1?.toString() ?: "-"

        }

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}