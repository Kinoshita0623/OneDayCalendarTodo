package jp.panta.onedaycalendartodo.domain

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["title"])])
class Note(
    val title: String,
    val description: String?
){
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
}