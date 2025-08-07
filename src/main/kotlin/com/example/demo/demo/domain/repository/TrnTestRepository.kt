package com.example.demo.demo.domain.repository
import com.example.demo.demo.domain.model.TrnTest

interface TrnTestRepository {
    fun findByUserId(userId: String): TrnTest?

    fun createUser(trnTest: TrnTest): TrnTest

    fun findByUserIdToPlainSQL(userId: String): TrnTest?
}
