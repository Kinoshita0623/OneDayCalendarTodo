package jp.panta.onedaycalendartodo.domain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Time::class, childColumns = ["timeId"], parentColumns = ["id"], onDelete = ForeignKey.SET_DEFAULT)])
class Todo(
    @Ignore val note: Note,
    @Ignore var time: Time
){
    var isComplete: Boolean = false

    val timeId = time.id

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}