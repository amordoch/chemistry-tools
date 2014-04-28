/*
 * Copyright Ariel Mordoch 2014 
 * This file is part of Chemistry Tools.
 * 
 * Chemistry Tools is free software: you can redistribute it and/or modify it under the terms of the
 * Lesser GNU General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 * 
 * Chemistry Tools is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Lesser GNU General Public License for more details.
 * 
 * You should have received a copy of the Lesser GNU General Public License along with Chemistry
 * Tools. If not, see <http://www.gnu.org/licenses/>.
 */


package com.mordoch.chemtools.util.elementinfo;

import java.util.HashMap;
import java.util.Map;

/**
 * This class acts as a template for any class that hosts element information; it is most useful for
 * the metadata. It is essentially a wrapper for a Map.
 * 
 * @author Ariel Mordoch
 *
 * @param <K> Key type
 * @param <V> Value type
 * @version 1.0
 * @since 0.8-alpha
 */

public abstract class ElementInfoWrapper<K, V> {

  protected ElementInfoWrapper(String dataType, String numOfElements, String keyType, String valueType) {
    setMetadataValue(dataType, 0);
    setMetadataValue(numOfElements, 1);
    setMetadataValue(keyType, 2);
    setMetadataValue(valueType, 3);
  }

  public String[] metadata = {"data type", "number of elements", "key type", "value type"};

  protected Map<K, V> data = new HashMap<K, V>(120, 1.0f);

  /**
   * This method should populate the Map with relevant data if and only if the calling method was a
   * constructor. This can be done by retrieving the running thread's stack trace and getting the
   * name of the second method on the stack. The method {@link StackTraceElement#getMethodName()} 
   * should return "&lt;init&gt;" if the calling "method" was a constructor.
   */

  protected abstract void addAll();
  
  public V get(K key) {
    return data.get(key);
  }
  
  /**
   * Unwraps the Map.
   * @return the Map containing the element data
   */
  
  public Map<K, V> unwrap() {
    return data;
  }
  
  public String[] getMetadata() {
    return metadata;
  }

  public String getMetadataAtIndex(int index) {
    return metadata[index];
  }

  public void setMetadataValue(String value, int index) {
    metadata[index] = value;
  } 
}