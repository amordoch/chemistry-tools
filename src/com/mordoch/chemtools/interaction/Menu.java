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

package com.mordoch.chemtools.interaction;

import java.util.List;
import java.util.Scanner;

import com.mordoch.chemtools.Main;
import com.mordoch.chemtools.formulatools.FormulaHelper;
import com.mordoch.chemtools.util.Analysis;
import com.mordoch.chemtools.util.Conversion;
import com.mordoch.chemtools.util.LookupTable;

/**
 * This class contains the command-line menu system.
 * 
 * @author Ariel Mordoch
 * @version 1.0
 * @see Main
 * @since 0.6.1-alpha
 */

public class Menu {
  
  private LookupTable lookup = new LookupTable();
  private FormulaHelper parser = new FormulaHelper(lookup);
  private Analysis analysis = new Analysis(lookup, parser);
  private Scanner input = new Scanner(System.in);

  /**
   * The main menu that leads to all other options. All command line functions happen and exit
   * within this method.
   * 
   * @throws InterruptedException if thread was interrupted when showing a warning menu.
   * @since 0.6-alpha
   */

  public void mainMenu() throws InterruptedException {
    System.out.println();
    // Tell the user options and get input
    println("Choose an option:");
    println("0: Conversions");
    println("1: Analysis");
    println("2: Element info");
    println("10: Quit");
    // Now check the option he entered
    switch (input.nextInt()) {

      case 0:
        conversionsMenu();
        break;

      case 1:
        analysisMenu();
        break;

      case 2:

        System.out.println();
        println("Enter an element:");
        String element = input.next();
        // New List to store element info.
        List<String> elementInfo = null;
        // Start looping
        boolean inputIsValid = false;
        while (!inputIsValid) {
          try {
            // Now try getting element info
            elementInfo = lookup.getElementInfo(element);

          } catch (NullPointerException e) {
            // If user entered a non-existent element, try again and get element info. If the user
            // enters
            // a nonexistent element again it will throw a IndexOutOfBounds exception.
            println("Enter a real element this time:");
            String anotherElement = input.next();
            elementInfo = lookup.getElementInfo(anotherElement);

          } finally {
            // Finally, print element info
            println("Name: " + elementInfo.get(0));
            println("Type: " + elementInfo.get(1));
            println("Atomic number: " + elementInfo.get(2));
            println("Atomic mass: " + elementInfo.get(3) + " amu");
            println("Molar mass: " + elementInfo.get(4) + " g/mol");
            // Stop looping
            inputIsValid = true;
          }
        }
        Thread.sleep(2000);
        mainMenu();
        break;

      case 10:
        input.close();
        System.exit(1);

      case 99:
        System.out.println( analysis.molecularFromEmpirical("C1H2O1", 180.156) );
        break;

      default:
        // Start again
        mainMenu();
    }
  } // end mainMenu

  /* CONVERSION MENUS */

  private void conversionsMenu() throws InterruptedException {

    System.out.println();
    println("Choose an option or enter any integer to go back:");
    println("0: Length conversions");
    println("1: Mass conversions");
    println("2: Volume conversions");
    println("3: Molar conversions");

    switch (input.nextInt()) {

      case 0:
        lengthConversionsMenu();
        break;

      case 1:
        massConversionsMenu();
        break;

      case 2:
        volumeConversionsMenu();
        break;

      case 3:
        molarConversionsMenu();
        break;

      default:
        // Return to main menu
        mainMenu();

    }
    mainMenu();

  }

  private void lengthConversionsMenu() throws InterruptedException {

    System.out.println();
    println("Choose a conversion or enter any integer to go back:");
    println("0: Centimeters to meters");
    println("1: Meters to centimeters");
    println("2: Microns to centimeters");
    println("3: Centimeters to microns");
    println("4: Nanometers to microns");
    println("5: Microns to nanometers");
    println("6: Picometers to nanometers");
    println("7: Nanometers to picometers");

    switch (input.nextInt()) {

      case 0:
        // Centimeters to meters
        amount();
        double centimeters = input.nextDouble();
        println(Conversion.centimetersToMeters(centimeters) + " m");
        break;

      case 1:
        // Meters to centimeters
        amount();
        double meters = input.nextDouble();
        println(Conversion.metersToCentimeters(meters) + " cm");
        break;

      case 2:
        // Microns to centimeters
        amount();
        double microns = input.nextDouble();
        println(Conversion.micronsToCentimeters(microns) + " cm");
        break;

      case 3:
        // Centimeters to microns
        amount();
        double centimeters1 = input.nextDouble();
        println(Conversion.centimetersToMicrons(centimeters1) + " microns");
        break;

      case 4:
        // Nanometers to microns
        amount();
        double nanometers = input.nextDouble();
        println(Conversion.nanometersToMicrons(nanometers) + " microns");
        break;

      case 5:
        // Microns to nanometers
        amount();
        double microns1 = input.nextDouble();
        println(Conversion.micronsToNanometers(microns1) + " nm");
        break;

      case 6:
        // Picometers to nanometers
        amount();
        double picometers = input.nextDouble();
        println(Conversion.picometersToNanometers(picometers) + " nm");
        break;

      case 7:
        // Nanometers to picometers
        amount();
        double nanometers1 = input.nextDouble();
        println(Conversion.nanometersToPicometers(nanometers1) + " pm");
        break;

      default:
        // Return to conversions menu
        conversionsMenu();
    }

  }

  private void massConversionsMenu() throws InterruptedException {

    System.out.println();
    println("Choose a conversion or enter any integer to go back: ");
    println("0: Grams to milligrams");
    println("1: Milligrams to grams");
    println("2: Grams to kilograms");
    println("3: Kilograms to grams");
    println("4: amu to grams");
    println("5: Grams to amu");

    switch (input.nextInt()) {

      case 0:
        // Grams to milligrams
        amount();
        double grams = input.nextDouble();
        println(Conversion.gramsToMilligrams(grams) + " mg");
        break;

      case 1:
        // Milligrams to grams
        amount();
        double milligrams = input.nextDouble();
        println(Conversion.milligramsToGrams(milligrams) + " g");
        break;

      case 2:
        // Grams to kilograms
        amount();
        double grams1 = input.nextDouble();
        println(Conversion.gramsToKilograms(grams1) + " kg");
        break;

      case 3:
        // Kilograms to grams
        amount();
        double kilograms = input.nextDouble();
        println(Conversion.kilogramsToGrams(kilograms) + " g");
        break;

      case 4:
        // amus to grams
        amount();
        double amus = input.nextDouble();
        println(Conversion.amuToGram(amus) + " g");
        break;

      case 5:
        // Grams to amus
        amount();
        double grams2 = input.nextDouble();
        println(Conversion.gramToAmu(grams2) + " amu");

      default:
        // Go back to conversions menu
        conversionsMenu();
    }

  }

  private void volumeConversionsMenu() throws InterruptedException {

    System.out.println();
    println("Choose a conversion or enter any integer to go back: ");
    println("0: Liters to milliliters");
    println("1: Milliliters to liters");
    println("2: Liters to kiloliters");
    println("3: Kiloliters to liters");

    switch (input.nextInt()) {

      case 0:
        // Liters to milliliters
        amount();
        double liters = input.nextDouble();
        println(Conversion.litersToMilliliters(liters) + " mL");
        break;

      case 1:
        // Milliliters to liters
        amount();
        double milliliters = input.nextDouble();
        println(Conversion.millilitersToLiters(milliliters) + " L");
        break;

      case 2:
        // Liters to kiloliters
        amount();
        double liters1 = input.nextDouble();
        println(Conversion.litersToKiloliters(liters1) + " kL");
        break;

      case 3:
        // Kiloliters to liters
        amount();
        double kiloliters = input.nextDouble();
        println(Conversion.kilolitersToLiters(kiloliters) + " L");
        break;

      default:
        // Return to conversions menu
        conversionsMenu();

    }

  }

  private void molarConversionsMenu() throws InterruptedException {

    System.out.println();
    println("Choose a conversion or enter any integer to go back:");
    println("0: Grams to mols");
    println("1: Mols to grams");
    println("2: Mols to Atom count");
    println("3: Atom count to mols");

    switch (input.nextInt()) {

      case 0:
        // grams to mols
        println("Enter the mass of an element/formula: ");
        double mass = input.nextDouble();
        println("Enter the molar mass of an element/formula: ");
        double molarMass = input.nextDouble();
        println(Conversion.massToMols(mass, molarMass) + " mols");
        break;

      case 1:
        // mols to grams
        println("Enter the mols of an element/formula: ");
        double mols = input.nextDouble();
        println("Enter the molar mass of an element/formula: ");
        double molarMass1 = input.nextDouble();
        println(Conversion.molsToMass(mols, molarMass1) + " g");
        break;

      case 2:
        // mols to atom count
        println("Enter the mols of an element/formula: ");
        double mols1 = input.nextDouble();
        println(Conversion.molsToAtomCount(mols1) + " atoms");
        break;

      case 3:
        // atom count to mols
        println("Enter the atom count of an element/formula: ");
        double atomCount = input.nextDouble();
        println(Conversion.atomCountToMols(atomCount) + " mols");
        break;

      default:
        // Go back to conversions menu
        conversionsMenu();

    }

  }

  /* ANALYSIS MENUS */

  private void analysisMenu() throws InterruptedException {

    System.out.println();
    warningMenu(1);
    Thread.sleep(1000 * 10);
    System.out.println();
    println("Choose an option or enter any integer to go back:");
    println("0: Empirical formula using percent composition");
    println("1: Empirical formula using mass composition");
    println("2: Molecular formula from empirical formula");
    println("3: Molar mass of a formula");
    println("4: Mass of a formula");
    println("5: Number of atoms in a formula");

    switch (input.nextInt()) {

      case 0:
        empiricalFormulaPercentMenu();
        break;

      case 1:
        empiricalFormulaMassMenu();
        break;

      case 2:
        molecularFormulaMenu();
        break;

      case 3:
        molarMassMenu();
        break;
        
      case 4:
        massMenu();
        break;
        
      case 5:
        numAtomsMenu();
        break;
        
      default:
        // Return to main menu
        mainMenu();

    }
    mainMenu();
  }

  private void empiricalFormulaPercentMenu() throws InterruptedException {
    // Ask the user whether he has 2 or 3 elements
    println("2 or 3 elements? (enter any integer to go back)");
    switch (input.nextInt()) {

      case 2:

        println("Enter an element (1): ");
        String element1 = input.next();
        println("Enter an element (2): ");
        String element2 = input.next();
        println("Enter a percentage for element 1: ");
        double percent1 = input.nextDouble();
        println("Enter a percentage for element 2: ");
        double percent2 = input.nextDouble();
        println(analysis.empiricalFromPercentComposition(percent1, percent2, element1, element2));
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
        println(analysis.empiricalFromPercentComposition(percentOne, percentTwo, percentThree,
            elementOne, elementTwo, elementThree));
        break;

      default:
        // Go back to analysis menu
        analysisMenu();
    }
  }

  private void empiricalFormulaMassMenu() throws InterruptedException {
    // Ask the user whether he has 2 or 3 elements
    println("2 or 3 elements? (enter any integer to go back)");
    switch (input.nextInt()) {

      case 2:

        println("Enter an element (1): ");
        String element1 = input.next();
        println("Enter an element (2): ");
        String element2 = input.next();
        println("Enter a mass for element 1: ");
        double mass1 = input.nextDouble();
        println("Enter a mass for element 2: ");
        double mass2 = input.nextDouble();
        println(analysis.empiricalFromMass(mass1, mass2, element1, element2));
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
        println("Enter a percentage for element 3: ");
        double massThree = input.nextDouble();
        println(analysis.empiricalFromMass(massOne, massTwo, massThree, elementOne, elementTwo,
            elementThree));
        break;

      default:
        // Go back
        analysisMenu();

    }
  }

  private void molecularFormulaMenu() {

    println("Enter a formula:");
    String formula = input.next();
    println("Enter the molar mass of the molecular formula: ");
    double molarMassCompound = input.nextDouble();
    String result = analysis.molecularFromEmpirical(formula, molarMassCompound);
    System.out.println();
    System.out.println(result);

  }

  private void molarMassMenu() {
    println("Enter a formula: ");
    String formula = input.next();
    println(analysis.computeMolarMass(formula) + " g/mol");
  }
  
  private void massMenu() {
    println("Enter a formula: ");
    String formula = input.next();
    println("Enter the moles of that formula: ");
    double moles = input.nextDouble();
    println( analysis.computeMass(formula, moles) + " g" );
  }
  
  private void numAtomsMenu() {
    println("Enter a formula: ");
    String formula = input.next();
    println( analysis.numOfAtoms(formula) + " atoms");
  }
  
  /* WARNINGS */

  private void warningMenu(int desiredWarning) {

    switch (desiredWarning) {
    // Formula syntax
      case 1:
        println("READ THE FOLLOWING CAREFULLY.");
        println("This program only understands "
            + "formulas that are written in a certain syntax. "
            + "A single syntactic mistake will crash this program, so read the following syntax examples carefully.");
        println("C6H12O2 remains C6H12O2");
        println("NaCl remains NaCl");
        println("CO2 becomes C1O2");
        println("H2O becomes H2O1");
        println("2( (NO3)3 ) becomes (2)N3(2)O9 or N6O18 ");
        break;

      default:
        println("There was supposed to be a warning here, but someone forgot to call warningMenu() with a valid int value!");
    }

  }

  /* SHORTCUT METHODS */

  private static void println(String x) {
    System.out.println(x);
  }

  private static void amount() {
    System.out.println("Enter an amount: ");
  }

}
