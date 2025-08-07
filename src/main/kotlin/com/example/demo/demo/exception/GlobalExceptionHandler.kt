package com.example.demo.demo.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): ResponseEntity<String> {
        log.error("予期せぬエラーが発生しました: ${ex.message}", ex)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("予期せぬエラーが発生しました: ${ex.message}")
    }

    // 「特定の例外のハンドリング」や「カスタム例外のハンドリング」でレスポンスを変更可能
    // 例: @ExceptionHandler(IllegalArgumentException::class) など
}
