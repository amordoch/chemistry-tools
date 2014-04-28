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

public final class FamilyList extends ElementInfoWrapper<String, String> {

  private FamilyList() {
    super("family", "118", "String", "String");
    addAll();
  }
  
@Override  
  protected void addAll() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    if (stackTraceElements[2].getMethodName() != "<init>") {
    } else {
      data.put("H", "Nonmetal");
      data.put("He", "Noble Gas");
      data.put("Li", "Alkali Metal");
      data.put("Be", "Alkaline Earth Metal");
      data.put("B", "Metalloid");
      data.put("C", "Nonmetal");
      data.put("N", "Nonmetal");
      data.put("O", "Nonmetal");
      data.put("F", "Halogen");
      data.put("Ne", "Noble Gas");
      data.put("Na", "Alkali Metal");
      data.put("Mg", "Alkaline Earth Metal");
      data.put("Al", "Post-tranistion metal");
      data.put("Si", "Metalloid");
      data.put("P", "Nonemtal");
      data.put("S", "Nonemtal");
      data.put("Cl", "Halogen");
      data.put("Ar", "Noble Gas");
      data.put("K", "Alkali Metal");
      data.put("Ca", "Alkaline Earth Metal");
      data.put("Sc", "Transition Metal");
      data.put("Ti", "Transition Metal");
      data.put("V", "Transition Metal");
      data.put("Cr", "Transition Metal");
      data.put("Mn", "Tranisition Metal");
      data.put("Fe", "Transition Metal");
      data.put("Co", "Transition Metal");
      data.put("Ni", "Transition Metal");
      data.put("Cu", "Transition Metal");
      data.put("Zn", "Transition Metal");
      data.put("Ga", "Post-transition Metal");
      data.put("Ge", "Metalloid");
      data.put("As", "Metalloid");
      data.put("Se", "Nonmetal");
      data.put("Br", "Halogen");
      data.put("Kr", "Noble Gas");
      data.put("Rb", "Alkali Metal");
      data.put("Sr", "Alkaline Earth Metal");
      data.put("Y", "Transition Metal");
      data.put("Zr", "Transition Metal");
      data.put("Nb", "Transition Metal");
      data.put("Mo", "Transition Metal");
      data.put("Tc", "Transition Metal");
      data.put("Ru", "Transition Metal");
      data.put("Rh", "Transition Metal");
      data.put("Pd", "Transition Metal");
      data.put("Ag", "Transition Metal");
      data.put("Cd", "Transition Metal");
      data.put("In", "Post-transition Metal");
      data.put("Sn", "Post-transition Metal");
      data.put("Sb", "Metalloid");
      data.put("Te", "Metalloid");
      data.put("I", "Halogen");
      data.put("Xe", "Noble Gas");
      data.put("Cs", "Alkali Metal");
      data.put("Ba", "Alkaline Earth Metal");
      data.put("Hf", "Transition Metal");
      data.put("Ta", "Transition Metal");
      data.put("W", "Transition Metal");
      data.put("Re", "Transition Metal");
      data.put("Os", "Transition Metal");
      data.put("Ir", "Transition Metal");
      data.put("Pt", "Transition Metal");
      // I LOVE GOOOOOOOOOOOOLD
      data.put("Au", "Transition Metal");
      data.put("Hg", "Transition Metal");
      data.put("Tl", "Post-transition Metal");
      data.put("Pb", "Post-transition Metal");
      data.put("Bi", "Post-transition Metal");
      data.put("Po", "Metalloid");
      data.put("At", "Halogen");
      data.put("Rn", "Noble Gas");
      data.put("Fr", "Alkali Metal");
      data.put("Ra", "Alkaline Earth Metal");
      data.put("Rf", "Transition Metal");
      data.put("Db", "Transition Metal");
      data.put("Sg", "Transition Metal");
      data.put("Bh", "Transition Metal");
      data.put("Hs", "Transition Metal");
      data.put("Mt", "Transition Metal");
      data.put("Ds", "Transition Metal");
      data.put("Rg", "Transition Metal");
      data.put("Cn", "Transition Metal");
      data.put("Uut", "Post-transition Metal");
      data.put("Fl", "Post-Transition Metal");
      data.put("Uup", "Post-transition Metal");
      data.put("Lv", "Post-transition Metal");
      data.put("Uus", "Metalloid (undetermined)");
      data.put("Uuo", "Noble Gas (undetermined)");
      data.put("La", "Lanthanide");
      data.put("Ce", "Lanthanide");
      data.put("Pr", "Lanthanide");
      data.put("Nd", "Lanthanide");
      data.put("Pm", "Lanthanide");
      data.put("Sm", "Lanthanide");
      data.put("Eu", "Lanthanide");
      data.put("Gd", "Lanthanide");
      data.put("Tb", "Lanthanide");
      data.put("Dy", "Lanthanide");
      data.put("Ho", "Lanthanide");
      data.put("Er", "Lanthanide");
      data.put("Tm", "Lanthanide");
      data.put("Yb", "Lanthanide");
      data.put("Lu", "Lanthanide");
      data.put("Ac", "Actinide");
      data.put("Th", "Actinide");
      data.put("Pa", "Actinide");
      data.put("U", "Actinide");
      data.put("Np", "Actinide");
      data.put("Pu", "Actinide");
      data.put("Am", "Actinide");
      data.put("Cm", "Actinide");
      data.put("Bk", "Actinide");
      data.put("Cf", "Actinide");
      data.put("Es", "Actinide");
      data.put("Fm", "Actinide");
      data.put("Md", "Actinide");
      data.put("No", "Actinide");
      data.put("Lr", "Actinide");
    }
  }


  static FamilyList newInstance() {
    return new FamilyList();
  }  
}