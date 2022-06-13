package com.feriusjosewil.resepai.ui.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feriusjosewil.resepai.api.Api
import com.feriusjosewil.resepai.api.ApiCallback
import com.feriusjosewil.resepai.api.Client
import com.feriusjosewil.resepai.api.LoginResponse
import com.feriusjosewil.resepai.model.User
import com.feriusjosewil.resepai.preference.UserPreference
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val pref: UserPreference) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val list = ArrayList<User>()

    fun login(email: String, password: String, callback: ApiCallback){
        isLoading.value = true
        val api = Client.instance.login(email, password)
        api.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                isLoading.value = false
                if (response.isSuccessful) {
                    val user = response.body()
                    Log.d(TAG, "RESPONSE: ${user?.status} \n $user")
                    if (user != null) {
                        callback.onResponse(true, "success")
//                        login(
//                            User(
//                                list[0].userId,
//                                list[0].email,
//                                list[0].username,
//                                list[0].name,
//                                list[0].address,
//                                list[0].phone,
//                                list[0].photoUrl,
//                                true
//                        )
//                        )
                    } else {
                        callback.onResponse(false, "error")
                    }
                }
            }


            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                isLoading.value = false
                t.message?.let { Log.d("Something went wrong", it) }
            }
        })
    }

    fun login(user: User) {
        viewModelScope.launch {
            pref.login(user)
        }
    }
}