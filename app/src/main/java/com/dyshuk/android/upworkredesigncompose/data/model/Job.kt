package com.dyshuk.android.upworkredesigncompose.data.model

data class Job(
    val title: String,
    val description: String,
    val timeRequirement: String,
    val duration: String,
    val budgetType: String,
    val isPaymentVerified: Boolean,
    val spend: String,
    val postedTime: String,
    val isFeatured: Boolean,
    var isFavorite: Boolean = false
)
