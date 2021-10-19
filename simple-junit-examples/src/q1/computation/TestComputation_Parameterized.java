package q1.computation;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import p1.computation.Computation;

@RunWith(Parameterized.class)
public class TestComputation_Parameterized {
   int mInput1, mInput2, mExpected;
   //Computation com = new Computation();

   @Parameters
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] { //
          // TODO: Write Your Answer
          { 0, 0, 0 }, // 1st input, 2nd input, expected value
          { 1, 1, 2 }, //
          { 2, 1, 3 } });
   }

   public TestComputation_Parameterized(int input1, int input2, int expected) {
       // TODO: Write Your Answer
       this.mInput1 = input1;
       this.mInput2 = input2;
       this.mExpected = expected;
   }

   @Test
   public void testGetDiscount() throws Exception {
       // TODO: Write Your Answer
       Computation com = new Computation();
        mInput1 = 100;
        mInput2 = 2;
        mExpected = 30;
        int result = com.getDiscount(mInput1, mInput2);
        Assert.assertEquals(mExpected, result);
      // Assert.assertEquals(mExpected, TODO: Write Your Answer);
   }
}