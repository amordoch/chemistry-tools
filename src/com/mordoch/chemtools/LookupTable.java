/* Copyright Ariel Mordoch 2014
This file is part of Chemistry Tools.

    Chemistry Tools is free software: you can redistribute it and/or modify
    it under the terms of the Lesser GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Chemistry Tools is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    Lesser GNU General Public License for more details.

    You should have received a copy of the Lesser GNU General Public License
    along with Chemistry Tools.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mordoch.chemtools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * This class is used to store information about elements.
 * @author Ariel Mordoch
 * @version 1.0
 * @since 1.0.3
 */

public class LookupTable {

	/**
	 * Prints a list of all the tables contained in the class.
	 * @since 1.0.3
	 */
	
	public void list() {
		System.out.println("Lists in lookup table:");
		System.out.println( molarMass().toString() );
	}

	/**
	 * Finds information about an element and then returns a list containing that information.
	 * <p>Format: <code>atomic mass, molar mass, atomic number</code> </p> 
	 * @param element a string containing the symbol for an element.
	 * @return A List<<x>String> containing information about an element. See format above.
	 * @since 1.0.3
	 */

	public List<String> getElementInfo(String element) {
		// Create a new ArrayList that stores element info.
		List<String> elementInfo = new ArrayList<String>();
		// Print element info to console
		System.out.println("Atomic mass: " + molarMass().get(element) + " amu" );
		System.out.println("Molar mass: " + molarMass().get(element) + " g/mol" );
		// Store element info
		elementInfo.add( Double.toString( molarMass().get(element) ) );
		elementInfo.add( Double.toString( molarMass().get(element) ) );
		return elementInfo;
	}

	/**
	 * Defines and returns a Map<<x>String, Double> containing the atomic/molar masses of every element on the periodic table.
	 * Each element was added in order for the sake of convenience.
	 * @return A Map<<x>String, Double> where the key is the atomic symbol, and the value is the atomic/molar mass. 
	 * @since 1.0.3
	 */

	public final Map<String, Double> molarMass() {
		Map<String, Double> molarMass = new HashMap<String, Double>();
		// Source: http://www.ptable.com
		molarMass.put("H", 1.008);
		molarMass.put("He", 4.002602);
		molarMass.put("Li", 6.94);
		molarMass.put("Be", 9.012182);
		molarMass.put("B", 10.81);
		molarMass.put("C", 12.011);
		molarMass.put("N", 14.007);
		molarMass.put("O", 15.999);
		molarMass.put("F", 18.9984032);
		molarMass.put("Ne", 20.1797);
		molarMass.put("Na", 22.98976928);
		molarMass.put("Mg", 24.305);
		molarMass.put("Al", 26.9815386);
		molarMass.put("Si", 28.085);
		molarMass.put("P", 30.973762); 
		molarMass.put("S", 32.06);
		molarMass.put("Cl", 32.45);
		molarMass.put("Ar", 39.948);
		molarMass.put("K", 39.0983);
		molarMass.put("Ca", 40.078);
		molarMass.put("Sc", 44.955912);
		molarMass.put("Ti", 47.867);
		molarMass.put("V", 50.9415);
		molarMass.put("Cr", 51.9961);
		molarMass.put("Mn", 54.938045);
		molarMass.put("Fe", 55.845);
		molarMass.put("Co", 58.933195);
		molarMass.put("Ni", 58.6934);
		molarMass.put("Cu", 63.536);
		molarMass.put("Zn", 65.38);
		molarMass.put("Ga", 69.723);
		molarMass.put("Ge", 72.63);
		molarMass.put("As", 74.92160);
		molarMass.put("Se", 78.96);
		molarMass.put("Br", 79.904);
		molarMass.put("Kr", 83.798);
		molarMass.put("Rb", 85.4678);
		molarMass.put("Sr", 87.62);
		molarMass.put("Y", 88.90585);
		molarMass.put("Zr", 91.224);
		molarMass.put("Nb", 92.90638);
		molarMass.put("Mo", 95.96);
		molarMass.put("Tc", 98.);
		molarMass.put("Ru", 101.07);
		molarMass.put("Rh", 102.90550);
		molarMass.put("Pd", 106.42);
		molarMass.put("Ag", 107.8682);
		molarMass.put("Cd", 112.411);
		molarMass.put("In", 114.818);
		molarMass.put("Sn", 118.710);
		molarMass.put("Sb", 121.760);
		molarMass.put("Te", 127.60);
		molarMass.put("I", 126.90447);
		molarMass.put("Xe", 131.293);
		molarMass.put("Cs", 132.9054519);
		molarMass.put("Ba", 137.327);
		molarMass.put("Hf", 178.49);
		molarMass.put("Ta", 180.94788);
		molarMass.put("W", 183.84);
		molarMass.put("Re", 186.207);
		molarMass.put("Os", 190.23);
		molarMass.put("Ir", 192.217);
		molarMass.put("Pt", 195.084);
		// I LOVE GOOOOOOOOOOOOLD
		molarMass.put("Au", 196.966569);
		molarMass.put("Hg", 200.59);
		molarMass.put("Tl", 204.38);
		molarMass.put("Pb", 207.2);
		molarMass.put("Bi", 208.98040);
		molarMass.put("Po", 209.);
		molarMass.put("At", 210.);
		molarMass.put("Rn", 222.);
		molarMass.put("Fr", 223.);
		molarMass.put("Ra", 226.);
		molarMass.put("Rf", 267.);
		molarMass.put("Db", 268.);
		molarMass.put("Sg", 271.);
		molarMass.put("Bh", 272.);
		molarMass.put("Hs", 270.);
		molarMass.put("Mt", 276.);
		molarMass.put("Ds", 281.);
		molarMass.put("Rg", 280.);
		molarMass.put("Cn", 285.);
		molarMass.put("Uut", 284.);
		molarMass.put("Fl", 289.);
		molarMass.put("Uup", 288.);
		molarMass.put("Lv", 293.);
		molarMass.put("Uus", 294.);
		molarMass.put("Uuo", 294.);
		molarMass.put("La", 138.90547);
		molarMass.put("Ce", 140.116);
		molarMass.put("Pr", 140.90765);
		molarMass.put("Nd", 144.242);
		molarMass.put("Pm", 145.);
		molarMass.put("Sm", 150.36);
		molarMass.put("Eu", 151.964);
		molarMass.put("Gd", 157.25);
		molarMass.put("Tb", 158.92535);
		molarMass.put("Dy", 162.500);
		molarMass.put("Ho", 164.93032);
		molarMass.put("Er", 167.259);
		molarMass.put("Tm", 168.93421);
		molarMass.put("Yb", 173.054);
		molarMass.put("Lu", 174.9668);
		molarMass.put("Ac", 227.);
		molarMass.put("Th", 232.03806);
		molarMass.put("Pa", 231.03586);
		molarMass.put("U", 238.02891);
		molarMass.put("Np", 237.);
		molarMass.put("Pu", 244.);
		molarMass.put("Am", 243.);
		molarMass.put("Cm", 247.);
		molarMass.put("Bk", 247.);
		molarMass.put("Cf", 251.);
		molarMass.put("Es", 252.);
		molarMass.put("Fm", 257.);
		molarMass.put("Md", 258.);
		molarMass.put("No", 259.);
		molarMass.put("Lr", 262.);
		return molarMass;
	}


}
