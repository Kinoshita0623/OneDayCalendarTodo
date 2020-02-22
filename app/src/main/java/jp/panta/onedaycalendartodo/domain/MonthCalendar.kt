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

        val oneDayOfWeek = DayOfWeek.values()[oneDay.get(Calendar.DAY_OF_WEEK) - 1]


        val dayOfWeekList = DayOfWeek.values().toList()
        val startIndex = dayOfWeekList.indexOf(startDayOfWeek)
        println("startIndex:$startIndex")
        val diffDayOfWeek = dayOfWeekList.subList(0, startIndex)
        val adjustmentDayOfWeekList = ArrayList(dayOfWeekList).apply{
            removeAll(diffDayOfWeek)
            addAll(diffDayOfWeek)
        } as List<DayOfWeek>

        println("adjustWeek:$adjustmentDayOfWeekList")

        val spaceDateCount = adjustmentDayOfWeekList.indexOf(oneDayOfWeek)

        return oneDay.apply{
            add(Calendar.DATE, - spaceDateCount)
        }
    }
}