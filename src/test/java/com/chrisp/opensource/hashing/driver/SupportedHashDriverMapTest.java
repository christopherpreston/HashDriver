/*
MIT License

Copyright (c) 2017 Christopher Preston

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


/**
 * Author: chrisp December 2009
 */

package com.chrisp.opensource.hashing.driver;

import java.util.Comparator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chrisp.opensource.hashing.driver.HashDriverIf;
import com.chrisp.opensource.hashing.driver.SupportedHashDriverMap;
import com.chrisp.opensource.hashing.driver.SupportedHashDriverMapTest;

public class SupportedHashDriverMapTest {


  private static final int MAX_STRING_SIZE = 40;
  final int TEST_VALUE_COUNT = 3000000;
  String[] values;
  final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789`~!@#$%^&*()_+-=[]\\:\";'{}|<>?,./";
  final int charslen = chars.length();


    public SupportedHashDriverMapTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }



  @Before
  public void setUp() throws Exception {
    Random random = new Random();
    int offset;
    values = new String[TEST_VALUE_COUNT];
    StringBuilder sbuf = new StringBuilder(SupportedHashDriverMapTest.MAX_STRING_SIZE);
    String newString;
    Properties props = new Properties();

    for (; props.size() < TEST_VALUE_COUNT;) {

      int stringSize = (int) (random.nextDouble() * SupportedHashDriverMapTest.MAX_STRING_SIZE);

      for (int i = 0; i < stringSize; i++) {
        offset = (int) (random.nextDouble() * (charslen));
        sbuf.append(chars.charAt(offset));
      }
      newString = sbuf.toString();
      sbuf.setLength(0);
      if (!props.containsKey(newString)) {
        props.put(newString, newString);
      }
    }

    int i = 0;
    for (Object key : props.keySet()) {
      values[i] = key.toString();
      i++;
    }

  }

  @After
  public void tearDown() throws Exception {
    values = null;
  }

  @Test
  public void testHashes() throws Exception {
    SupportedHashDriverMap hashMap = new SupportedHashDriverMap();
    Set<String> keys = hashMap.keySet();
    for (String key : keys) {
      byte[][] hashByteArray = new byte[TEST_VALUE_COUNT][];
      System.out.println("Testing hash type: " + key);
      HashDriverIf driver = hashMap.get(key);

      long startTime, endTime, diff;
      startTime = System.currentTimeMillis();
      for (int i = 0; i < TEST_VALUE_COUNT; i++) {
        hashByteArray[i] = driver.hash(values[i]);
      }
      endTime = System.currentTimeMillis();
      diff = endTime - startTime;
      System.out.println(key + " hashes/sec = " + (1000L * TEST_VALUE_COUNT) / diff);
      SortedMap<byte[], byte[]> collisionDetectSet = new TreeMap<byte[], byte[]>(
              new ByteArrayComparator<byte[]>());
      int collisionCount = 0;
      for (int i = 0; i < TEST_VALUE_COUNT; i++) {
        if (collisionDetectSet.get(hashByteArray[i]) != null) {
          collisionCount++;
        } else {
          collisionDetectSet.put(hashByteArray[i], hashByteArray[i]);
        }
      }
      System.out.println(key + "collision ratio = " + (100 * collisionCount) / TEST_VALUE_COUNT + "% - collision count = " + collisionCount + " map size = " + collisionDetectSet.size());
    }

  }

  class ByteArrayComparator<T> implements Comparator<T> {

    @Override
    public int compare(Object pO1, Object pO2) {
      int l1 = ((byte[]) pO1).length;
      int l2 = ((byte[]) pO2).length;
      int value;

      if (l1 == 0) {
        if (l2 > 0) {
          return -1;
        }
        return 0;
      }

      if (l2 == 0) {
        if (l1 > 0) {
          return 1;
        }
        return 0;
      }


      if (l1 < l2) {
        for (int i = 0; i < l1; i++) {
          value = (((byte[]) pO1)[i] - ((byte[]) pO2)[i]);
          if (value != 0) {
            return value;
          }
        }
        return -1;
      } else if (l1 > l2) {
        for (int i = 0; i < l2; i++) {
          value = (((byte[]) pO1)[i] - ((byte[]) pO2)[i]);
          if (value != 0) {
            return value;
          }
          return 1;
        }
      } else {
        for (int i = 0; i < l2; i++) {
          value = (((byte[]) pO1)[i] - ((byte[]) pO2)[i]);
          if (value != 0) {
            return value;
          }
        }
        return 0;
      }
      return 0;
    }
  }


}