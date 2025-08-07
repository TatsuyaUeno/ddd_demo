package com.example.demo.demo.service

import com.example.demo.demo.domain.model.TrnTest
import com.example.demo.demo.domain.repository.TrnTestRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TestService(
    private val trnTestRepository: TrnTestRepository,
) {
    fun findByUserId(userId: String): TrnTest {
        return trnTestRepository.findByUserId(userId)
            ?: throw NoSuchElementException("User with ID $userId not found")
    }

    @Transactional
    fun createUser(
        userId: String,
        userName: String,
    ): TrnTest {
        val trnTest = TrnTest(userId, userName)
        trnTestRepository.createUser(trnTest) ?: throw IllegalStateException("Failed to create user with ID $userId")
        // ロールバックされること確認済み
        throw IllegalStateException("Failed to create user with ID $userId")
        return trnTest
    }

    fun findByUserIdToPlainSQL(userId: String): TrnTest? {
        return trnTestRepository.findByUserIdToPlainSQL(userId)
    }
}
