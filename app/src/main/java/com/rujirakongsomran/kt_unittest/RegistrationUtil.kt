package com.rujirakongsomran.kt_unittest

object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    /*
    * the input is not valid if...
    * ... the username/password is empty
    * ... the username is already taken
    * ... the confirmed password is not the same as the real password
    * ... the password contains less than 2 digits
    */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) return false
        if (username in existingUsers) return false
        if (password != confirmedPassword) return false
        if (password.count() < 6) return false
        if (password[0].isLowerCase()) return false
        return true
    }
}