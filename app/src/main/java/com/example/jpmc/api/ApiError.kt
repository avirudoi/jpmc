package com.example.jpmc.api

sealed class ApiError(message: String = "") : RuntimeException(message) {
    object NetworkError : ApiError()
    object NetworkTimeout : ApiError()
    class ErrorMessage(message: String) : ApiError()
    class Error(val exception: Exception) : ApiError(exception.toString())
}