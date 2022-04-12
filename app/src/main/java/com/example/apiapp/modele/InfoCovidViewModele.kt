package com.example.apiapp.modele

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class InfoCovidViewModele : ViewModel() {

        val data: MutableLiveData<InfoCovidItemBean?> = MutableLiveData()
        val errorMessage: MutableLiveData<String?> = MutableLiveData()
        val threadRuning: MutableLiveData<Boolean> = MutableLiveData()


        fun loadData() {
            //reset des données
            threadRuning.postValue(true)
            errorMessage.postValue(null)
            data.postValue(null)

            thread {
                try {
                    data.postValue(RequestUtils.covidRecup("Paris"))

                } catch (e: Exception) {
                    e.printStackTrace()
                    errorMessage.postValue(e.message)
                }
                threadRuning.postValue(false)

            }
        }

    }
