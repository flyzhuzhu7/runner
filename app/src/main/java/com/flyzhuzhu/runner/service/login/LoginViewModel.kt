package com.flyzhuzhu.runner.service.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.flyzhuzhu.runner.bean.User

class LoginViewModel {

    //用户
    private var user: MutableLiveData<User> = MutableLiveData<User>()

    fun getUser(): LiveData<User> {
        return user
    }

    fun login() {

    }

}