package com.skillbox.aslanbolurov.di_bicycle.koin_bicycle

import com.skillbox.aslanbolurov.di_bicycle.dagger_bicycle.BicycleFactory
import com.skillbox.aslanbolurov.di_bicycle.dagger_bicycle.FrameFactory
import com.skillbox.aslanbolurov.di_bicycle.dagger_bicycle.WheelDealer
import org.koin.dsl.module

val bicycleModule = module {
    single<WheelDealer> { provideWheelDealer() }
    single<FrameFactory> { provideFrameFactory() }
    factory<BicycleFactory> { provideBicycleFactory(get(),get()) }
}
private fun provideWheelDealer(): WheelDealer = WheelDealer()
private fun provideFrameFactory(): FrameFactory = FrameFactory()
private fun provideBicycleFactory(
    wheelDealer: WheelDealer,
    frameFactory: FrameFactory
): BicycleFactory {
    return BicycleFactory(wheelDealer,frameFactory)
}