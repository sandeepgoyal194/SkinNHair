package com.satyahair.skinnhair.model.bean;

import java.io.Serializable;

/**
 * Created by Sandeep on 19/12/2016.
 */

abstract public class BaseBean implements Serializable {
      int counter = 0;

      public int getCounter() {
            return counter;
      }

      public void setCounter(int counter) {
            this.counter = counter;
      }
}
