package com.example.learnandroidx.room

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

/**
 * @author    yiliyang
 * @date      20-12-25 上午10:23
 * @version   1.0
 * @since     1.0
 */
@Database(entities = [Student::class], version = 3, exportSchema = false)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}