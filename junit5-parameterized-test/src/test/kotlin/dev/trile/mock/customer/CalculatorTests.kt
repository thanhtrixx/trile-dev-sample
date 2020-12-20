package dev.trile.mock.customer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.time.Month
import java.util.stream.Stream





internal class StringTests {

  @ParameterizedTest(name = "#{index} - String.isNullOrBlank() of [{0}]")
  @EmptySource
  @NullSource
  @ValueSource(strings = ["", " ", "  ", "        ", "\n", "\t"])
  fun `test isNullOrBlank`(str: String?) {
    assertTrue(str.isNullOrBlank())
  }

  @ParameterizedTest(name = "#{index} - String.toUpperCase() of [{0}]")
  @CsvSource("trile,TRILE", "tRilE,TRILE", "trILE,TRILE")
  fun `test trim`(str: String, expected: String) {
    val actual = str.toUpperCase()
    assertEquals(expected, actual)
  }

  @ParameterizedTest(name = "#{index} - String.toUpperCase() of [{0}]")
  @CsvFileSource(resources = ["/trim.csv"], numLinesToSkip = 1)
  fun `test trim csv file`(str: String, expected: String) {
    val actual = str.toUpperCase()
    assertEquals(expected, actual)
  }

  @ParameterizedTest(name = "#{index} - [{0}] have 30 day")
  @EnumSource(value = Month::class, names = ["APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"])
  fun `test month have 30 day`(month: Month) {
    val isALeapYear = false
    assertEquals(30, month.length(isALeapYear))
  }

}
