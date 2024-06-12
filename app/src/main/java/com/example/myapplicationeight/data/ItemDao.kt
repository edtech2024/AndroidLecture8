package com.example.myapplicationeight.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplicationeight.domain.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItems(items: List<Item>)

    @Update
    suspend fun update(item: Item)

    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<Item>>

    @Query("DELETE FROM items")
    suspend fun deleteAll()

}