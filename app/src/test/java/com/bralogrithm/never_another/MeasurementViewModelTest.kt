package com.bralogrithm.never_another

import com.bralogrithm.never_another.viewmodel.MeasurementsViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MeasurementViewModelTest {
    val viewModel = MeasurementsViewModel()

    @Test
    fun `is upper circumference valid`(){
        assertEquals(true, viewModel.isUpperCircumferenceValid("100"))
        assertEquals(true, viewModel.isUpperCircumferenceValid("77"))
        assertEquals(true, viewModel.isUpperCircumferenceValid("113"))
        assertEquals(true, viewModel.isUpperCircumferenceValid("  80  "))
        assertEquals(false, viewModel.isUpperCircumferenceValid("114"))
        assertEquals(false, viewModel.isUpperCircumferenceValid("76"))
        assertEquals(false, viewModel.isUpperCircumferenceValid("-1"))
        assertEquals(false, viewModel.isUpperCircumferenceValid("Hej"))
        assertEquals(false, viewModel.isUpperCircumferenceValid("//."))
        assertEquals(false, viewModel.isUpperCircumferenceValid("-1001"))
        assertEquals(false, viewModel.isUpperCircumferenceValid("10000"))
        assertEquals(false, viewModel.isUpperCircumferenceValid("2  0"))
    }

    @Test
    fun `is lower circumference valid`(){
        assertEquals(true, viewModel.isLowerCircumferenceValid("78"))
        assertEquals(true, viewModel.isLowerCircumferenceValid("65"))
        assertEquals(true, viewModel.isLowerCircumferenceValid("100"))
        assertEquals(true, viewModel.isLowerCircumferenceValid("  80  "))
        assertEquals(false, viewModel.isLowerCircumferenceValid("101"))
        assertEquals(false, viewModel.isLowerCircumferenceValid("64"))
        assertEquals(false, viewModel.isLowerCircumferenceValid("-1"))
        assertEquals(false, viewModel.isLowerCircumferenceValid("Hej"))
        assertEquals(false, viewModel.isLowerCircumferenceValid("//."))
        assertEquals(false, viewModel.isLowerCircumferenceValid("-1001"))
        assertEquals(false, viewModel.isLowerCircumferenceValid("10000"))
        assertEquals(false, viewModel.isLowerCircumferenceValid("2  0"))

    }

    @Test
    fun `is breast span valid`(){
        assertEquals(true, viewModel.isBreastSpanValid("0"))
        assertEquals(true, viewModel.isBreastSpanValid("40"))
        assertEquals(true, viewModel.isBreastSpanValid("20"))
        assertEquals(true, viewModel.isBreastSpanValid("  20  "))
        assertEquals(false, viewModel.isBreastSpanValid("41"))
        assertEquals(false, viewModel.isBreastSpanValid("-1"))
        assertEquals(false, viewModel.isBreastSpanValid("Hej"))
        assertEquals(false, viewModel.isBreastSpanValid("//."))
        assertEquals(false, viewModel.isBreastSpanValid("-1001"))
        assertEquals(false, viewModel.isBreastSpanValid("10000"))
        assertEquals(false, viewModel.isBreastSpanValid("2  0"))


    }
    @Test
    fun `is breast height valid`(){
        assertEquals(true, viewModel.isHeightValid("0"))
        assertEquals(true, viewModel.isHeightValid("40"))
        assertEquals(true, viewModel.isHeightValid("20"))
        assertEquals(true, viewModel.isHeightValid("  20  "))
        assertEquals(false, viewModel.isHeightValid("2  0"))
        assertEquals(false, viewModel.isHeightValid("41"))
        assertEquals(false, viewModel.isHeightValid("-1"))
        assertEquals(false, viewModel.isHeightValid("Hej"))
        assertEquals(false, viewModel.isHeightValid("-1001"))
        assertEquals(false, viewModel.isHeightValid("10000"))
        assertEquals(false, viewModel.isHeightValid("//."))

    }
}