package jp.panta.onedaycalendartodo.domain

import java.util.*

class MonthCalendar(
    timeList: List<Time>,
    val year: Int,
    val month: Int,
    val startDayOfWeek: DayOfWeek = DayOfWeek.SUNDAY,
    val heightSpace: Int = 6
) {
    fun getEmptyTimeList(): List<Time>{

        val counterCalendar = fillSpacedStartCalendar()

        return (0.until(heightSpace * 7)).map{
            counterCalendar.add(Calendar.DATE, 1)
            val year = counterCalendar.get(Calendar.YEAR)
            val month = counterCalendar.get(Calendar.MONTH)
            val date = counterCalendar.get(Calendar.DATE)

            Time(year = year.toShort(), month = (month + 1).toByte(), date = date.toByte())
        }

    }

    fun fillSpacedStartCalendar(): Calendar{
        val oneDay = Calendar.getInstance()
        oneDay.set(Calendar.YEAR, year)
        oneDay.set(Calendar.MONTH, month - 1)
        oneDay.set(Calendar.DATE, 1)

        val oneDayOfWeekValue = oneDay.get(Calendar.DAY_OF_WEEK)
        if(oneDayOfWeekValue == startDayOfWeek.calendarValue){
            return oneDay
        }

        if(oneDayOfWeekValue < startDayOfWeek.calendarValue){
            val n = 7 - (startDayOfWeek.calendarValue - 1)
            val diff = oneDayOfWeekValue - 1 + n
            oneDay.add(Calendar.DATE, - diff)
            return oneDay
        }

        if(oneDayOfWeekValue > startDayOfWeek.calendarValue){
            val diff = oneDayOfWeekValue - startDayOfWeek.calendarValue
            oneDay.add(Calendar.DATE, - diff)

            return oneDay
        }

        return oneDay

    }
}