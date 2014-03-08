package com.mordoch.chemtools;

/**
 * This class is used as a conversions library for conversions applicable to chemistry.
 * <p> Conversion types are length, molar, mass, and volume. </p>
 * <em> All methods are static. </em>
 * @author Ariel M
 * @version 1.0
 * @see Run
 * @since 1.0
 */

public class Conversion { 
	
	// Avogadro's number for use in molar calcs
	private static double avosNum = Math.pow(6.0221413, 23);
	
	/*
	 * Molar conversions
	 */
	
	/**
	 * This converts from mass to the amount of mols.
	 * @param mass the mass of an element/formula
	 * @param molarMass the molar mass of an element formula
	 * @return mols of an element/formula
	 * @since 1.0
	 */
	
	public static double massToMolar (double mass, double molarMass) {
		return mass / molarMass;
	}
	
	/**
	 * Converts from mols of an element/formula to mass.
	 * @param mols mols of an element/formula
	 * @param molarMass molar mass of an element/formula
	 * @return mass of an element/formula
	 * @since 1.0
	 */
	
	public static double molsToMass (double mols, double molarMass) {
		return mols * molarMass;
	}
	
	/**
	 * Converts from mols to atom count.
	 * @param mols mols of a substance
	 * @return amount of atoms
	 * @since 1.0
	 */
	
	public static double molsToAtomCount (double mols) {
		return mols * avosNum;
	}
	
	/**
	 * Converts from atom count to mols.
	 * @param atomCount amount of atoms
	 * @return mols of an element/formula
	 * @since 1.0
	 */
	
	public static double atomCountToMols (double atomCount) {
		return atomCount / avosNum;
	}
	
	/*
	 * Length conversions
	 */
	
	/**
	 * Converts from centimeters to meters.
	 * @param centimeters
	 * @return meters
	 * @since 1.0
	 */
	
	public static double centimetersToMeters (double centimeters) {
		return centimeters / 100;
	}
	
	/**
	 * Converts from microns to centimeters
	 * @param microns
	 * @return centimeters
	 * @since 1.0
	 */
	
	public static double micronsToCentimeters (double microns) {
		return microns / 1000;
	}
	
	/**
	 * Converts from nanometers to microns
	 * @param nanometers
	 * @return microns
	 * @since 1.0
	 */
	
	public static double nanometersToMicrons (double nanometers) {
		return nanometers / 1000;
	}
	
	/**
	 * Converts from picometers to nanometers
	 * @param picometers
	 * @return nanometers
	 * @since 1.0
	 */
	
	public static double picometersToNanometers (double picometers) {
		return picometers / 1000;
	}
	
	/**
	 * Converts from meters to centimeters
	 * @param meters
	 * @return centimeters
	 * @since 1.0
	 */
	
	public static double metersToCentimeters (double meters) {
		return meters * 100;
	}
	
	/**
	 * Converts from centimeters to microns
	 * @param centimeters
	 * @return microns
	 * @since 1.0
	 */
	
	public static double centimetersToMicrons(double centimeters) {
		return centimeters * 10000;
	}
	
	/**
	 * Converts from microns to nanometers
	 * @param microns
	 * @return nanometers
	 * @since 1.0
	 */
	
	public static double micronsToNanometers (double microns) {
		return microns * 1000;
	}
	
	/**
	 * Converts from nanometers to picometers
	 * @param nanometers
	 * @return picometers
	 * @since 1.0
	 */
	
	public static double nanometersToPicometers (double nanometers) {
		return nanometers * 1000;
	}
	
	/*
	 * Mass conversions
	 */
	
	/**
	 * Converts from grams to milligrams.
	 * @param grams
	 * @return milligrams
	 * @since 1.0
	 */
	
	public static double gramsToMilligrams (double grams) {
		return grams * 1000;
	}
	
	/**
	 * Converts from grams to kilograms.
	 * @param grams
	 * @return kilograms
	 * @since 1.0
	 */
	
	public static double gramsToKilograms (double grams) {
		return grams / 1000;
	}
	
	/**
	 * Converts from milligrams to grams.
	 * @param milligrams
	 * @return grams
	 * @since 1.0
	 */
	
	public static double milligramsToGrams (double milligrams) {
		return milligrams / 1000;
	}
	
	/**
	 * Converts from kilograms to grams.
	 * @param kilograms
	 * @return grams
	 * @since 1.0
	 */
	
	public static double kilogramsToGrams (double kilograms) {
		return kilograms / 1000;
	}
	
	/**
	 * Converts from atomic mass units to grams.
	 * @param amus
	 * @return grams
	 * @since 1.0
	 */
	
	public static double amuToGram(double amus) {
		double conversionFactor = Math.pow(1.66053892, -24);
		return amus * conversionFactor;
	}
	
	/**
	 * Converts from grams to atomic mass units.
	 * @param grams
	 * @return atomic mass units
	 * @since 1.0
	 */
	
	public static double gramToAmu(double grams) {
		double conversionFactor = Math.pow(1.66053892, -24);
		return grams / conversionFactor;
	}
	
	/*
	 * Volume conversions
	 */
	
	/**
	 * Converts from liters to mL.
	 * @param liters
	 * @return mL
	 * @since 1.0
	 */
	
	public static double litersToMilliliters (double liters) {
		return liters * 1000;
	}
	
	/**
	 * Converts from liters to kL. 
	 * @param liters
	 * @return kL
	 * @since 1.0
	 */
	
	public static double litersToKiloliters (double liters) {
		return liters / 1000;
	}
	
	/**
	 * Converts from mL to liters.
	 * @param milliliters
	 * @return liters
	 * @since 1.0
	 */
	
	public static double millilitersToLiters (double milliliters) {
		return milliliters / 1000;
	}
	
	/**
	 * Converts from kL to liters.
	 * @param kiloliters
	 * @return liters
	 * @since 1.0
	 */
	
	public static double kilolitersToLiters (double kiloliters) {
		return kiloliters / 1000;
	}
}
