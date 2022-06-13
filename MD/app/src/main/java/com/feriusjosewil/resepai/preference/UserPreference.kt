package com.feriusjosewil.resepai.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.feriusjosewil.resepai.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    fun getUser(): Flow<User> {
        return dataStore.data.map { preferences ->
            User(
                preferences[USERID_KEY] ?: "",
                preferences[EMAIL_KEY] ?: "",
                preferences[USERNAME_KEY] ?:"",
                preferences[NAME_KEY] ?:"",
                preferences[ADDRESS_KEY] ?:"",
                preferences[PHONE_KEY] ?:"",
                preferences[PHOTO_URL_KEY] ?:"",
                preferences[STATE_KEY] ?: false
            )
        }
    }

    suspend fun login(user: User) {
        dataStore.edit { preferences ->
            preferences[USERID_KEY] = user.userId
            preferences[EMAIL_KEY] = user.email
            preferences[USERNAME_KEY] = user.username
            preferences[NAME_KEY] = user.name
            preferences[ADDRESS_KEY] = user.address
            preferences[PHONE_KEY] = user.phone
            preferences[PHOTO_URL_KEY] = user.photoUrl
            preferences[STATE_KEY] = user.isLogin
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences[USERID_KEY] = ""
            preferences[EMAIL_KEY] = ""
            preferences[USERNAME_KEY] = ""
            preferences[NAME_KEY] = ""
            preferences[ADDRESS_KEY] = ""
            preferences[PHONE_KEY] = ""
            preferences[PHOTO_URL_KEY] = ""
            preferences[STATE_KEY] = false
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val USERID_KEY = stringPreferencesKey("userId")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val USERNAME_KEY = stringPreferencesKey("username")
        private val NAME_KEY = stringPreferencesKey("name")
        private val ADDRESS_KEY = stringPreferencesKey("address")
        private val PHONE_KEY = stringPreferencesKey("phone")
        private val PHOTO_URL_KEY = stringPreferencesKey("photoUrl")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}