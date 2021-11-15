package com.example.learnandroidx.room

import androidx.room.Dao
import androidx.room.Insert

/**
 * @author    yiliyang
 * @date      20-12-25 上午10:25
 * @version   1.0
 * @since     1.0
 */
@Dao
interface StudentDao {
    @Insert
    fun insert(student: Student)
}