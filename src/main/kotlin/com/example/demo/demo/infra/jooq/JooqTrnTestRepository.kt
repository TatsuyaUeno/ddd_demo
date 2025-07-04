package com.example.demo.demo.infra.jooq

import org.springframework.stereotype.Repository
// CLUD操作を行うためのJOOQのDSLContextをインポート
import org.jooq.DSLContext
// テーブル名の定数、JOOQによって参照できる
// ※import文は、build.gradle.ktsでJOOQのコード生成を設定しているため、生成されたコードを参照する
import com.example.demo.demo.infra.jooq.tables.TrnTest.TRN_TEST

import com.example.demo.demo.domain.repository.TrnTestRepository
import com.example.demo.demo.domain.model.TrnTest

@Repository
class JooqTrnTestRepository(
    // JOOQのDSLContextをDIする ※コンストラクタに定義が望ましい
    private val dsl: DSLContext
) : TrnTestRepository {
    override fun findByUserId(userId: String): TrnTest? {
        return dsl.selectFrom(TRN_TEST)
            .where(TRN_TEST.USER_ID.eq(userId))
            .fetchOne()
            // Kotlinのデータクラスに変換
            ?.into(TrnTest::class.java)
    }

    override fun createUser(trnTest: TrnTest): TrnTest {
        dsl.insertInto(TRN_TEST)
            .set(TRN_TEST.USER_ID, trnTest.user_id)
            .set(TRN_TEST.USER_NAME, trnTest.user_name)
            .execute()
        return trnTest
    }

    override fun findByUserIdToPlainSQL(userId: String): TrnTest? {
        val sql = "SELECT * FROM trn_test WHERE user_id = ?"
        val result = dsl.resultQuery(sql, userId).fetch()

        result.forEach { record ->
            val id = record.get("user_id", String::class.java)
            val name = record.get("user_name", String::class.java)
            println("ID: $id, Name: $name")
        }
        return result
            .into(TrnTest::class.java)
            .firstOrNull()
    }
}