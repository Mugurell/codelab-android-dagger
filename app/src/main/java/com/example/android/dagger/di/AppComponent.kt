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
import com.example.android.dagger.user.UserManager
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

// Scope annotation that the AppComponent uses
// Classes annotated with @Singleton will have a unique instance in this Component
@Singleton
// Definition of a the kotlin-inject component that can be the parent of all others in the graph
@Component
abstract class AppComponent(
    @get:Provides val context: Context
) : StorageComponent {
    abstract val userManager: UserManager

    companion object
}

interface AppComponentProvider {
    val appComponent: AppComponent
}

val Context.applicationComponent
    get() = (applicationContext as AppComponentProvider).appComponent
