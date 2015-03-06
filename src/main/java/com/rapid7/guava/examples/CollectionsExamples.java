/***************************************************************************
 * COPYRIGHT (C) 2015, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.guava.examples;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import java.util.List;
import java.util.Map;

/**
 * TODO: Describe Me!
 */
public class CollectionsExamples
{
   private CollectionsExamples(){}

   public void multiSetExample()
   {
      String[] words = {"This", "is", "a", "bunch", "of", "a", "words", "This", "bunch", "bunch", "bunch"};
      
      Map<String, Integer> counts = Maps.newHashMap();
      for (String word : words) {
         Integer count = counts.get(word);
         if (count == null) {
            counts.put(word, 1);
         } else {
            counts.put(word, count + 1);
         }
      }      
      System.out.println(counts);
      
      ImmutableMap<String, Integer> immutableCountMap = ImmutableMap.copyOf(counts);
      
      Multiset<String> multiset = HashMultiset.create();
      
      for(String word : words)
      {
         multiset.add(word);         
      }
      
      System.out.println(multiset);
      
      List<String> as = Lists.newArrayList("a", "a");
      
      ImmutableMultiset<String> immutableMultiset = ImmutableMultiset.<String>builder()
         .addCopies("of", 1)
         .addCopies("is", 1)
         .add("words")
         .addAll(as)
         .add("bunch", "bunch", "This")
         .add("This", "bunch", "bunch")
         .build();
      
      System.out.println(immutableMultiset);
   }
   
   public static void main(String[] args)
   {
      CollectionsExamples collectionsExamples = new CollectionsExamples();
      collectionsExamples.multiSetExample();
   }
}
