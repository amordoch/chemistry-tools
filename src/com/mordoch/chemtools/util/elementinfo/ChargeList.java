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

final class ChargeList extends ElementInfoWrapper<String, Integer> {

  private ChargeList() {
    super("charge", "<118", "String", "Integer");
    addAll();
  }
@Override
  protected void addAll() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    if (stackTraceElements[2].getMethodName() != "<init>") {
    } else {
      int unknown = 999;
      data.put("H", 1);
      data.put("Li", 1);
      data.put("Na", 1);
      data.put("K", 1);
      data.put("Rb", 1);
      data.put("Cs", 1);
      data.put("Fr", 1);
      data.put("Be", 2);
      data.put("Mg", 2);
      data.put("Ca", 2);
      data.put("Sr", 2);
      data.put("Ba", 2);
      data.put("Ra", 2);
      data.put("Sc", unknown);
      data.put("Y", unknown);
      data.put("Ti", unknown);
      data.put("Zr", unknown);
      data.put("Hf", unknown);
      data.put("Rf", unknown);
      data.put("V", unknown);
      data.put("Nb", unknown);
      data.put("Ta", unknown);
      data.put("Db", unknown);
      data.put("Cr", unknown);
      data.put("Mo", unknown);
      data.put("W", unknown);
      data.put("Sg", unknown);
      data.put("Mn", unknown);
      data.put("Tc", unknown);
      data.put("Re", unknown);
      data.put("Bh", unknown);
      data.put("Fe", unknown);
      data.put("Ru", unknown);
      data.put("Os", unknown);
      data.put("Hs", unknown);
      data.put("Co", unknown);
      data.put("Rh", unknown);
      data.put("Ir", unknown);
      data.put("Mt", unknown);
      data.put("Ds", unknown);
      data.put("Cu", unknown);
      data.put("Ag", unknown);
      data.put("Au", unknown);
      data.put("Rg", unknown);
      data.put("Zn", unknown);
      data.put("Cd", unknown);
      data.put("Hg", unknown);
      data.put("Cn", unknown);
      data.put("B", unknown);
      data.put("Al", unknown);
      data.put("Ga", unknown);
      data.put("In", unknown);
      data.put("Tl", unknown);
      data.put("Uut", unknown);
      data.put("C", unknown);
      data.put("Si", unknown);
      data.put("Ge", unknown);
      data.put("Sn", unknown);
      data.put("Pb", unknown);
      data.put("Fl", unknown);
      data.put("N", -3);
      data.put("P", -3);
      data.put("As", -3);
      data.put("Sb", -3);
      data.put("Bi", -3);
      data.put("Uup", unknown);
      data.put("O", -2);
      data.put("S", -2);
      data.put("Se", -2);
      data.put("Te", -2);
      data.put("Po", -2);
      data.put("Lv", -2);
      data.put("F", -1);
      data.put("Cl", -1);
      data.put("Br", -1);
      data.put("I", -1);
      data.put("At", -1);
      data.put("Uus", unknown);
      data.put("He", 0);
      data.put("Ne", 0);
      data.put("Ar", 0);
      data.put("Kr", 0);
      data.put("Xe", 0);
      data.put("Rn", 0);
      data.put("Uuo", unknown);
      data.put("La", unknown);
      data.put("Ac", unknown);
      data.put("Ce", unknown);
      data.put("Th", unknown);
      data.put("Pr", unknown);
      data.put("Pa", unknown);
      data.put("U", unknown);
      data.put("Pm", unknown);
      data.put("Np", unknown);
      data.put("Sm", unknown);
      data.put("Pu", unknown);
      data.put("Eu", unknown);
      data.put("Am", unknown);
      data.put("Gd", unknown);
      data.put("Cm", unknown);
      data.put("Tb", unknown);
      data.put("Bk", unknown);
      data.put("Cf", unknown);
      data.put("Ho", unknown);
      data.put("Es", unknown);
      data.put("Er", unknown);
      data.put("Fm", unknown);
      data.put("Tm", unknown);
      data.put("Md", unknown);
      data.put("Yb", unknown);
      data.put("No", unknown);
      data.put("Lu", unknown);
      data.put("Lr", unknown);
    }
  }
  static ChargeList newInstance() {
    return new ChargeList();
  } 
}
