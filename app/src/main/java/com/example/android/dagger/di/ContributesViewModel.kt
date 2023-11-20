package com.example.android.dagger.di

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ContributesViewModel(
    /**
     * The scope in which to include this contributed ViewModel
     */
    val scope: KClass<*>,
)
