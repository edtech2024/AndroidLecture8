package com.example.myapplicationeight.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName


@Entity(tableName = "items")
data class Item (
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    @SerialName("id")
    var id: Int?,
    @SerializedName("uid")
    @SerialName("uid")
    @ColumnInfo(name = "uid")
    var uid:String?,
    @SerializedName("title")
    @ColumnInfo(name = "title")
    @SerialName("title")
    var title: String?,
    @SerializedName("description")
    @ColumnInfo(name = "description")
    @SerialName("description")
    var description: String?,
    @SerializedName("priority")
    @ColumnInfo(name = "priority")
    @SerialName("priority")
    var priority: Int?,
    @SerializedName("type")
    @ColumnInfo(name = "type")
    @SerialName("type")
    var type: Int?,
    @SerializedName("count")
    @ColumnInfo(name = "count")
    @SerialName("count")
    var count: Int?,
    @SerializedName("frequency")
    @ColumnInfo(name = "frequency")
    @SerialName("frequency")
    var frequency:Int?,
    @SerializedName("color")
    @ColumnInfo(name = "color")
    @SerialName("color")
    var color: Int?,
    @SerializedName("date")
    @ColumnInfo(name = "date")
    @SerialName("date")
    var date: Long?
)