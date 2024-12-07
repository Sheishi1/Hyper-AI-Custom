package com.hyper.customai.data.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.hyper.customai.Application

actual fun createDataStorePlatform(): DataStore<Preferences> {
    return createDataStore {
        Application().getContext().filesDir.resolve(USER_DATA_STORE_FILE_NAME).absolutePath
    }
}

