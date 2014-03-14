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

import java.util.Scanner;

/**
 * The main class of chem tools and the one that actually runs the program.
 * <p><h6> Note: there are two private methods in this class. One simply runs System.out.println() for faster typing.
 * The other prints "Enter an amount: " to the console. </h6></p>
 * @author Ariel Mordoch
 * @version 1.0
 * @since 1.0
 */

public class Run {
	
	private static void println(String x) {
		System.out.println(x);
	}
	private static void amount() {
		System.out.println("Enter an amount: ");
	}
	
	/**
	 * The main method does the bulk of the work, listing options in categories and finally executing an option.
	 * <p>In more detail:</p> 
	 * First the program asks the user what he/she wants to do. Using a switch statement, 
	 * the program lists the option from there. For example, the "Conversions" option has several 
	 * submenus that again use switch statements to find what conversion category the user wanted
	 * and what conversion they wanted. It then prints the result of the conversion to the console.
	 * @param args
	 * @see Conversion
	 * @since 1.0
	 */
	
	public static void main (String[] args) {
		// Create the input scanner and make sure the loop starts
		Scanner input = new Scanner(System.in);
		boolean isExit = false;
		// Loop so the user can start over once finished
		while (!isExit) {
			// Tell the user his/her options and get input
			println("Choose an option");
			println("0: Conversions");
			// Now check the option he entered
			switch ( input.nextInt() ) {
			
			case 0:
				// If he entered conversions, show conversions category
				println("Choose an option: ");
				println("0: Length conversions");
				println("1: Mass conversions");
				println("2: Volume conversions");
				println("3: Molar conversions");
				// Now check which category he/she chose and show conversions
				switch ( input.nextInt() ) {
				// Length conversions follow
				case 0:

					println("Choose a conversion:");
					println("0: Centimeters to meters");
					println("1: Meters to centimeters");
					println("2: Microns to centimeters");
					println("3: Centimeters to microns");
					println("4: Nanometers to microns");
					println("5: Microns to nanometers");
					println("6: Picometers to nanometers");
					println("7: Nanometers to picometers");

					switch ( input.nextInt() ) {

					case 0: 
						// Centimeters to meters
						amount();
						double centimeters = input.nextDouble();
						println( Conversion.centimetersToMeters(centimeters) + " m" );
						break;

					case 1:
						// Meters to centimeters
						amount();
						double meters = input.nextDouble();
						println( Conversion.metersToCentimeters(meters) + " cm"  );
						break;

					case 2:
						// Microns to centimeters
						amount();
						double microns = input.nextDouble();
						println( Conversion.micronsToCentimeters(microns) + " cm" );
						break;

					case 3:
						// Centimeters to microns
						amount();
						double centimeters1 = input.nextDouble();
						println( Conversion.centimetersToMicrons(centimeters1) + " microns");
						break;

					case 4:
						// Nanometers to microns
						amount();
						double nanometers = input.nextDouble();
						println( Conversion.nanometersToMicrons(nanometers) + " microns" );
						break;

					case 5:
						// Microns to nanometers
						amount();
						double microns1 = input.nextDouble();
						println( Conversion.micronsToNanometers(microns1) + " nm" );
						break;

					case 6: 
						// Picometers to nanometers
						amount();
						double picometers = input.nextDouble();
						println( Conversion.picometersToNanometers(picometers) + " nm");
						break;

					case 7:
						// Nanometers to picometers
						amount();
						double nanometers1 = input.nextDouble();
						println( Conversion.nanometersToPicometers(nanometers1) + " pm" );
						break;

					default:
						println("Wow, you are REALLY bad at entering options.");
					}

					break;
				// Mass conversions follow	
				case 1:

					println("Choose a conversion: ");
					println("0: Grams to milligrams");
					println("1: Milligrams to grams");
					println("2: Grams to kilograms");
					println("3: Kilograms to grams");
					println("4: amu to grams");
					println("5: Grams to amu");

					switch( input.nextInt() ) {
					
					case 0:
						// Grams to milligrams
						amount();
						double grams = input.nextDouble();
						println( Conversion.gramsToMilligrams(grams) + " mg" );
						break;
					
					case 1:
						// Milligrams to grams
						amount();
						double milligrams = input.nextDouble();
						println( Conversion.milligramsToGrams(milligrams) + " g" );
						break;
					
					case 2:
						// Grams to kilograms
						amount();
						double grams1 = input.nextDouble();
						println( Conversion.gramsToKilograms(grams1) + " kg" );
						break;
					
					case 3:
						// Kilograms to grams
						amount();
						double kilograms = input.nextDouble();
						println( Conversion.kilogramsToGrams(kilograms) + " g" );
						break;

					case 4:
						//amus to grams
						amount();
						double amus = input.nextDouble();
						println( Conversion.amuToGram(amus) + " g" );
						break;
					
					case 5:
						// Grams to amus
						amount();
						double grams2 = input.nextDouble();
						println( Conversion.gramToAmu(grams2) + " amu" );

					default:
						println("No words, no words...");
					}

					break;
				// Volume conversions follow
				case 2:
					
					println("Choose a conversion: ");
					println("0: Liters to milliliters");
					println("1: Milliliters to liters");
					println("2: Liters to kiloliters");
					println("3: Kiloliters to liters");
					
					switch ( input.nextInt() ) {
					
					case 0:
						// Liters to milliliters
						amount();
						double liters = input.nextDouble();
						println( Conversion.litersToMilliliters(liters) + " mL" );
						break;
					
					case 1:
						// Milliliters to liters
						amount();
						double milliliters = input.nextDouble();
						println( Conversion.millilitersToLiters(milliliters) + " L" );
						break;
					
					case 2:
						// Liters to kiloliters
						amount();
						double liters1 = input.nextDouble();
						println( Conversion.litersToKiloliters(liters1) + " kL" );
						break;
					
					case 3:
						// Kiloliters to liters
						amount();
						double kiloliters = input.nextDouble();
						println( Conversion.kilolitersToLiters(kiloliters) + " L" );
						break;
					
					default:
						println("It must be insanely difficult to enter a number.");
						
					}
					
					break;
				// Molar conversions follow	
				case 3: 

					println("Choose a conversion:");
					println("0: Grams to mols");
					println("1: Mols to grams");
					println("2: Mols to Atom count");
					println("3: Atom count to mols");

					switch ( input.nextInt() ) {

					case 0:
						// grams to mols
						println("Enter the mass of an element/formula: ");
						double mass = input.nextDouble();
						println("Enter the molar mass of an element/formula: ");
						double molarMass = input.nextDouble();
						println( Conversion.massToMols(mass, molarMass) + " mols" );
						break;
					
					case 1:
						// mols to grams
						println("Enter the mols of an element/formula: ");
						double mols = input.nextDouble();
						println("Enter the molar mass of an element/formula: ");
						double molarMass1 = input.nextDouble();
						println( Conversion.molsToMass(mols, molarMass1) + " g" );
						break;

					case 2:
						// mols to atom count
						println("Enter the mols of an element/formula: ");
						double mols1 = input.nextDouble();
						println( Conversion.molsToAtomCount(mols1) + " atoms" );
						break;

					case 3:
						// atom count to mols
						println("Enter the atom count of an element/formula: ");
						double atomCount = input.nextDouble();
						println( Conversion.atomCountToMols(atomCount) + " mols" );
						break;
					}

					break;

				default:
					println("I didn't think it was that hard to enter an option.");
				} // End conversions
				break;

			default:
				println("Good job, you didn't enter an option.");				
			} // End main menu
			
			// Now ask if the user wants to start again
			println("Exit? (Enter true or false)");
			isExit = input.nextBoolean();
		} // end loop 
		input.close(); // Don't forget to close the input stream so there's no resource leak
	} // end method
} // end class
