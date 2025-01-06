package com.radlance.alfatesttask.domain

interface LoadResult {
    fun <T: Any> map(mapper: Mapper<T>): T

    interface Mapper<T: Any> {
        fun mapSuccess(cardDetails: CardDetails): T
        fun mapError(noConnection: Boolean): T
    }

    data class Success(val cardDetails: CardDetails) : LoadResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(cardDetails)
        }
    }

    data class Error(val noConnection: Boolean) : LoadResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(noConnection)
        }
    }
}