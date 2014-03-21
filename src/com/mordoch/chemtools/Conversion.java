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
 * This class is used as a conversions library for conversions applicable to chemistry.
 * <p> Conversion types are length, molar, mass, and volume. </p>
 * <em> All methods are static; this class is abstract. </em>
 * @author Ariel M
 * @version 1.0
 * @see Run
 * @since 0.1
 */

public abstract class Conversion { 
	
	// Avogadro's number for use in molar calcs
	private static final double avosNum = Math.pow(6.0221413, 23);
	
	/*
	 * Molar conversions
	 */
	
	public static double massToMols (double mass, double molarMass) {
		return mass / molarMass;
	}
	
	public static double molsToMass (double mols, double molarMass) {
		return mols * molarMass;
	}
	
	public static double molsToAtomCount (double mols) {
		return mols * avosNum;
	}
	
	public static double atomCountToMols (double atomCount) {
		return atomCount / avosNum;
	}
	
	/*
	 * Length conversions
	 */
	
	public static double centimetersToMeters (double centimeters) {
		return centimeters / 100;
	}
	
	public static double micronsToCentimeters (double microns) {
		return microns / 1000;
	}
	
	public static double nanometersToMicrons (double nanometers) {
		return nanometers / 1000;
	}
	
	public static double picometersToNanometers (double picometers) {
		return picometers / 1000;
	}
	
	public static double metersToCentimeters (double meters) {
		return meters * 100;
	}
	
	public static double centimetersToMicrons(double centimeters) {
		return centimeters * 10000;
	}
	
	public static double micronsToNanometers (double microns) {
		return microns * 1000;
	}
	
	public static double nanometersToPicometers (double nanometers) {
		return nanometers * 1000;
	}
	
	/*
	 * Mass conversions
	 */
	
	public static double gramsToMilligrams (double grams) {
		return grams * 1000;
	}
	
	public static double gramsToKilograms (double grams) {
		return grams / 1000;
	}
	
	public static double milligramsToGrams (double milligrams) {
		return milligrams / 1000;
	}
	
	public static double kilogramsToGrams (double kilograms) {
		return kilograms / 1000;
	}
	
	public static double amuToGram(double amus) {
		double conversionFactor = Math.pow(1.66053892, -24);
		return amus * conversionFactor;
	}
	
	public static double gramToAmu(double grams) {
		double conversionFactor = Math.pow(1.66053892, -24);
		return grams / conversionFactor;
	}
	
	/*
	 * Volume conversions
	 */
	
	public static double litersToMilliliters (double liters) {
		return liters * 1000;
	}
	
	public static double litersToKiloliters (double liters) {
		return liters / 1000;
	}
	
	public static double millilitersToLiters (double milliliters) {
		return milliliters / 1000;
	}
	
	public static double kilolitersToLiters (double kiloliters) {
		return kiloliters / 1000;
	}
}
