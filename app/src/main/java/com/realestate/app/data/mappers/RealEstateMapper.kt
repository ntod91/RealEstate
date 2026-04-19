package com.realestate.app.data.mappers

import com.realestate.app.data.network.models.RealEstateList
import com.realestate.app.data.storage.models.RealEstateEntity
import com.realestate.app.utils.Defaults
import com.realestate.app.utils.Defaults.RANDOM_SEED
import com.realestate.app.utils.toPriceValue
import kotlin.random.Random

object RealEstateMapper {

    fun RealEstateList.toDb(): List<RealEstateEntity> = this.results.map {
        RealEstateEntity(
            id = it.id ?: Random(RANDOM_SEED).nextLong(),
            price = it.listing?.prices?.buy?.price?.toPriceValue() ?: Defaults.DEFAULT_STRING,
            imageUrl = it.listing?.localization?.de?.attachments?.firstOrNull()?.url
                ?: Defaults.DEFAULT_STRING,
            title = it.listing?.localization?.de?.text?.title ?: Defaults.DEFAULT_STRING,
            address = buildString {
                it.listing?.address?.street?.let { street ->
                    append(street)
                    append(Defaults.COMMA)
                    append(it.listing?.address?.locality)
                } ?: append(it.listing?.address?.locality)
            })
    }
}
