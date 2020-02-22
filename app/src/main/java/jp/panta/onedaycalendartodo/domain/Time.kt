package jp.panta.onedaycalendartodo.domain

import androidx.room.*

import java.nio.LongBuffer
import java.nio.ShortBuffer
import java.util.*
import kotlin.collections.ArrayList

@Entity(indices = [Index(value = ["year", "month", "date"])])
class Time(
    val year: Short,
    val month: Byte,
    val date: Byte
){

    companion object{
        fun createId(year: Short, month: Byte, date: Byte): Long{
            val yearLong = year.toLong()
            val dateLong = date.toLong()
            val monthLong = month.toLong()
            return dateLong or monthLong.shl(5) or yearLong.shl(9)
        }
    }

    @PrimaryKey(autoGenerate = false)
    val id: Long

    init{
        require(month in 1..12) { "１から１２の間で設定する必要があります" }

        require(date in 1..31) { "dateは1から31の範囲で設定する必要があります" }

        this.id =  createId(year, month, date)
    }

    @Relation(entityColumn = "timeId", parentColumn = "id")
    var todo = ArrayList<Todo>()

    private fun toCalendar() : Calendar{
        return Calendar.getInstance().also{
            it.set(Calendar.YEAR, year.toInt())
            it.set(Calendar.MONTH, month.toInt())
            it.set(Calendar.DATE, date.toInt())
        }
    }

    @Ignore
    fun getDayOfWeek(): DayOfWeek{
        return DayOfWeek.values()[toCalendar().get(Calendar.DAY_OF_WEEK) - 1]
    }

    @Ignore
    fun toDate(): Date{
        return toCalendar().time
    }

}