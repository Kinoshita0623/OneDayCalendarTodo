package jp.panta.onedaycalendartodo.domain

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class MonthCalendarTest{

    @Test
    fun defaultFillSpacedCalendar(){
        val monthCalendar = MonthCalendar(year = 2020, month = 2, timeList = emptyList())
        val firstDate = monthCalendar.fillSpacedStartCalendar()
        assert(firstDate.get(Calendar.DATE) == 26)
    }



    @Test
    fun startSaturdayDayOfWeekFillSpacedCalendar(){

        val monthCalendar = MonthCalendar(year = 2020, month = 2, timeList = emptyList(), startDayOfWeek = DayOfWeek.SATURDAY)
        val firstDate = monthCalendar.fillSpacedStartCalendar()
        assert(firstDate.get(Calendar.DATE) == 1)
    }

    @Test
    fun startMondayDayOfWeekFillSpacedCalendar(){
        val monthCalendar = MonthCalendar(year = 2020, month = 3, timeList = emptyList(), startDayOfWeek = DayOfWeek.MONDAY)
        val firstDate = monthCalendar.fillSpacedStartCalendar()
        assert(firstDate.get(Calendar.DATE) == 24)
    }
}