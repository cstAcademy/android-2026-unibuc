package cst.unibucfmiif2026.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import cst.unibucfmiif2026.ApplicationController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.authDataStore by preferencesDataStore(name = "auth_prefs")

object AuthDataStore {
    private val KEY_TOKEN = stringPreferencesKey("auth_token")

    suspend fun saveToken(token: String) {
        ApplicationController.instance.authDataStore.edit { prefs ->
            prefs[KEY_TOKEN] = token
        }
    }

    suspend fun clearToken() {
        ApplicationController.instance.authDataStore.edit { prefs ->
            prefs.remove(KEY_TOKEN)
        }
    }

    val tokenFlow: Flow<String?> = ApplicationController.instance.authDataStore.data.map { prefs ->
        prefs[KEY_TOKEN]
    }

//    suspend fun getToken() = ApplicationController.instance.authDataStore.edit { prefs ->
//        prefs[KEY_TOKEN] // TODO - get as STRING
//    }
}