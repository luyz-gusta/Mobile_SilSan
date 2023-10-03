package com.example.avicultura_silsan.sqlite_repository

import android.content.Context
import com.example.avicultura_silsan.models_private.SilSanDb
import com.example.avicultura_silsan.models_private.User

class UserRepository(context: Context) {

    private val db = SilSanDb.getDatabase(context)

    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    fun findUsers(): List<User> {
        return db.userDao().findUsers()
    }

    fun deleteAllUser(): Int{
        return  db.userDao().deleteAll()
    }

}