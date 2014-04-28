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

public final class TypeList extends ElementInfoWrapper<String, String> {

  private TypeList() {
    super("type", "118", "String", "String");
    addAll();
  }
@Override
  protected void addAll() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    if (stackTraceElements[2].getMethodName() != "<init>") {
    } else {
      // These are used for determining bond types, so some entries will look odd
      data.put("H", "Hydrogen");
      data.put("He", "Nonmetal");
      data.put("Li", "Metal");
      data.put("Be", "Metal");
      data.put("B", "Metalloid");
      data.put("C", "Nonmetal");
      data.put("N", "Nonmetal");
      data.put("O", "Nonmetal");
      data.put("F", "Nonmetal");
      data.put("Ne", "Nonmetal");
      data.put("Na", "Metal");
      data.put("Mg", "Metal");
      data.put("Al", "Metal");
      data.put("Si", "Metalloid");
      data.put("P", "Nonemtal");
      data.put("S", "Nonemtal");
      data.put("Cl", "Nonmetal");
      data.put("Ar", "Nonmetal");
      data.put("K", "Metal");
      data.put("Ca", "Metal");
      data.put("Sc", "Metal");
      data.put("Ti", "Metal");
      data.put("V", "Metal");
      data.put("Cr", "Metal");
      data.put("Mn", "Metal");
      data.put("Fe", "Metal");
      data.put("Co", "Metal");
      data.put("Ni", "Metal");
      data.put("Cu", "Metal");
      data.put("Zn", "Metal");
      data.put("Ga", "Metal");
      data.put("Ge", "Metalloid");
      data.put("As", "Metalloid");
      data.put("Se", "Nonmetal");
      data.put("Br", "Nonmetal");
      data.put("Kr", "Nonmetal");
      data.put("Rb", "Metal");
      data.put("Sr", "Metal");
      data.put("Y", "Metal");
      data.put("Zr", "Metal");
      data.put("Nb", "Metal");
      data.put("Mo", "Metal");
      data.put("Tc", "Metal");
      data.put("Ru", "Metal");
      data.put("Rh", "Metal");
      data.put("Pd", "Metal");
      data.put("Ag", "Metal");
      data.put("Cd", "Metal");
      data.put("In", "Metal");
      data.put("Sn", "Metal");
      data.put("Sb", "Metalloid");
      data.put("Te", "Metalloid");
      data.put("I", "Nonmetal");
      data.put("Xe", "Nonmetal");
      data.put("Cs", "Metal");
      data.put("Ba", "Metal");
      data.put("Hf", "Metal");
      data.put("Ta", "Metal");
      data.put("W", "Metal");
      data.put("Re", "Metal");
      data.put("Os", "Metal");
      data.put("Ir", "Metal");
      data.put("Pt", "Metal");
      // I LOVE GOOOOOOOOOOOOLD
      data.put("Au", "Metal");
      data.put("Hg", "Metal");
      data.put("Tl", "Metal");
      data.put("Pb", "Metal");
      data.put("Bi", "Metal");
      data.put("Po", "Metalloid");
      data.put("At", "Nonmetal");
      data.put("Rn", "Nonmetal");
      data.put("Fr", "Metal");
      data.put("Ra", "Metal");
      data.put("Rf", "Metal");
      data.put("Db", "Metal");
      data.put("Sg", "Metal");
      data.put("Bh", "Metal");
      data.put("Hs", "Metal");
      data.put("Mt", "Metal");
      data.put("Ds", "Metal");
      data.put("Rg", "Metal");
      data.put("Cn", "Metal");
      data.put("Uut", "Metal");
      data.put("Fl", "Metal");
      data.put("Uup", "Metal");
      data.put("Lv", "Metal");
      data.put("Uus", "Metalloid");
      data.put("Uuo", "Nonmetal");
      data.put("La", "Metal");
      data.put("Ce", "Metal");
      data.put("Pr", "Metal");
      data.put("Nd", "Metal");
      data.put("Pm", "Metal");
      data.put("Sm", "Metal");
      data.put("Eu", "Metal");
      data.put("Gd", "Metal");
      data.put("Tb", "Metal");
      data.put("Dy", "Metal");
      data.put("Ho", "Metal");
      data.put("Er", "Metal");
      data.put("Tm", "Metal");
      data.put("Yb", "Metal");
      data.put("Lu", "Metal");
      data.put("Ac", "Metal");
      data.put("Th", "Metal");
      data.put("Pa", "Metal");
      data.put("U", "Metal");
      data.put("Np", "Metal");
      data.put("Pu", "Metal");
      data.put("Am", "Metal");
      data.put("Cm", "Metal");
      data.put("Bk", "Metal");
      data.put("Cf", "Metal");
      data.put("Es", "Metal");
      data.put("Fm", "Metal");
      data.put("Md", "Metal");
      data.put("No", "Metal");
      data.put("Lr", "Metal");
    }
  }

  static TypeList newInstance() {
    return new TypeList();
  } 
}
