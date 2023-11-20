package com.example.android.dagger.di

import javax.inject.Scope
import kotlin.reflect.KClass
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleIn(val scope: KClass<*>)
