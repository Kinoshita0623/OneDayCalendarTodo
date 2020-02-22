package jp.panta.onedaycalendartodo.domain

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class MonthCalendarTest{

    @Test
    fun defaultFillSpacedCalendar(){
        val today = Calendar.getInstance()
        val monthCalendar = MonthCalendar(year = today.get(Calendar.YEAR), month = today.get(Calendar.MONTH) + 1, timeList = emptyList())
        val firstDate = monthCalendar.fillSpacedStartCalendar()
        println(firstDate.get(Calendar.DATE))
    }

    @Test
    fun customDayOfWeekFillSpacedCalendar(){
        val today = Calendar.getInstance()
        val monthCalendar = MonthCalendar(year = today.get(Calendar.YEAR), month = today.get(Calendar.MONTH) + 1, timeList = emptyList(), startDayOfWeek = DayOfWeek.SATURDAY)
        val firstDate = monthCalendar.fillSpacedStartCalendar()
        println(firstDate.get(Calendar.DATE))
    }
}