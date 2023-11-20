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
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

// Scope annotation that the AppComponent uses
// Classes also using "@SingleIn(AppScope::class)" will have a unique instance in this Component
// Definition of a Dagger component that will collect info from all other modules and components
// which use the "AppScope" marker to provide new dependencies to the top level of the graph
@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun userManager(): UserManager
}