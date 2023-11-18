/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class SettingsStorage

const val DATA_STORAGE = "DI_DATA_STORAGE_ID"


// Tells Dagger this is a Dagger module
@Module
class StorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @SettingsStorage
    @Provides
    fun provideSettingsStorage(context: Context): Storage {
        return SharedPreferencesStorage(context, "Dagger")
    }

    @Named(DATA_STORAGE)
    @Provides
    fun provideLoginStorage(context: Context): Storage {
        return SharedPreferencesStorage(context, "Data")
    }
}
