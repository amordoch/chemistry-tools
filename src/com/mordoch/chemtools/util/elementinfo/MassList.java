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

package com.mordoch.chemtools.util.elementinfo;

public final class MassList extends ElementInfoWrapper<String, Double> {

  private MassList() {
    super("atomic and molar mass", "118", "String", "Double");
    addAll();
  }
@Override
  protected void addAll() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    if (stackTraceElements[2].getMethodName() != "<init>") {
    } else {
      data.put("H", 1.008);
      data.put("He", 4.002602);
      data.put("Li", 6.94);
      data.put("Be", 9.012182);
      data.put("B", 10.81);
      data.put("C", 12.011);
      data.put("N", 14.007);
      data.put("O", 15.999);
      data.put("F", 18.9984032);
      data.put("Ne", 20.1797);
      data.put("Na", 22.98976928);
      data.put("Mg", 24.305);
      data.put("Al", 26.9815386);
      data.put("Si", 28.085);
      data.put("P", 30.973762);
      data.put("S", 32.06);
      data.put("Cl", 35.453);
      data.put("Ar", 39.948);
      data.put("K", 39.0983);
      data.put("Ca", 40.078);
      data.put("Sc", 44.955912);
      data.put("Ti", 47.867);
      data.put("V", 50.9415);
      data.put("Cr", 51.9961);
      data.put("Mn", 54.938045);
      data.put("Fe", 55.845);
      data.put("Co", 58.933195);
      data.put("Ni", 58.6934);
      data.put("Cu", 63.536);
      data.put("Zn", 65.38);
      data.put("Ga", 69.723);
      data.put("Ge", 72.63);
      data.put("As", 74.92160);
      data.put("Se", 78.96);
      data.put("Br", 79.904);
      data.put("Kr", 83.798);
      data.put("Rb", 85.4678);
      data.put("Sr", 87.62);
      data.put("Y", 88.90585);
      data.put("Zr", 91.224);
      data.put("Nb", 92.90638);
      data.put("Mo", 95.96);
      data.put("Tc", 98.);
      data.put("Ru", 101.07);
      data.put("Rh", 102.90550);
      data.put("Pd", 106.42);
      data.put("Ag", 107.8682);
      data.put("Cd", 112.411);
      data.put("In", 114.818);
      data.put("Sn", 118.710);
      data.put("Sb", 121.760);
      data.put("Te", 127.60);
      data.put("I", 126.90447);
      data.put("Xe", 131.293);
      data.put("Cs", 132.9054519);
      data.put("Ba", 137.327);
      data.put("Hf", 178.49);
      data.put("Ta", 180.94788);
      data.put("W", 183.84);
      data.put("Re", 186.207);
      data.put("Os", 190.23);
      data.put("Ir", 192.217);
      data.put("Pt", 195.084);
      // I LOVE GOOOOOOOOOOOOLD
      data.put("Au", 196.966569);
      data.put("Hg", 200.59);
      data.put("Tl", 204.38);
      data.put("Pb", 207.2);
      data.put("Bi", 208.98040);
      data.put("Po", 209.);
      data.put("At", 210.);
      data.put("Rn", 222.);
      data.put("Fr", 223.);
      data.put("Ra", 226.);
      data.put("Rf", 267.);
      data.put("Db", 268.);
      data.put("Sg", 271.);
      data.put("Bh", 272.);
      data.put("Hs", 270.);
      data.put("Mt", 276.);
      data.put("Ds", 281.);
      data.put("Rg", 280.);
      data.put("Cn", 285.);
      data.put("Uut", 284.);
      data.put("Fl", 289.);
      data.put("Uup", 288.);
      data.put("Lv", 293.);
      data.put("Uus", 294.);
      data.put("Uuo", 294.);
      data.put("La", 138.90547);
      data.put("Ce", 140.116);
      data.put("Pr", 140.90765);
      data.put("Nd", 144.242);
      data.put("Pm", 145.);
      data.put("Sm", 150.36);
      data.put("Eu", 151.964);
      data.put("Gd", 157.25);
      data.put("Tb", 158.92535);
      data.put("Dy", 162.500);
      data.put("Ho", 164.93032);
      data.put("Er", 167.259);
      data.put("Tm", 168.93421);
      data.put("Yb", 173.054);
      data.put("Lu", 174.9668);
      data.put("Ac", 227.);
      data.put("Th", 232.03806);
      data.put("Pa", 231.03586);
      data.put("U", 238.02891);
      data.put("Np", 237.);
      data.put("Pu", 244.);
      data.put("Am", 243.);
      data.put("Cm", 247.);
      data.put("Bk", 247.);
      data.put("Cf", 251.);
      data.put("Es", 252.);
      data.put("Fm", 257.);
      data.put("Md", 258.);
      data.put("No", 259.);
      data.put("Lr", 262.);

    }
  }

  static MassList newInstance() {
    return new MassList();
  } 
}
