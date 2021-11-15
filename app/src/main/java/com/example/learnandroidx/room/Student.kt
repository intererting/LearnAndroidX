package com.example.learnandroidx.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author    yiliyang
 * @date      20-12-25 上午10:22
 * @version   1.0
 * @since     1.0
 */
@Entity(tableName = "tb_student")
data class Student(
    var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
