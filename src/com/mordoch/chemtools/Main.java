/*
 * Copyright Ariel Mordoch 2014 This file is part of Chemistry Tools.
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

package com.mordoch.chemtools;

import com.mordoch.chemtools.interaction.Menu;

/**
 * The main class.
 * 
 * @author Ariel Mordoch
 * @version FINAL
 * @since 0.1
 */

public class Main {

  public static final String PROGRAM_VERSION = "0.6.5-alpha";

  /**
   * The main method prints out copyright information then instantiates Menu and calls mainMenu();
   * 
   * @param args args
   * @throws InterruptedException if menu thread was interrupted while showing a warning menu
   * @since 0.1
   */

  public static void main(String[] args) throws InterruptedException {
    programInfo();
    new Menu() {
      {
        mainMenu();
      }
    };
  }

  private static void programInfo() {
    System.out.println("Chemistry Tools " + PROGRAM_VERSION);
    System.out.println("Copyright (c) 2014 Ariel Mordoch");
    System.out.println("Licensed under the LGPL");
    System.out.println("Source code available at www.github.com/amordoch/chemistry-tools");
  }
}
