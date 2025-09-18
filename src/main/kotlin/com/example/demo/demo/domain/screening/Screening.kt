package com.example.demo.demo.domain.screening

import java.time.LocalDateTime
import com.example.demo.demo.domain.exception.DomainException

/**
 * 採用選考
 *
 * @property screeningId 採用選考ID
 * @property positionId 採用ポジションID
 * @property applicant 応募者
 * @property interviews 面接
 * @property status 選考ステータス
 * @property applyDateTime 応募日時
 */
class Screening private constructor(
    screeningId: ScreeningId,
    positionId: PositionId,
    applicant: Applicant,
    interviews: Interviews,
    status: ScreeningStatus,
    applyDateTime: LocalDateTime,
) {
    val screeningId = screeningId
    val positionId = positionId
    val applicant = applicant
    val applyDateTime = applyDateTime

    var interviews = interviews
        private set

    var status = status
        private set

    companion object {
        /** 新規採用選考を作成 */
        fun create(
            positionId: PositionId,
            applicant: Applicant,
        ): Screening {
            return Screening(
                screeningId = ScreeningId(),
                interviews = Interviews.empty(),
                status = ScreeningStatus.IN_PROGRESS,
                applyDateTime = LocalDateTime.now(),
                positionId = positionId,
                applicant = applicant,
            )
        }

        /** DBなどの値からインスタンスを再構成 */
        fun reconstruct(
            screeningId: ScreeningId,
            positionId: PositionId,
            applicant: Applicant,
            interviews: Interviews,
            status: ScreeningStatus,
            applyDateTime: LocalDateTime,
        ): Screening {
            return Screening(
                screeningId = screeningId,
                positionId = positionId,
                applicant = applicant,
                interviews = interviews,
                status = status,
                applyDateTime = applyDateTime,
            )
        }
    }

    /** 面接を追加 */
    fun addInterview(interviewDateTime: LocalDateTime) {
        if (!status.canAddInterview) {
            throw DomainException("面接が選考中ではありません")
        }
        interviews = interviews.addInterview(interviewDateTime)
    }
}
