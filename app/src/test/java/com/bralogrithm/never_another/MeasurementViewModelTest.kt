package com.bralogrithm.never_another

import androidx.lifecycle.viewmodel.compose.viewModel
import com.bralogrithm.never_another.model.Flow
import com.bralogrithm.never_another.viewmodel.FlowViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MeasurementViewModelTest {
    val flowViewModel = FlowViewModel()

    @Test
    fun `is upper circumference valid`(){
        val (min, max) = flowViewModel.rangeForStep(Flow.UpperSize)
            ?: error("Intet interval defineret for UpperSize")

        assertEquals(null, flowViewModel.errorForStep(Flow.UpperSize, "77"))
        assertEquals(null, flowViewModel.errorForStep(Flow.UpperSize, "100"))
        assertEquals(null, flowViewModel.errorForStep(Flow.UpperSize, "113"))
        assertEquals(null, flowViewModel.errorForStep(Flow.UpperSize, "  80  "))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UpperSize, "114"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UpperSize, "76"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UpperSize, "-1"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UpperSize, "-1001"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UpperSize, "10000"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.UpperSize, "2   0"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.UpperSize, "Hej"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.UpperSize, "//."))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.UpperSize, ""))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.UpperSize, "     "))

    }

    @Test
    fun `is lower circumference valid`(){
        val (min, max) = flowViewModel.rangeForStep(Flow.UnderSize)
            ?: error("Intet interval defineret for UnderSize")

        assertEquals(null, flowViewModel.errorForStep(Flow.UnderSize, "65"))
        assertEquals(null, flowViewModel.errorForStep(Flow.UnderSize, "78"))
        assertEquals(null, flowViewModel.errorForStep(Flow.UnderSize, "100"))
        assertEquals(null, flowViewModel.errorForStep(Flow.UnderSize, "  80  "))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UnderSize, "101"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UnderSize, "64"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UnderSize, "-1"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UnderSize, "-1001"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.UnderSize, "10000"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.UnderSize, "2   0"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.UnderSize, "Hej"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.UnderSize, "//."))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.UnderSize, ""))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.UnderSize, "     "))

    }


    @Test
    fun `is breast height valid`(){
        val (min, max) = flowViewModel.rangeForStep(Flow.BreastHeight)
            ?: error("Intet interval defineret for UnderSize")

        assertEquals(null, flowViewModel.errorForStep(Flow.BreastHeight, "40"))
        assertEquals(null, flowViewModel.errorForStep(Flow.BreastHeight, "0"))
        assertEquals(null, flowViewModel.errorForStep(Flow.BreastHeight, "20"))
        assertEquals(null, flowViewModel.errorForStep(Flow.BreastHeight, "  20  "))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastHeight, "41"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastHeight, "-10"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastHeight, "-1"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastHeight, "-1001"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastHeight, "10000"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.BreastHeight, "2   0"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.BreastHeight, "Hej"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.BreastHeight, "//."))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.BreastHeight, ""))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.BreastHeight, "     "))


    }

    @Test
    fun `is breast span valid`(){
        val (min, max) = flowViewModel.rangeForStep(Flow.BreastSize)
            ?: error("Intet interval defineret for UnderSize")

        assertEquals(null, flowViewModel.errorForStep(Flow.BreastSize, "40"))
        assertEquals(null, flowViewModel.errorForStep(Flow.BreastSize, "0"))
        assertEquals(null, flowViewModel.errorForStep(Flow.BreastSize, "20"))
        assertEquals(null, flowViewModel.errorForStep(Flow.BreastSize, "  20  "))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastSize, "41"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastSize, "-10"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastSize, "-1"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastSize, "-1001"))
        assertEquals("Skal være mellem $min og $max cm", flowViewModel.errorForStep(Flow.BreastSize, "10000"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.BreastSize, "2   0"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.BreastSize, "Hej"))
        assertEquals("Skal være et tal", flowViewModel.errorForStep(Flow.BreastSize, "//."))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.BreastSize, ""))
        assertEquals("Udfyld feltet", flowViewModel.errorForStep(Flow.BreastSize, "     "))



    }

}