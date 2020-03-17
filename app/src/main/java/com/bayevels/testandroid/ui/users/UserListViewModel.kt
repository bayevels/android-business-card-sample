package com.bayevels.testandroid.ui.users

import androidx.lifecycle.ViewModel
import com.bayevels.testandroid.data.repository.UserRepository

class UserListViewModel : ViewModel() {
    val users = UserRepository.users
}
