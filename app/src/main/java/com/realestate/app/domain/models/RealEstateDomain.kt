package com.realestate.app.domain.models

data class RealEstateDomain(
    val id: Long,
    val price: String,
    val imageUrl: String,
    val title: String,
    val address: String,
    val isBookmarked: Boolean = false
)
