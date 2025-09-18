package com.example.demo.demo.domain.screening

import java.time.LocalDateTime

/**
 * 面接のファーストクラスコレクション
 */
data class Interviews(
    val value: List<Interview>,
) {
    /** 面接を追加します */
    fun addInterview(interviewDateTime: LocalDateTime): Interviews {
        val newInterview =
            Interview(
                phase = this.value.size + 1,
                dateTime = interviewDateTime,
            )
        return Interviews(
            this.value + newInterview,
        )
    }

    companion object {
        /** 初期状態のインスタンスを生成します */
        fun empty(): Interviews =
            Interviews(
                emptyList(),
            )
    }
}
