package com.example.demo.demo.domain.screening

import java.util.UUID

/**
 * 採用ポジションID
 */
data class PositionId(
    val value: String,
) {
    constructor() : this(UUID.randomUUID().toString())
}
