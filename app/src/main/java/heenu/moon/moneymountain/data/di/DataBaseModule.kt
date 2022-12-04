package heenu.moon.moneymountain.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import heenu.moon.moneymountain.data.local.MoneyMountainDatabase
import heenu.moon.moneymountain.data.local.converter.DateConverters
import heenu.moon.moneymountain.data.local.dao.ExpenditureDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
        dateConverters: DateConverters
    ): MoneyMountainDatabase =
        Room.databaseBuilder(context, MoneyMountainDatabase::class.java, "monenyMountain.db")
            .addTypeConverter(dateConverters)
            .build()


    @Singleton
    @Provides
    fun provideExpenditureDao(database: MoneyMountainDatabase): ExpenditureDao =
        database.expenditureDao()
}