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

public final class ElementInfo {
  // Prevent this class from being instantiated
  private ElementInfo() {}

  public static MassList mass = MassList.newInstance();
  public static TypeList type = TypeList.newInstance();
  public static FamilyList family = FamilyList.newInstance();
  public static ChargeList charge = ChargeList.newInstance();
  public static NameList name = NameList.newInstance();
  public static AtomicNumberList atomicNumber = AtomicNumberList.newInstance();

}