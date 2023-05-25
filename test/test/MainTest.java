package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import DPLL.DPLL;
import org.junit.jupiter.api.Test;
import test.utils.TestUtils;

class MainTest {

    private final boolean print = true;

    private final boolean huge = false;

    DPLL dpll = new DPLL();



    @Test
    void testadd2() {
        assertFalse(TestUtils.test(dpll, "add2.in", print));
    }

    @Test
    void testadd2R() {
        assertFalse(TestUtils.test(dpll, "add2R.in", print));
    }

    @Test
    void testadd4() {
        assertFalse(TestUtils.test(dpll, "add4.in", print));
    }

    @Test
    void testadd4R() {
        assertFalse(TestUtils.test(dpll, "add4R.in", print));
    }

    @Test
    void testadd8() {
        assertFalse(TestUtils.test(dpll, "add8.in", print));
    }

    @Test
    void testadd8R() {
        assertFalse(TestUtils.test(dpll, "add8R.in", print));
    }

    @Test
    void testadd16() {
        if (huge) assertFalse(TestUtils.test(dpll, "add16.in", print));
    }

    @Test
    void testadd16R() {
        if (huge) assertFalse(TestUtils.test(dpll, "add16R.in", print));
    }

    @Test
    void testadd32() {
        if (huge) assertFalse(TestUtils.test(dpll, "add32.in", print));
    }

    @Test
    void testadd32R() {
        if (huge) assertFalse(TestUtils.test(dpll, "add32R.in", print));
    }


    @Test
    void testadd64() {
        if (huge) assertFalse(TestUtils.test(dpll, "add64.in", print));
    }

    @Test
    void testadd64R() {
        if (huge) assertFalse(TestUtils.test(dpll, "add64R.in", print));
    }

    @Test
    void testassume2() {
        assertTrue(TestUtils.test(dpll, "assume2.in", print));
    }

    @Test
    void testassume3() {
        assertTrue(TestUtils.test(dpll, "assume3.in", print));
    }

    @Test
    void testassume7() {
        assertTrue(TestUtils.test(dpll, "assume7.in", print));
    }

    @Test
    void testbug1() {
        assertFalse(TestUtils.test(dpll, "bug1.in", print));
    }

    @Test
    void testclash() {
        assertFalse(TestUtils.test(dpll, "clash.in", print));
    }

    @Test
    void testdominate1() {
        assertTrue(TestUtils.test(dpll, "dominate1.in", print));
    }

    @Test
    void testempty() {
        assertTrue(TestUtils.test(dpll, "empty.in", print));
    }

    @Test
    void testeq1() {
        assertTrue(TestUtils.test(dpll, "eq1.in", print));
    }

    @Test
    void testeq2() {
        assertTrue(TestUtils.test(dpll, "eq2.in", print));
    }

    @Test
    void testf2r() {
        assertFalse(TestUtils.test(dpll, "f2r.in", print));
    }

    @Test
    void testf3r() {
        assertFalse(TestUtils.test(dpll, "f3r.in", print));
    }

    @Test
    void testfull2() {
        assertFalse(TestUtils.test(dpll, "full2.in", print));
    }

    @Test
    void testfull2no00() {
        assertTrue(TestUtils.test(dpll, "full2no00.in", print));
    }

    @Test
    void testfull2no01() {
        assertTrue(TestUtils.test(dpll, "full2no01.in", print));
    }

    @Test
    void testfull2no10() {
        assertTrue(TestUtils.test(dpll, "full2no10.in", print));
    }

    @Test
    void testfull2no11() {
        assertTrue(TestUtils.test(dpll, "full2no11.in", print));
    }

    @Test
    void testfull2R() {
        assertFalse(TestUtils.test(dpll, "full2R.in", print));
    }

    @Test
    void testfull3() {
        assertFalse(TestUtils.test(dpll, "full3.in", print));
    }

    @Test
    void testfull3R() {
        assertFalse(TestUtils.test(dpll, "full3R.in", print));
    }

    @Test
    void testfull4() {
        assertFalse(TestUtils.test(dpll, "full4.in", print));
    }

    @Test
    void testmcs1() {
        assertFalse(TestUtils.test(dpll, "mcs1.in", print));
    }

    @Test
    void testmcs2() {
        assertFalse(TestUtils.test(dpll, "mcs2.in", print));
    }

    @Test
    void testmcs3() {
        assertFalse(TestUtils.test(dpll, "mcs3.in", print));
    }

    @Test
    void testmus0() {
        assertFalse(TestUtils.test(dpll, "mus0.in", print));
    }

    @Test
    void testmus1() {
        assertFalse(TestUtils.test(dpll, "mus1.in", print));
    }

    @Test
    void testmus2() {
        assertFalse(TestUtils.test(dpll, "mus2.in", print));
    }

    @Test
    void testmus3() {
        assertFalse(TestUtils.test(dpll, "mus3.in", print));
    }

    @Test
    void testor() {
        assertTrue(TestUtils.test(dpll, "or.in", print));
    }

    @Test
    void testph2() {
        assertFalse(TestUtils.test(dpll, "ph2.in", print));
    }

    @Test
    void testph3() {
        assertFalse(TestUtils.test(dpll, "ph3.in", print));
    }

    @Test
    void testph4() {
        assertFalse(TestUtils.test(dpll, "ph4.in", print));
    }

    @Test
    void testph5() {
        assertFalse(TestUtils.test(dpll, "ph5.in", print));
    }

    @Test
    void testph6() {
        assertFalse(TestUtils.test(dpll, "ph6.in", print));
    }

    @Test
    void testprime121() {
        assertTrue(TestUtils.test(dpll, "prime121.in", print));
    }

    @Test
    void testprime1369() {
        assertTrue(TestUtils.test(dpll, "prime1369.in", print));
    }

    @Test
    void testprime1681() {
        assertTrue(TestUtils.test(dpll, "prime1681.in", print));
    }

    @Test
    void testprime169() {
        assertTrue(TestUtils.test(dpll, "prime169.in", print));
    }

    @Test
    void testprime1849() {
        assertTrue(TestUtils.test(dpll, "prime1849.in", print));
    }

    @Test
    void testprime2209() {
        assertTrue(TestUtils.test(dpll, "prime2209.in", print));
    }

    @Test
    void testprime25() {
        assertTrue(TestUtils.test(dpll, "prime25.in", print));
    }

    @Test
    void testprime289() {
        assertTrue(TestUtils.test(dpll, "prime289.in", print));
    }

    @Test
    void testprime361() {
        assertTrue(TestUtils.test(dpll, "prime361.in", print));
    }

    @Test
    void testprime4() {
        assertTrue(TestUtils.test(dpll, "prime4.in", print));
    }

    @Test
    void testprime49() {
        assertTrue(TestUtils.test(dpll, "prime49.in", print));
    }

    @Test
    void testprime529() {
        assertTrue(TestUtils.test(dpll, "prime529.in", print));
    }

    @Test
    void testprime65537() {
        assertFalse(TestUtils.test(dpll, "prime65537.in", print));
    }

    @Test
    void testprime841() {
        assertTrue(TestUtils.test(dpll, "prime841.in", print));
    }

    @Test
    void testprime9() {
        assertTrue(TestUtils.test(dpll, "prime9.in", print));
    }

    @Test
    void testprime961() {
        assertTrue(TestUtils.test(dpll, "prime961.in", print));
    }

    @Test
    void testsat0() {
        assertFalse(TestUtils.test(dpll, "sat0.in", print));
    }

    @Test
    void testsat1() {
        assertTrue(TestUtils.test(dpll, "sat1.in", print));
    }

    @Test
    void testsat10() {
        assertTrue(TestUtils.test(dpll, "sat10.in", print));
    }

    @Test
    void testsat11() {
        assertTrue(TestUtils.test(dpll, "sat11.in", print));
    }

    @Test
    void testsat12() {
        assertTrue(TestUtils.test(dpll, "sat12.in", print));
    }

    @Test
    void testsat13() {
        assertTrue(TestUtils.test(dpll, "sat13.in", print));
    }

    @Test
    void testsat2() {
        assertTrue(TestUtils.test(dpll, "sat2.in", print));
    }

    @Test
    void testsat3() {
        assertTrue(TestUtils.test(dpll, "sat3.in", print));
    }

    @Test
    void testsat4() {
        assertTrue(TestUtils.test(dpll, "sat4.in", print));
    }

    @Test
    void testsat5() {
        assertFalse(TestUtils.test(dpll, "sat5.in", print));
    }

    @Test
    void testsat6() {
        assertTrue(TestUtils.test(dpll, "sat6.in", print));
    }

    @Test
    void testsat7() {
        assertTrue(TestUtils.test(dpll, "sat7.in", print));
    }

    @Test
    void testsat8() {
        assertTrue(TestUtils.test(dpll, "sat8.in", print));
    }

    @Test
    void testsat9() {
        assertTrue(TestUtils.test(dpll, "sat9.in", print));
    }

    @Test
    void testscc1() {
        assertTrue(TestUtils.test(dpll, "scc1.in", print));
    }

    @Test
    void testscc2() {
        assertFalse(TestUtils.test(dpll, "scc2.in", print));
    }

    @Test
    void testsub0() {
        assertTrue(TestUtils.test(dpll, "sub0.in", print));
    }

    @Test
    void testunit0() {
        assertTrue(TestUtils.test(dpll, "unit0.in", print));
    }

    @Test
    void testunit1() {
        assertTrue(TestUtils.test(dpll, "unit1.in", print));
    }

    @Test
    void testunit2() {
        assertTrue(TestUtils.test(dpll, "unit2.in", print));
    }

    @Test
    void testunit3() {
        assertTrue(TestUtils.test(dpll, "unit3.in", print));
    }

    @Test
    void testunit4() {
        assertFalse(TestUtils.test(dpll, "unit4.in", print));
    }

    @Test
    void testunit5() {
        assertFalse(TestUtils.test(dpll, "unit5.in", print));
    }

    @Test
    void testwatch0() {
        assertTrue(TestUtils.test(dpll, "watch0.in", print));
    }

    @Test
    void testwatch1() {
        assertTrue(TestUtils.test(dpll, "watch1.in", print));
    }

}