package jp.panta.onedaycalendartodo.domain

import java.time.Year
import java.util.*

class CalendarRequest(
    /**
     * 取得する範囲を設定する
     */
    val type: Type,
    calendar: Calendar,
    val startDayOfWeek: DayOfWeek = DayOfWeek.SUNDAY,
    val heightSpace: Int = 6,
    val isFillCalendarSpace: Boolean = true
) {
    enum class Type{
        YEAR,
        MONTH,
        DATE
    }

    private class CalendarHolder(c: Calendar, startDayOfWeek: DayOfWeek = DayOfWeek.SUNDAY): Cloneable{
        companion object{
            private val dayOfWeeks = DayOfWeek.values()
        }
        private val calendar: Calendar
        init{
            c.firstDayOfWeek = startDayOfWeek.calendarValue
            this.calendar = c
        }
        val year: Int = calendar.get(Calendar.YEAR)
        val month: Int = calendar.get(Calendar.MONTH)
        val date: Int = calendar.get(Calendar.DATE)
        val dayOfWeek = dayOfWeeks[calendar.get(Calendar.DAY_OF_WEEK) - 1]

        /**
         * 何週目かを求める
         */
        val weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH)

        override fun clone(): Calendar {
            return calendar.clone() as Calendar
        }

        fun cloneCalendar(): Calendar{
            return clone()
        }

    }

    private val mCalendar = CalendarHolder(calendar)



    fun weeksFirst(): Calendar{
        val calendar = mCalendar.cloneCalendar()
        calendar.set(Calendar.DAY_OF_WEEK, startDayOfWeek.calendarValue)
        return calendar
    }

    fun fillSpacedStartMonthCalendar(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, mCalendar.year)
        calendar.set(Calendar.MONTH, mCalendar.month)
        calendar.set(Calendar.DATE, mCalendar.date)
        calendar.firstDayOfWeek = startDayOfWeek.calendarValue

        calendar.set(Calendar.WEEK_OF_MONTH, 1)
        calendar.set(Calendar.DAY_OF_WEEK, startDayOfWeek.calendarValue)

        return calendar
    }

    fun fillSpacedEndMonthCalendar(): Calendar {
        return fillSpacedStartMonthCalendar().apply{
            add(Calendar.DATE, 7 * heightSpace)
        }
    }
}