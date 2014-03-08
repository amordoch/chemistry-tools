package com.mordoch.chemtools;

/**
 * This class contains tools for analysis, i.e. finding empirical formula given percent composition.
 * <p><em>All methods are static.</em></p>
 * @author Ariel M
 * @version 1.0
 * @see Run
 * @since 1.0
 */

public class Analysis {
	
	/**
	 * This method takes 3 percents and 3 elements and finds the empirical formula for that compound.
	 * <p><b> Note that this method does not check whether one of the normalized subscripts are decimals. </b></p>
	 * @param percent1 the percent of element 1 in a compound
	 * @param percent2 the percent of element 2 in a compound
	 * @param percent3 the percent of element 3 in a compound
	 * @param molarMass the molar mass of a compound
	 * @param element1 the first element in a compound
	 * @param element2 the second element in a compound
	 * @param element3 the third element in a compound
	 * @return empirical formula
	 * @since 1.0
	 */
	
	public static String empiricalFromPercentComposition (double percent1, double percent2, double percent3, double molarMass, String element1, String element2, String element3) {
		// First find the mols of each element then find which one is smallest.
		double element1Mols = percent1/molarMass;
		double element2Mols = percent2/molarMass;
		double element3Mols = percent3/molarMass;
		double normalize = Math.min(element1Mols, Math.min(element2Mols, element3Mols) );
		// Now normalize the formula.
		double element1Normal = element1Mols / normalize;
		double element2Normal = element2Mols / normalize;
		double element3Normal = element3Mols / normalize;
		// Now return the completed formula (note: if one of the element is say, 2.5 mols, the user will have to multiply each subscript by a factor of 2 to get the correct formula).
		return element1 + " " + element1Normal + " " + element2 + " " + element2Normal + " " + element3 + " " + element3Normal;
	}

	public static String empiricalFromPercentComposition (double percent1, double percent2, double molarMass, String element1, String element2) {
		return "c";
	}
}
