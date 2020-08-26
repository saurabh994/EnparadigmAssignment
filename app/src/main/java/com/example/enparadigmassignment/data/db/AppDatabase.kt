package com.example.enparadigmassignment.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.enparadigmassignment.data.db.dao.WeatherDao
import com.example.enparadigmassignment.data.db.typeconverter.FeelsLikeConverter
import com.example.enparadigmassignment.data.db.typeconverter.TempConverter
import com.example.enparadigmassignment.data.db.typeconverter.WeatherConverter
import com.example.enparadigmassignment.data.model.DailyItem
import timber.log.Timber

@Database(entities = [DailyItem::class],version = 1)
@TypeConverters(
    WeatherConverter::class,
    FeelsLikeConverter::class,
    TempConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        const val DB_NAME = "sample-db"
        private val lock = Any()
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                Timber.d("getInstance")
                if (INSTANCE == null) {
                    INSTANCE = createDB(context)
                }
                return INSTANCE as AppDatabase
            }
        }


        private fun createDB(context: Context): AppDatabase {
            Timber.d("createDB")
            val database: Builder<AppDatabase> =
                Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            return database
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Timber.d("onCreate")
                    }
                })
                .build()
        }
    }
}