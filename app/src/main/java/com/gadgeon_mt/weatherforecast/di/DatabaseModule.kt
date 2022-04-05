package com.gadgeon_mt.weatherforecast.di

import android.content.Context
import androidx.room.Room
import com.gadgeon_mt.weatherforecast.R
import com.gadgeon_mt.weatherforecast.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            context.getString(R.string.database)
        ).build()
    }

    @Singleton
    @Provides
    fun provideDashboardDao(db: AppDatabase) = db.WeatherDao()
}