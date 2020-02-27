package jp.panta.onedaycalendartodo

import org.junit.Test
import java.util.*


class CalendarTest{

    @Test
    fun firstDayOfWeekTest(){
        val indexCalendar = Calendar.getInstance()

        val testCalendar = Calendar.getInstance()
        testCalendar.firstDayOfWeek = Calendar.MONDAY

        val testDayOfWeek = testCalendar.get(Calendar.DAY_OF_WEEK)
        val indexDayOfWeek = indexCalendar.get(Calendar.DAY_OF_WEEK)
        assert(testDayOfWeek == indexDayOfWeek)
    }

    @Test
    fun dayOfWeekLogicTest(){
        val calendar = Calendar.getInstance()
        //calendar.firstDayOfWeek =
        calendar.set(Calendar.WEEK_OF_MONTH, 1)
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)

        println("month:${calendar.get(Calendar.MONTH) + 1}, date:${calendar.get(Calendar.DATE)}")
    }

    @Test
    fun earlyMonthTest(){
        val c = Calendar.getInstance()
        c.set(Calendar.WEEK_OF_MONTH, 1)
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
        println(c.get(Calendar.DATE))
    }
}