package com.example.learnandroidx.room

import android.app.Person
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.learnandroidx.room.DBHelper.getDBInstance

/**
 * @author    yiliyang
 * @date      20-12-25 上午10:26
 * @version   1.0
 * @since     1.0
 */
object DBHelper {

    private var db: MyRoomDatabase? = null

    fun getDBInstance(context: Context): MyRoomDatabase {
        return db ?: synchronized(DBHelper::class.java) {
            db ?: Room.databaseBuilder(
                context.applicationContext,
                MyRoomDatabase::class.java, "my_db"
            )
//                .fallbackToDestructiveMigration() 迁移失败是否允许数据丢失
                .addMigrations(MIGRATION_1_2).addMigrations(MIGRATION_2_3)
                .build().also {
                    db = it
                }
        }
    }

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            println("Migration_1_2")
        }
    }
    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            println("Migration_2_3")
        }
    }

}

val Context.studentDao: StudentDao
    get() = getDBInstance(this).studentDao()