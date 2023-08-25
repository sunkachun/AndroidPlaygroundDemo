package com.example.androidplaygrounddemo.ui.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerMyApplicationComponent.factory().create(this)
    }
}