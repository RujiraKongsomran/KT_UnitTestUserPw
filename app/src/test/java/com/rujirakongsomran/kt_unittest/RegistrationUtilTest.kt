package com.rujirakongsomran.kt_unittest


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "biwberry",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    // password was repeated incorrectly
    @Test
    fun `incorrectly confirmed password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Biwberry",
            "123456",
            "abcdef"
        )
        assertThat(result).isFalse()
    }

    // empty password
    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Biwberry",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    // password contain less than 2 digits
    @Test
    fun `less than 2 digits password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Biwberry",
            "a",
            "a"
        )
        assertThat(result).isFalse()
    }
}