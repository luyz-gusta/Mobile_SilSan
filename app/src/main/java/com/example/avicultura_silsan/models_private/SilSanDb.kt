package com.example.avicultura_silsan.models_private

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.avicultura_silsan.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class SilSanDb : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        private lateinit var instanceDb: SilSanDb

        fun getDatabase(context: Context): SilSanDb {
            // :: =  entregar uma instancia do objeto, me devolve um false se não existir nada

            //se isso for verdade
            if (!::instanceDb.isInitialized) {
                //.databaseBuilder =  criar um banco de dados
                // criar a instancia
                instanceDb = Room
                    .databaseBuilder(
                        context, //contexto da minha aplicação
                        SilSanDb::class.java, //ja esta criando automaticamente a instancia
                        "db_silsan" // nome do banco
                    ).allowMainThreadQueries().build()
            }
            return instanceDb

        }
    }
}