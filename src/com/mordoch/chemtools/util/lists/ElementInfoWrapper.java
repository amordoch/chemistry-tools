package com.mordoch.chemtools.util.lists;

import java.util.HashMap;
import java.util.Map;


public abstract class ElementInfoWrapper<K, V> {
  
  public ElementInfoWrapper(String dataType, String numOfElements, String keyType, String valueType) {
    setMetadataValue(dataType, 0);
    setMetadataValue(numOfElements, 1);
    setMetadataValue(keyType, 2);
    setMetadataValue(valueType, 3);
  }
  
  public String[] metadata = {
      "data type",
      "number of elements",
      "key type",
      "value type"
  };
  
  public Map<K, V> data = new HashMap<K, V>(120, 1.0f);

  
  public String[] getMetadata() {
    return metadata;
  }
  
  public void setMetadataValue(String value, int index) {
    metadata[index] = value;
  }
}
