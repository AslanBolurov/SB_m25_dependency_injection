package com.skillbox.aslanbolurov.di_bicycle

import android.app.Application
import com.skillbox.aslanbolurov.di_bicycle.dagger_bicycle.DaggerBicycleComponent
import com.skillbox.aslanbolurov.di_bicycle.dagger_bicycle.DaggerDaggerBicycleComponent
import com.skillbox.aslanbolurov.di_bicycle.dagger_bicycle.FrameFactory
import com.skillbox.aslanbolurov.di_bicycle.koin_bicycle.bicycleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
    lateinit var dagger: DaggerBicycleComponent
    val frameFactory = FrameFactory()
    override fun onCreate() {
        super.onCreate()
        //DaggerDaggerInfoComponent.builder().build()
        dagger = DaggerDaggerBicycleComponent.builder().build()
        startKoin {
            androidContext(applicationContext)
            modules(bicycleModule)
        }
    }
}