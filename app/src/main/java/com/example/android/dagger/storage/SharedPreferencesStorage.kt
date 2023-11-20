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

package com.example.android.dagger.storage

import android.content.Context
import com.example.android.dagger.di.AppScope
import com.example.android.dagger.di.SingleIn
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class SettingsStorage

// @Inject tells Dagger how to provide instances of this type
@SettingsStorage
@ContributesBinding(AppScope::class)
@SingleIn(AppScope::class)
class SharedPreferencesStorage @Inject constructor(context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }
}
