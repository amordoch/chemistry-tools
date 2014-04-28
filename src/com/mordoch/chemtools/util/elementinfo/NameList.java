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

public final class NameList extends ElementInfoWrapper<String, String> {

  private NameList() {
    super("element names", "118", "String", "String");
    addAll();
  }
@Override
  protected void addAll() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    if (stackTraceElements[2].getMethodName() != "<init>") {
    } else {
      data.put("H", "Hydrogen");
      data.put("He", "Helium");
      data.put("Li", "Lithuim");
      data.put("Be", "Beryllium");
      data.put("B", "Boron");
      data.put("C", "Carbon");
      data.put("N", "Nitrogren");
      data.put("O", "Oxygen");
      data.put("F", "Flourine");
      data.put("Ne", "Neon");
      data.put("Na", "Sodium");
      data.put("Mg", "Magnesium");
      data.put("Al", "Aluminium");
      data.put("Si", "Silicon");
      data.put("P", "Phosphorus");
      data.put("S", "Sulfur");
      data.put("Cl", "Chlorine");
      data.put("Ar", "Argon");
      data.put("K", "Potassium");
      data.put("Ca", "Calcium");
      data.put("Sc", "Scandium");
      data.put("Ti", "Titanium");
      data.put("V", "Vanadium");
      data.put("Cr", "Chromium");
      data.put("Mn", "Manganese");
      data.put("Fe", "Iron");
      data.put("Co", "Cobalt");
      data.put("Ni", "Nickel");
      data.put("Cu", "Copper");
      data.put("Zn", "Zinc");
      data.put("Ga", "Gallium");
      data.put("Ge", "Germanium");
      data.put("As", "Arsenic");
      data.put("Se", "Selinium");
      data.put("Br", "Bromine");
      data.put("Kr", "Krypton");
      data.put("Rb", "Rubidium");
      data.put("Sr", "Strontium");
      data.put("Y", "Yttrium");
      data.put("Zr", "Zirconium");
      data.put("Nb", "Niobium");
      data.put("Mo", "Molybdenum");
      data.put("Tc", "Technetium");
      data.put("Ru", "Ruthenium");
      data.put("Rh", "Rhodium");
      data.put("Pd", "Palladium");
      data.put("Ag", "Silver");
      data.put("Cd", "Cadmium");
      data.put("In", "Indium");
      data.put("Sn", "Tin");
      data.put("Sb", "Antimony");
      data.put("Te", "Tellurium");
      data.put("I", "Iodine");
      data.put("Xe", "Xenon");
      data.put("Cs", "Ceaseium");
      data.put("Ba", "Barium");
      data.put("Hf", "Hafnium");
      data.put("Ta", "Tantalum");
      data.put("W", "Tungsten");
      data.put("Re", "Rhenium");
      data.put("Os", "Osmium");
      data.put("Ir", "Iridium");
      data.put("Pt", "Platinum");
      // I LOVE GOOOOOOOOOOOOLD
      data.put("Au", "Gold");
      data.put("Hg", "Mercury");
      data.put("Tl", "Thallium");
      data.put("Pb", "Lead");
      data.put("Bi", "Bismuth");
      data.put("Po", "Polonium");
      data.put("At", "Astaline");
      data.put("Rn", "Radon");
      data.put("Fr", "Francium");
      data.put("Ra", "Radium");
      data.put("Rf", "Rutherfordium");
      data.put("Db", "Dubnium");
      data.put("Sg", "Seaborgium");
      data.put("Bh", "Bohrium");
      data.put("Hs", "Hassium");
      data.put("Mt", "Meitnerium");
      data.put("Ds", "Darmstadtium");
      data.put("Rg", "Roentgenium");
      data.put("Cn", "Copernicium");
      data.put("Uut", "Unutrium");
      data.put("Fl", "Flevroium");
      data.put("Uup", "Unupentium");
      data.put("Lv", "Livermorium");
      data.put("Uus", "Unuseptium");
      data.put("Uuo", "Ununoctium");
      data.put("La", "Lanthanum");
      data.put("Ce", "Cerium");
      data.put("Pr", "Praseodymium");
      data.put("Nd", "Neodymium");
      data.put("Pm", "Promethium");
      data.put("Sm", "Samarium");
      data.put("Eu", "Europium");
      data.put("Gd", "Gadolinium");
      data.put("Tb", "Terbium");
      data.put("Dy", "Dysprosium");
      data.put("Ho", "Holmium");
      data.put("Er", "Erbium");
      data.put("Tm", "Thulium");
      data.put("Yb", "Yttrbium");
      data.put("Lu", "Lutetium");
      data.put("Ac", "Actinium");
      data.put("Th", "Thorium");
      data.put("Pa", "Protactinium");
      data.put("U", "Uranium");
      data.put("Np", "Neptunium");
      data.put("Pu", "Plutonium");
      data.put("Am", "Americium");
      data.put("Cm", "Curium");
      data.put("Bk", "Berkelium");
      data.put("Cf", "Califonium");
      data.put("Es", "Einsteinium");
      data.put("Fm", "Fermium");
      data.put("Md", "Mendelvium");
      data.put("No", "Nobelium");
      data.put("Lr", "Lawrencium");
    }
  }
  
  static NameList newInstance() {
    return new NameList();
  } 
}
