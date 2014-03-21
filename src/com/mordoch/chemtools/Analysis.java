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

/**
 * This class contains tools for analysis, i.e. finding empirical formula given percent composition.
 * @author Ariel Mordoch
 * @version 0.5
 * @see Run
 * @since 0.1
 */

public class Analysis {
	
	// Create a new lookup table for use in finding molar masses.
	private LookupTable lookup = new LookupTable(1, 0, 2, 3);

	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes 3 percents and 3 elements and finds the empirical formula for a compound containing those elements
	 * (the molar masses of each element are found automatically. The user must provide the element's symbol, i.e. "H").
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with two elements rather than three.</em>
	 * @param percent1 the percent of element 1 in compound X
	 * @param percent2 the percent of a second element in compound X
	 * @param percent3 the percent of a third element in compound X
	 * @param element1 the symbol, i.e. "H", of the element corresponding to percent1
	 * @param element2 the symbol, i.e. "H", of the element corresponding to percent2
	 * @param element3 the symbol, i.e. "H", of the element corresponding to percent3
	 * @return Empirical formula <b>without correction for decimal subscripts</b>.
	 * @since 1.0
	 */

	public String empiricalFromPercentComposition (double percent1, double percent2, double percent3, String element1, String element2, String element3) {
		// First find the mols of each element then find which one is smallest.
		double element1Mols = percent1 / lookup.getMolarMass(element1);
		double element2Mols = percent2 / lookup.getMolarMass(element2);
		double element3Mols = percent3 / lookup.getMolarMass(element3);
		double normalize = Math.min(element1Mols, Math.min(element2Mols, element3Mols) );
		// Now normalize the formula.
		double element1Normal = element1Mols / normalize;
		double element2Normal = element2Mols / normalize;
		double element3Normal = element3Mols / normalize;
		// Now return the completed formula.
		return element1 + "(" + element1Normal + ")" + element2 + "(" + element2Normal + ")" + element3 + "(" + element3Normal + ")";
	}

	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes 2 percents and 2 elements and finds the empirical formula for a compound containing those elements
	 * (the molar masses of each element are found automatically. The user must provide the element's symbol, i.e. "H").
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
	 * @param percent1 the percent of element 1 in compound X
	 * @param percent2 the percent of a second element in compound X
	 * @param element1 the symbol, i.e. "H", of the element corresponding to percent1
	 * @param element2 the symbol, i.e. "H", of the element corresponding to percent2
	 * @return Empirical formula <b>without correction for decimal subscripts</b>.
	 * @since 1.0.1
	 */

	public String empiricalFromPercentComposition (double percent1, double percent2, String element1, String element2) {
		// First find the mols of each element then find which one is smallest.
		double element1Mols = percent1 / lookup.getMolarMass(element1);
		double element2Mols = percent2 / lookup.getMolarMass(element2);
		double normalize = Math.min(element1Mols, element2Mols);
		// Now normalize the formula.
		double element1Normal = element1Mols / normalize;
		double element2Normal = element2Mols / normalize;
		// Now return the completed formula.
		return element1 + "(" + element1Normal + ")" + element2 + "(" + element2Normal + ")";
	}

	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes the total mass of a compound and its three elements and determines the empirical formula of that compound.
	 * Employs the empiricalFromPercentComposition method to work.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with two elements rather than three.</em>
	 * @param mass1 the mass of an element in compound X
	 * @param mass2 the mass of a second element in compound X
	 * @param mass3 the mass of a third element in compound X
	 * @param element1 the element that corresponds to mass1
	 * @param element2 the element that corresponds to mass2
	 * @param element3 the element that corresponds to mass3
	 * @return empirical formula, <b>without correcting for decimal subscripts</b>
	 * @see Analysis#empiricalFromPercentComposition(double, double, double, String, String, String)
	 * @since 1.0.1
	 */

	public String empiricalFromMass (double mass1, double mass2, double mass3, String element1, String element2, String element3) {
		// First find the percent composition
		double element1Percent = mass1 / lookup.getMolarMass(element1);
		double element2Percent = mass2 / lookup.getMolarMass(element2);
		double element3Percent = mass3 / lookup.getMolarMass(element3);
		// Now find empirical formula (there's already a method for this, so why not use it?).
		return empiricalFromPercentComposition(element1Percent, element2Percent, element3Percent, element1, element2, element3);
	}

	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes the total mass of a compound and its two elements and determines the empirical formula of that compound.
	 * Employs the empiricalFromPercentComposition method to work.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
	 * @param mass1 the mass of an element in compound X
	 * @param mass2 the mass of a second element in compound X
	 * @param element1 the element that corresponds to mass1
	 * @param element2 the element that corresponds to mass2
	 * @return empirical formula, <b>without correcting for decimal subscripts</b>
	 * @see Analysis#empiricalFromPercentComposition(double, double, String, String)
	 * @since 1.0.1
	 */

	public String empiricalFromMass (double mass1, double mass2, String element1, String element2) {
		// First find the percent composition
		double element1Percent = mass1 / lookup.getMolarMass(element1);
		double element2Percent = mass2 / lookup.getMolarMass(element2);
		// Now find empirical formula
		return empiricalFromPercentComposition(element1Percent, element2Percent, element1, element2);
	}
	
	/**
	 * <p><h1> Method has not been verified to work correctly. </h1></p>
	 * This method takes the molar mass of a compound, the molar mass of its empirical formula, and an array of the empirical formula's subscripts.
	 * It returns the subscripts of the molecular formula in an int[] array.
	 * @param molarMassCompound the molar mass of a compound
	 * @param molarMassEmpirical the molar mass of a compound's empirical formula
	 * @param subscripts an array containing the empirical formula subscripts
	 * @return an array containing the molecular formula's subscripts
	 * @since 1.0.2
	 */
	
	public final int[] molecularFromEmpirical (double molarMassCompound, double molarMassEmpirical, int[] subscripts) {
		// First, find the factor of the molecular formula
		double multiplier = molarMassCompound / molarMassEmpirical;
		// Create a new array of doubles to store the multiplied subscripts
		double[] newSubscripts = new double[3];
		// Create an array of ints to store the correct, rounded subscripts
		int[] roundedSubscripts = new int[3];
		// Loop through the original subscripts
		for (int index = 0; index < subscripts.length - 1; index++) {
			// Multiply the subscript by the multiplier and store it in newSubscripts
			newSubscripts[index] = subscripts[index] * multiplier;
			// Round that off so it's proper
			roundedSubscripts[index] = (int) Math.round( newSubscripts[index] );
		}
		// Return the array
		return roundedSubscripts;
	}
}
