package com.example.demo.demo.domain.screening

/**
 * 選考ステータス
 */
enum class ScreeningStatus(
    /** 面接追加可否 */
    val canAddInterview: Boolean,
) {
    /** 選考中 */
    IN_PROGRESS(true),

    /** 採用 */
    ADOPTED(false),

    /** 不採用 */
    REJECTED(false),
}
