package com.example.mc.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mc.common.Enviroment

@Entity(tableName = Enviroment.PAYMENTS)
class Payment(val payment: Int) {

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
}