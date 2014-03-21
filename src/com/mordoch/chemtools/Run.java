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

import java.util.List;
import java.awt.print.PrinterIOException;
import java.util.Scanner;

/**
 * The main class of chem tools and the one that actually runs the program.
 * <p><h6> Note: there are two private methods in this class. One simply runs System.out.println() for faster typing.
 * The other prints "Enter an amount: " to the console. </h6></p>
 * @author Ariel Mordoch
 * @version 0.5
 * @since 0.1
 */

public class Run {

    private static void println(String x) {
        System.out.println(x);
    }
    private static void amount() {
        System.out.println("Enter an amount: ");
    }
    private static void programInfo() {
        println("Chemistry Tools 0.5 (Development build)");
        println("Copyright (c) 2014 Ariel Mordoch");
        println("Licensed under the LGPL");
        println("Source code available at www.github.com/amordoch/chemistry-tools");
        println("");
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

    public static void main (String[] args) throws PrinterIOException {
        // Create the input scanner and make sure the loop starts
        Scanner input = new Scanner(System.in);
        boolean continueLooping = true;
        // Create a Analysis object so we can access those functions
        Analysis analysis = new Analysis();
        // Create a LookupTable object so we can access element info
        LookupTable lookup = new LookupTable();
        // Print copyright information
        programInfo();
        // Loop so the user can start over once finished
        while (continueLooping) {
            
            // Tell the user his/her options and get input
            println("Choose an option:");
            println("0: Conversions");
            println("1: Analysis");
            println("2: Element info");
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

                case 1:

                    println("Choose an option:");
                    println("0: Empirical formula using percent composition");
                    println("1: Empirical formula using mass composition");
                    println("2: Molecular formula from empirical formula");
                    switch ( input.nextInt() ) {

                        case 0:
                            // Ask the user whether he has 2 or 3 elements
                            println("2 or 3 elements?");
                            switch ( input.nextInt() ) {

                                case 2:

                                    println("Enter an element (1): ");
                                    String element1 = input.next();
                                    println("Enter an element (2): ");
                                    String element2 = input.next();
                                    println("Enter a percentage for element 1: ");
                                    double percent1 = input.nextDouble();
                                    println("Enter a percentage for element 2: ");
                                    double percent2 = input.nextDouble();
                                    println( analysis.empiricalFromPercentComposition(percent1, percent2, element1, element2) );
                                    break;

                                case 3:

                                    println("Enter an element (1): ");
                                    String elementOne = input.next();
                                    println("Enter an element (2): ");
                                    String elementTwo = input.next();
                                    println("Enter an element (3): ");
                                    String elementThree = input.next();
                                    println("Enter a percentage for element 1: ");
                                    double percentOne = input.nextDouble();
                                    println("Enter a percentage for element 2: ");
                                    double percentTwo = input.nextDouble();
                                    println("Etner a percentage for element 3: ");
                                    double percentThree = input.nextDouble();
                                    println( analysis.empiricalFromPercentComposition(percentOne, percentTwo, percentThree, elementOne, elementTwo, elementThree) );
                                    break;

                                default:
                                    println("Unnamed option #Up-Up-Down-Down-Left-Right-Left-Right-B-A-Start");
                            } // end empirical from percent composition
                            break;

                        case 1:
                            // Ask the user whether he has 2 or 3 elements
                            println("2 or 3 elements?");
                            switch ( input.nextInt() ) {

                                case 2:

                                    println("Enter an element (1): ");
                                    String element1 = input.next();
                                    println("Enter an element (2): ");
                                    String element2 = input.next();
                                    println("Enter a mass for element 1: ");
                                    double mass1 = input.nextDouble();
                                    println("Enter a mass for element 2: ");
                                    double mass2 = input.nextDouble();
                                    println( analysis.empiricalFromMass(mass1, mass2, element1, element2) );
                                    break;

                                case 3:

                                    println("Enter an element (1): ");
                                    String elementOne = input.next();
                                    println("Enter an element (2): ");
                                    String elementTwo = input.next();
                                    println("Enter an element (3): ");
                                    String elementThree = input.next();
                                    println("Enter a percentage for element 1: ");
                                    double massOne = input.nextDouble();
                                    println("Enter a percentage for element 2: ");
                                    double massTwo = input.nextDouble();
                                    println("Etner a percentage for element 3: ");
                                    double massThree = input.nextDouble();
                                    println( analysis.empiricalFromMass(massOne, massTwo, massThree, elementOne, elementTwo, elementThree) );
                                    break;

                                default:
                                    println("Say hello to my little friend!");                 
                            } // end empirical from mass composition
                            break;

                        case 2:    

                            println("Enter the molar mass of the compound: ");
                            double molarMassCompound = input.nextDouble();
                            println("Enter the molar mass of the empirical formula: ");
                            double molarMassEmpirical = input.nextDouble();
                            println("Enter the subscripts of the empirical formula, one per line: ");
                            int[] subscripts = { input.nextInt(), input.nextInt(), input.nextInt() };
                            int[] result = analysis.molecularFromEmpirical(molarMassCompound, molarMassEmpirical, subscripts);
                            for (int subscript : result) {
                                println( Integer.toString(subscript) );
                            }
                            break;

                        default:
                            println("You didn't enter an option.");
                    } // End Analysis
                    break;
                    
                case 2:
                    
                    println("Enter an element:");
                    String element = input.next();
                    List<String> elementInfo = lookup.getElementInfo(element);
                    println("Name: " + elementInfo.get(0) );
                    println("Atomic number: " + elementInfo.get(1) );
                    println("Atomic mass: " + elementInfo.get(3) + " amu" );
                    println("Molar mass: " + elementInfo.get(2) + " g/mol");                   
                    break;
                
                case 42:
                    
                    println("Working...");
                    println("..........");
                    println("..........");
                    println("Secret to life found.");
                    println("Error: could not 0x20 while 0x36 is 0x3D");
                    throw new PrinterIOException(null);

                default:
                    println("Good job, you didn't enter an option.");				
            } // End main menu

            // Now ask if the user wants to start again
            println("Start again? (true/false) ");
            continueLooping = input.nextBoolean();
        } // end loop 
        input.close(); // Don't forget to close the input stream so there's no resource leak
    } // end method
} // end class
