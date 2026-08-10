package com.zavudev.api.errors

open class ZavudevException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
