package CalculatorTest;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.zotov.utils.calculator.Calculator;

public class CalculatorTest {

        Calculator calculator = new Calculator();

        @Test
        public void testSummDoubleNumberInt() {
                Assert.assertEquals(calculator.sumDoubleNumber(3,2),5,0.0001);
        }

        @Test
        public void testSummDoubleNumberDouble() {
                Assert.assertEquals(calculator.sumDoubleNumber(3.125,2.250),5.375,0.0001);
        }

        @Test
        public void testMinusDoubleNumberInt0() {
                Assert.assertEquals(calculator.minusDoubleNumber(15,40),-25,0.0001);
        }

        @Test
        public void testMinusDoubleNumberInt1() {
                Assert.assertEquals(calculator.minusDoubleNumber(15,-40),55,0.0001);
        }

        @Test
        public void testMinusDoubleNumberDouble() {
                Assert.assertEquals(calculator.minusDoubleNumber(6.658,9.633),-2.975,0.0001);
        }

        @Test
        public void testMultiDoubleNumberDouble0() {
                Assert.assertEquals(calculator.multiplexDoubleNumber(6,0.633),3.798,0.0001);
        }

        @Test
        public void testMultiDoubleNumberDouble1() {
                Assert.assertEquals(calculator.multiplexDoubleNumber(6,0),0,0.0001);
        }

        @Test
        public void testDivisionDoubleNumberDouble0() {
                Assert.assertEquals(calculator.divisionDoubleNumber(10,2),5,0.0001);
        }

        @Test
        public void testDivisionDoubleNumberDouble1() {
                Assert.assertEquals(calculator.divisionDoubleNumber(10.366,2),5.183,0.0001);
        }

        @Test(expected = ArithmeticException.class)
        public void testDivisionDoubleNumberDouble2() {
                calculator.divisionDoubleNumber(15,0);
        }
}
