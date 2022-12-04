package heenu.moon.moneymountain.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import heenu.moon.moneymountain.data.local.converter.DateConverters
import heenu.moon.moneymountain.data.local.dao.BudgetDao
import heenu.moon.moneymountain.data.local.dao.ExpenditureDao
import heenu.moon.moneymountain.data.local.dao.IncomeDao
import heenu.moon.moneymountain.data.local.dao.SavingDao
import heenu.moon.moneymountain.data.local.model.Budget
import heenu.moon.moneymountain.data.local.model.Expenditure
import heenu.moon.moneymountain.data.local.model.Income
import heenu.moon.moneymountain.data.local.model.Saving
import javax.inject.Singleton

@Database(entities = [Budget::class, Saving::class, Income::class, Expenditure::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class MoneyMountainDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao

    abstract fun expenditureDao(): ExpenditureDao

    abstract fun savingDao(): SavingDao

    abstract fun incomeDao(): IncomeDao
}