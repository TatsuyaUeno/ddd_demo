package com.example.demo.demo.domain.screening

import java.util.UUID

/**
 * 採用選考ID
 */
data class ScreeningId(val value: String) {
    constructor() : this(UUID.randomUUID().toString())
}
