package com.example.demo.demo.domain.exception

/**
 * ドメイン層の例外を表します
 *
 * ドメインルール違反など、ビジネスロジック上発生する例外に使用します。
 */
class DomainException : RuntimeException {
    constructor() : super()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)
}
