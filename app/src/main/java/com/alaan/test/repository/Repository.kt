package com.alaan.test.repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject
constructor() {

    public val name: String
        get() = "hello world"
}
