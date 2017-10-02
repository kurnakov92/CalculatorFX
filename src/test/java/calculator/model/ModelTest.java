package calculator.model;

import calculator.conrollers.AlertDialogController;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {
    private double dividend;
    private double divider;

    @Test
    public void divisionByZero() throws Exception {
        dividend = 11;
        divider = 0;
        assertEquals(Double.POSITIVE_INFINITY, dividend/divider,  0.000000000001);
    }

    @Test
    public void division(){
        dividend = 11;
        divider = 2;
        assertEquals(5.5, dividend/divider, 0.000000000001);
    }

}