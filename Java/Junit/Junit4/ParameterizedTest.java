package com.company;

import org.junit.jupiter.api.*;

@RunWith(Parameterized.class)
public class ParameterizedTest {
   Utility utility;

   @Before
   void setup() {
       utility = new Utility();
   }

   private String input;
   private String output;


   @Parameterized.Parameters
   public static Collection<Object[]> unitTestWithParameterized() {
       return Arrays.asList(new Object[][] {
               {10, 20}, // <- this acts like a constructor (34 is input, 84 is output)
       });
   }

   @Test
   public void add10AndReturnTheResult() {
       assertEquals(output, utility.add10AndReturnTheResult(input));
   }
}
