package com.example.mybaseproject2.data.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mybaseproject2.data.responses.User
import com.example.mybaseproject2.data.roomdb.dao.UserDao

/**
 * Created By Lincoln
 */

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MyRoomDB :RoomDatabase() {
    abstract fun myDao(): UserDao
    companion object {
        private var INSTANCE: MyRoomDB? = null
        fun getDatabase(context: Context): MyRoomDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, MyRoomDB::class.java, "MyRoomDB")
                            .build()
                }
            }
            return INSTANCE!!
        }




        // Migrations
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
            }
        }

    }

}