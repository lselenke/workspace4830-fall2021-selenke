package q2.csvfilesource;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import p1.computation.Computation;

public class TestComputation_CsvFileSource {

   // TODO: Write your answer to complete this test case
   @ParameterizedTest
   @CsvFileSource(resources = "computation_dataset.csv")
   public void testGetDiscount(int input1, int input2, int expected) throws Exception {
       Computation com = new Computation();
        input1 = 100;
        input2 = 2;
        expected = 30;
        int result = com.getDiscount(input1, input2);
        Assert.assertEquals(expected, result);

   }
}