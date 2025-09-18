package com.example.demo.demo.domain.screening

import java.time.LocalDateTime

/**
 * 面接
 */
data class Interview(
    /** 面接次数 */
    val phase: Int,
    /** 面接日時 */
    val dateTime: LocalDateTime,
)
