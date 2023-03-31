package com.example.segundoparcial

import com.google.gson.annotations.SerializedName


data class User(val title: String, @SerializedName(value = "body") val description: String)