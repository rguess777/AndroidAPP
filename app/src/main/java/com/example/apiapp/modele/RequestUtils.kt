package com.example.apiapp.modele

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

private val client = OkHttpClient()
private val gson = Gson()

const val URL_API_COVID =
    "https://coronavirusapifr.herokuapp.com/data/live/france"

class RequestUtils {

    companion object {

        fun statsCovid(city: String): InfoCovid {
            val json: String = sendGet(URL_API_COVID.format(city))

            val covid = gson.fromJson(json, InfoCovid::class.java)

            return covid
        }

        fun sendGet(url: String): String {
            println("url : $url")
            //Création de la requete
            val request = Request.Builder().url(url).build()
            //Execution de la requête
            return client.newCall(request).execute().use {
                //Analyse du code retour
                if (!it.isSuccessful) {
                    throw Exception("Réponse du serveur incorrect :${it.code}")
                }
                //Résultat de la requete
                it.body?.string() ?: ""
            }
        }

        fun covidRecup(city : String): InfoCovidItemBean {
             return statsCovid(city).get(0)
        }
    }
}
