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

public final class AtomicNumberList extends ElementInfoWrapper<String, Integer> {

  private AtomicNumberList() {
    super("atomic number", "118", "String", "Integer");
    addAll();
  }
@Override
  protected void addAll() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    if (stackTraceElements[2].getMethodName() != "<init>") {
    } else {
      data.put("H", 1);
      data.put("He", 2);
      data.put("Li", 3);
      data.put("Be", 4);
      data.put("B", 5);
      data.put("C", 6);
      data.put("N", 7);
      data.put("O", 8);
      data.put("F", 9);
      data.put("Ne", 10);
      data.put("Na", 11);
      data.put("Mg", 12);
      data.put("Al", 13);
      data.put("Si", 14);
      data.put("P", 15);
      data.put("S", 16);
      data.put("Cl", 17);
      data.put("Ar", 18);
      data.put("K", 19);
      data.put("Ca", 20);
      data.put("Sc", 21);
      data.put("Ti", 22);
      data.put("V", 23);
      data.put("Cr", 24);
      data.put("Mn", 25);
      data.put("Fe", 26);
      data.put("Co", 27);
      data.put("Ni", 28);
      data.put("Cu", 29);
      data.put("Zn", 30);
      data.put("Ga", 31);
      data.put("Ge", 32);
      data.put("As", 33);
      data.put("Se", 34);
      data.put("Br", 35);
      data.put("Kr", 36);
      data.put("Rb", 37);
      data.put("Sr", 38);
      data.put("Y", 39);
      data.put("Zr", 40);
      data.put("Nb", 41);
      data.put("Mo", 42);
      data.put("Tc", 43);
      data.put("Ru", 44);
      data.put("Rh", 45);
      data.put("Pd", 46);
      data.put("Ag", 47);
      data.put("Cd", 48);
      data.put("In", 49);
      data.put("Sn", 50);
      data.put("Sb", 51);
      data.put("Te", 52);
      data.put("I", 53);
      data.put("Xe", 54);
      data.put("Cs", 55);
      data.put("Ba", 56);
      data.put("Hf", 72);
      data.put("Ta", 73);
      data.put("W", 74);
      data.put("Re", 75);
      data.put("Os", 76);
      data.put("Ir", 77);
      data.put("Pt", 78);
      // I LOVE GOOOOOOOOOOOOLD
      data.put("Au", 79);
      data.put("Hg", 80);
      data.put("Tl", 81);
      data.put("Pb", 82);
      data.put("Bi", 83);
      data.put("Po", 84);
      data.put("At", 85);
      data.put("Rn", 86);
      data.put("Fr", 87);
      data.put("Ra", 88);
      data.put("Rf", 104);
      data.put("Db", 105);
      data.put("Sg", 106);
      data.put("Bh", 107);
      data.put("Hs", 108);
      data.put("Mt", 109);
      data.put("Ds", 110);
      data.put("Rg", 111);
      data.put("Cn", 112);
      data.put("Uut", 113);
      data.put("Fl", 114);
      data.put("Uup", 115);
      data.put("Lv", 116);
      data.put("Uus", 117);
      data.put("Uuo", 118);
      data.put("La", 57);
      data.put("Ce", 58);
      data.put("Pr", 59);
      data.put("Nd", 60);
      data.put("Pm", 61);
      data.put("Sm", 62);
      data.put("Eu", 63);
      data.put("Gd", 64);
      data.put("Tb", 65);
      data.put("Dy", 66);
      data.put("Ho", 67);
      data.put("Er", 68);
      data.put("Tm", 69);
      data.put("Yb", 70);
      data.put("Lu", 71);
      data.put("Ac", 89);
      data.put("Th", 90);
      data.put("Pa", 91);
      data.put("U", 92);
      data.put("Np", 93);
      data.put("Pu", 94);
      data.put("Am", 95);
      data.put("Cm", 96);
      data.put("Bk", 97);
      data.put("Cf", 98);
      data.put("Es", 99);
      data.put("Fm", 100);
      data.put("Md", 101);
      data.put("No", 102);
      data.put("Lr", 103);
    }
  }
  
  static AtomicNumberList newInstance() {
    return new AtomicNumberList();
  } 
}