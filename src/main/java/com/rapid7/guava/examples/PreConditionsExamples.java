/***************************************************************************
 * COPYRIGHT (C) 2015, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.guava.examples;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * TODO: Describe Me!
 */
public class PreConditionsExamples
{

   private PreConditionsExamples(){}

   public void checkArgumentExamples()
   {
      try
      {
         //will fail with default message
         checkArgument(false);
      }
      catch (IllegalArgumentException iae)
      {
         iae.printStackTrace();
      }

      try
      {
         checkArgument(false, "A new message!");
      }
      catch (IllegalArgumentException iae)
      {
         iae.printStackTrace();
      }

      try
      {
         checkArgument(false, "Check %s out what %s did!", "out", "I");
      }
      catch (IllegalArgumentException iae)
      {
         iae.printStackTrace();
      }
   }

   public static void main(String[] args)
   {
      PreConditionsExamples preConditionsExamples = new PreConditionsExamples();
      preConditionsExamples.checkArgumentExamples();
   }
}
