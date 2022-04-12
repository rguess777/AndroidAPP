package com.example.apiapp.modele

class InfoCovid : ArrayList<InfoCovidItemBean>()

data class InfoCovidItemBean(
    val R: Any,
    val TO: Double,
    val conf: Int,
    val conf_j1: Int,
    val cv_dose1: Any,
    val date: String,
    val dc_tot: Int,
    val dchosp: Int,
    val esms_cas: Int,
    val esms_dc: Int,
    val hosp: Int,
    val incid_dchosp: Int,
    val incid_hosp: Int,
    val incid_rad: Int,
    val incid_rea: Int,
    val pos: Any,
    val pos_7j: Any,
    val rad: Int,
    val rea: Int,
    val tx_incid: Any,
    val tx_pos: Any
)