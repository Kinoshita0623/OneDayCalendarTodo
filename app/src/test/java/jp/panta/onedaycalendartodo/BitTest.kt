package jp.panta.onedaycalendartodo

import org.junit.Test
import java.nio.ByteBuffer


class BitTest {

    @Test
    fun shiftTest(){
        val date = 31

        val month = 0

        val year = 2019

        val yearLong = year.toLong()
        val dateLong = date.toLong()

        val monthLong = month.toLong()

        val id = dateLong or monthLong.shl(5) or yearLong.shl(9)

        val binaryShiftYear = year.shl(9)

        val DATE_MASK = 31

        val MONTH_MASK = 15

        println(java.lang.Long.toBinaryString(id))

        println("year:${id.shr(9)}")
        println("month:${id.shr(5) and MONTH_MASK.toLong()}")
        println("date:${id and DATE_MASK.toLong()}")

    }
}