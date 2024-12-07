package com.hyper.customai.data.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

actual fun createDataStorePlatform(): DataStore<Preferences> {
    return createDataStore {
        USER_DATA_STORE_FILE_NAME
    }
}