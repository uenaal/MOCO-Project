package com.example.testforcoronaapp.model.room.currentDistrict

import androidx.room.*
import com.example.testforcoronaapp.model.room.lastDistrict.LastDistrict

@Dao
interface CurrentDistrictDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg currentDistrict: CurrentDistrict)

    @Query("SELECT * FROM current_district")
    fun getLastCurrentDistrict() : CurrentDistrict

    @Query("SELECT * FROM current_district")
    suspend fun getLastCurrentDistrictSuspend() : CurrentDistrict

    @Query("SELECT count(*) FROM current_district")
    fun isEmpty() : Int

    @Delete
    fun delete(vararg district: CurrentDistrict)


}