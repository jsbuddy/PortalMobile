package com.example.portal.ui.login

import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portal.R
import com.example.portal.data.model.LoggedInUser
import com.example.portal.data.repository.AuthRepository
import com.example.portal.utils.Result

class LoginViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        val result = authRepository.login(email, password)

        if (result is Result.Success) {
            _loginResult.value = LoginResult(
                success = LoggedInUser(
                    displayName = result.data.displayName,
                    userId = result.data.userId
                )
            )
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(email: String, password: String) {
        if (!isEmailValid(email)) {
            _loginForm.value = LoginFormState(emailError = R.string.invalid_email)
        } else if (!isPasswordValid(password)) {
            if (password.isNotEmpty()) {
                _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
            } else {
                _loginForm.value = LoginFormState()
            }
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return if (email.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else false
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}