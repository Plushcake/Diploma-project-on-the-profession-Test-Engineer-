package ru.netology.fmhandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.netology.fmhandroid.auth.AppAuth
import ru.netology.fmhandroid.repository.authRepository.AuthRepository
import ru.netology.fmhandroid.repository.userRepository.UserRepository
import ru.netology.fmhandroid.utils.Utils
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository,
    private val appAuth: AppAuth
) : ViewModel() {
    var currentUser = Utils.Empty.emptyUser
        private set

    var userList = Utils.Empty.emptyUserList
        private set

    val nonAuthorizedEvent = MutableSharedFlow<Unit>()
    val authorizedEvent = MutableSharedFlow<Unit>()
    val loginExceptionEvent = MutableSharedFlow<Unit>()
    val loginEvent = MutableSharedFlow<Unit>()
    val getUserInfoExceptionEvent = MutableSharedFlow<Unit>()
    val getUserListExceptionEvent = MutableSharedFlow<Unit>()
    val userListLoadedEvent = MutableSharedFlow<Unit>()

    fun login(login: String, password: String) {
        viewModelScope.launch {
            try {
                authRepository.login(login, password)
                getUserInfo()
                loginEvent.emit(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                loginExceptionEvent.emit(Unit)
            }
        }
    }

    fun authorization() {
        viewModelScope.launch {
            if (appAuth.accessToken == null) {
                nonAuthorizedEvent.emit(Unit)
            } else {
                try {
                    getUserInfo()
                    authorizedEvent.emit(Unit)
                } catch (e: Exception) {
                    e.printStackTrace()
                    authRepository.updateTokens(
                        checkNotNull(appAuth.refreshToken) { "Refresh token value was null." }
                    )
                    getUserInfo()
                    authorizedEvent.emit(Unit)
                } finally {

                }
            }
        }
    }

    fun logOut() {
        appAuth.deleteTokens()
        currentUser = Utils.Empty.emptyUser
    }

    private suspend fun getUserInfo() {
        try {
            currentUser = userRepository.getUserInfo()
        } catch (e: Exception) {
            e.printStackTrace()
            getUserInfoExceptionEvent.emit(Unit)
        }
    }

    suspend fun loadUserList() {
        try {
            userList = userRepository.getAllUsers()
            userListLoadedEvent.emit(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            getUserListExceptionEvent.emit(Unit)
        }
    }
}