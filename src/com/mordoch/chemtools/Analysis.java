/*
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
 * <p><em>All methods are static.</em></p>
 * @author Ariel Mordoch
 * @version 1.0.1
 * @see Run
 * @since 1.0
 */

public class Analysis {
	
	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes 3 percents and 3 elements and finds the empirical formula for a compound containing those elements.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
	 * @param percent1 the percent of element 1 in compound X
	 * @param percent2 the percent of a second element in compound X
	 * @param percent3 the percent of a third element in compound X
	 * @param molarMass the molar mass of compound X
	 * @param element1 the element corresponding to percent1
	 * @param element2 the element corresponding to percent2
	 * @param element3 the element corresponding to percent3
	 * @return empirical formula <b>without correction for decimal subscripts</b>.
	 * @since 1.0
	 */
	
	public static String empiricalFromPercentComposition (double percent1, double percent2, double percent3, double molarMass, String element1, String element2, String element3) {
		// First find the mols of each element then find which one is smallest.
		double element1Mols = percent1 / molarMass;
		double element2Mols = percent2 / molarMass;
		double element3Mols = percent3 / molarMass;
		double normalize = Math.min(element1Mols, Math.min(element2Mols, element3Mols) );
		// Now normalize the formula.
		double element1Normal = element1Mols / normalize;
		double element2Normal = element2Mols / normalize;
		double element3Normal = element3Mols / normalize;
		// Now return the completed formula.
		return element1 + " " + element1Normal + " " + element2 + " " + element2Normal + " " + element3 + " " + element3Normal;
	}
	
	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes 2 percents and 2 elements and finds the empirical formula for a compound containing those elements.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
	 * @param percent1 the percent of element 1 in compound X
	 * @param percent2 the percent of a second element in compound X
	 * @param molarMass the molar mass of compound X
	 * @param element1 the element corresponding to percent1
	 * @param element2 the element corresponding to percent2
	 * @return empirical formula <b>without correction for decimal subscripts</b>.
	 * @since 1.0.1
	 */
	
	public static String empiricalFromPercentComposition (double percent1, double percent2, double molarMass, String element1, String element2) {
		// First find the mols of each element then find which one is smallest.
		double element1Mols = percent1 / molarMass;
		double element2Mols = percent2 / molarMass;
		double normalize = Math.min(element1Mols, element2Mols);
		// Now normalize the formula.
		double element1Normal = element1Mols / normalize;
		double element2Normal = element2Mols / normalize;
		// Now return the completed formula.
		return element1 + " " + element1Normal + " " + element2 + " " + element2Normal;
	}

	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes the total mass of a compound and its three elements and determines the empirical formula of that compound.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with two elements rather than three.</em>
	 * @param mass1 the mass of an element in compound X
	 * @param mass2 the mass of a second element in compound X
	 * @param mass3 the mass of a third element in compound X
	 * @param totalMass total mass of compound X
	 * @param element1 the element that corresponds to mass1
	 * @param element2 the element that corresponds to mass2
	 * @param element3 the element that corresponds to mass3
	 * @return empirical formula, <b>without correcting for decimal subscripts</b>
	 * @since 1.0.1
	 */
	
	public static String empiricalFromMass (double mass1, double mass2, double mass3, double totalMass, String element1, String element2, String element3) {
		// First find the mols of each element.
		double element1Mols = totalMass / mass1;
		double element2Mols = totalMass / mass2;
		double element3Mols = totalMass / mass3;
		double normalize = Math.min( element1Mols, Math.min(element2Mols, element3Mols) );
		// Now normalize.
		double element1Normal = element1Mols / normalize;
		double element2Normal = element2Mols / normalize;
		double element3Normal = element3Mols / normalize;
		// Return completed formula.
		return element1 + " " + element1Normal + " " + element2 + " " + element2Normal + " " + element3 + " " + element3Normal;
	}
	
	/**
	 * <p><h1> Method has not been verified to work correctly.</h1></p>
	 * This method takes the total mass of a compound and its two elements and determines the empirical formula of that compound.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
	 * @param mass1 the mass of an element in compound X
	 * @param mass2 the mass of a second element in compound X
	 * @param totalMass total mass of compound X
	 * @param element1 the element that corresponds to mass1
	 * @param element2 the element that corresponds to mass2
	 * @return empirical formula, <b>without correcting for decimal subscripts</b>
	 * @since 1.0.1
	 */
	
	public static String empiricalFromMass (double mass1, double mass2, double totalMass, String element1, String element2) {
		// First find the mols of each element.
				double element1Mols = totalMass / mass1;
				double element2Mols = totalMass / mass2;
				double normalize = Math.min( element1Mols, element2Mols );
				// Now normalize.
				double element1Normal = element1Mols / normalize;
				double element2Normal = element2Mols / normalize;
				// Return completed formula.
				return element1 + " " + element1Normal + " " + element2 + " " + element2Normal;
	}
	
}
