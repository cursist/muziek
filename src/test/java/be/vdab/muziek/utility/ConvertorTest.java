package be.vdab.muziek.utility;

import org.junit.Test;

import static org.junit.Assert.*;
import static be.vdab.muziek.utility.Convertor.*;

public class ConvertorTest {
    @Test
    public void doubleNaarMinutenString() {
        assertEquals("0:00", printDoubleAlsMinutenEnSeconden(0));
        assertEquals("10:00", printDoubleAlsMinutenEnSeconden(600));
        assertEquals("10:10", printDoubleAlsMinutenEnSeconden(610));
        assertEquals("10:01", printDoubleAlsMinutenEnSeconden(601));
        assertEquals("0:00", printDoubleAlsMinutenEnSeconden(-72));
    }
}