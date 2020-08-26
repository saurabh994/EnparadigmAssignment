package com.example.enparadigmassignment.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.enparadigmassignment.data.model.DailyItem

@Dao
interface WeatherDao: BaseDao<DailyItem> {
    @Query("SELECT * FROM DailyItem")
    fun getAllItems(): LiveData<List<DailyItem>>

    @Query("DELETE FROM DailyItem")
    fun clear()
}