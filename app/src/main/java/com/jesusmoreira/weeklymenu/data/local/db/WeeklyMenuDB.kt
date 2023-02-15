package com.jesusmoreira.weeklymenu.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jesusmoreira.weeklymenu.data.local.dao.RecipeDao
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe

@Database(
    entities = [Recipe::class],
    version = 1
)
abstract class WeeklyMenuDB: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        /*The value of a volatile variable will never be cached, and all writes and reads will be done to and from the main memory.
        This helps make sure the value of INSTANCE is always up-to-date and the same for all execution threads.
        It means that changes made by one thread to INSTANCE are visible to all other threads immediately.*/
        @Volatile
        private var INSTANCE: WeeklyMenuDB? = null
        private var DB_NAME = "WeeklyMenuDB"

        fun getInstance(context: Context): WeeklyMenuDB {
            // only one thread of execution at a time can enter this block of code
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        WeeklyMenuDB::class.java,
                        DB_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}