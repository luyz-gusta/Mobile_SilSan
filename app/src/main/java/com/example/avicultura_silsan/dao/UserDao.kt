package com.example.avicultura_silsan.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.avicultura_silsan.models_private.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    @Query("DELETE FROM tbl_user")
    fun deleteAll(): Int

    @Query("SELECT * FROM tbl_user")
    fun findUsers(): List<User>

}