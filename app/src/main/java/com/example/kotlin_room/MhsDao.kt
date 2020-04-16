package com.example.kotlin_room

import androidx.room.*

@Dao
interface MhsDao{
    @Query("Select * from mhsentity")
    fun getAll(): List<MhsEntity>

    @Query("SELECT * FROM MHSENTITY WHERE nama like :nama")
    fun findByName(nama: String): MhsEntity

    @Insert
    fun insertAll(vararg mhsData: MhsEntity)

    @Delete
    fun deleteData(mhs: MhsEntity)

    @Update
    fun updateData(vararg  mhsData: MhsEntity)
}