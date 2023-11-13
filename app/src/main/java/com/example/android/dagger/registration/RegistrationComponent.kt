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

package com.example.android.dagger.registration

import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.di.AppComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsViewModel
import me.tatarka.inject.annotations.Component

// Scope annotation that the RegistrationComponent uses
// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
// Definition of a kotlin-inject subcomponent
@Component
abstract class RegistrationComponent(@Component val parent: AppComponent) {
    abstract val registrationViewModel: RegistrationViewModel
    abstract val enterDetailsViewModel: EnterDetailsViewModel

    companion object
}
