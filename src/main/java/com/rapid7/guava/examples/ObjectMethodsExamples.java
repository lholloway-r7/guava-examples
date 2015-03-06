/***************************************************************************
 * COPYRIGHT (C) 2015, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.guava.examples;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

/**
 * TODO: Describe Me!
 */
public class ObjectMethodsExamples implements Comparable<ObjectMethodsExamples>
{

   private final boolean key1;
   private final int key2;
   private final String somethingElse;

   private ObjectMethodsExamples(boolean key1, int key2, String somethingElse)
   {
      this.key1 = key1;
      this.key2 = key2;
      this.somethingElse = somethingElse;
   }

   public void toStringExample()
   {
      System.out.println(this.toString());
   }

   public void compareExample()
   {
      System.out.println("Should be equal    : " + this.compareTo(this));
      System.out.println("Should be different: " + this.compareTo(new ObjectMethodsExamples(key1, 22, somethingElse)));
   }

   @Override
   public int compareTo(ObjectMethodsExamples that)
   {
      return ComparisonChain.start()
         .compare(this.key1, that.key1)
         .compare(this.key2, that.key2)
         .compare(this.somethingElse, that.somethingElse)
         .result();
   }

   @Override
   public String toString()
   {
      return MoreObjects.toStringHelper(this)
         .add("key1", key1)
         .add("key2", key2)
         .add("somethingElse", somethingElse)
         .toString();
   }

   public static void main(String[] args)
   {
      ObjectMethodsExamples objectMethodsExamples = new ObjectMethodsExamples(true, 15, "Flibbertigibbet");
      objectMethodsExamples.toStringExample();
      objectMethodsExamples.compareExample();
   }
}
